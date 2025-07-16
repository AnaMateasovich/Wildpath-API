package com.example.wildpath.service;

import com.example.wildpath.dto.ImageDTO;
import com.example.wildpath.entity.Image;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.mapper.ImageMapper;
import com.example.wildpath.repository.IImageRepository;
import com.example.wildpath.repository.ITravelPackageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ImageService {

    private final IImageRepository imageRepository;
    private final ITravelPackageRepository packageRepository;


    public ImageService(IImageRepository imageRepository, ITravelPackageRepository packageRepository) {
        this.imageRepository = imageRepository;
        this.packageRepository = packageRepository;
    }

    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    public List<ImageDTO> findAllImagesDTOs(List<Image> images) {
        return images.stream()
                .map(ImageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }

    public ImageDTO findImageDTOById(Long id) {
        Image foundImage = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));

        return ImageMapper.toDTO(foundImage);
    }

    public void uploadImages(MultipartFile[] files, Long packageId) {

        if (files == null || files.length == 0) {
            throw new IllegalArgumentException("No files uploaded");
        }
        TravelPackage foundPackage = packageRepository.findById(packageId)
                .orElseThrow(() -> new RuntimeException("Package not found"));

        // Crear el directorio si no existe
        String uploadDir = System.getProperty("user.dir") + "/uploads/packages/";
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            // Guardar el archivo
            String originalFilename = file.getOriginalFilename();
            String newFilename = UUID.randomUUID().toString() + "_" + originalFilename;

            Path path = Paths.get(uploadDir + newFilename);

            try {
                Files.write(path, file.getBytes());

            } catch (Exception e) {
                throw new RuntimeException("Error saving the file", e);
            }

            // Crear y guardar la entidad Image

            Image image = new Image();
            image.setName(originalFilename);
            image.setSrc("/uploads/packages/" + newFilename);
            image.setAPackage(foundPackage);
            imageRepository.save(image);
        }


    }


    public List<Image> findByPackageId(Long packageId) {
        return imageRepository.findByAPackage_Id(packageId);
    }

    public Map<Long, List<ImageDTO>> findImagesGroupedByPackageIds(List<Long> packageIds) {
        return imageRepository.findImagesByPackageIds(packageIds).stream()
                .map(ImageMapper::toDTO)
                .collect(Collectors.groupingBy(ImageDTO::getPackageId));
    }

    public List<ImageDTO> findImagesDTOsByPackageId(Long packageId) {
        List<Image> foundImages = imageRepository.findByAPackage_Id(packageId);

        return foundImages.stream()
                .map(ImageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));

        // Borrar el archivo físico
        String uploadDir = "uploads/";
        Path filePath = Paths.get(uploadDir + image.getSrc());

        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete image file", e);
        }

        // Borrar el registro en base de datos
        imageRepository.deleteById(id);
    }
}
