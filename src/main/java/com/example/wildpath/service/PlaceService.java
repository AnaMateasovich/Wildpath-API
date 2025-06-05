package com.example.wildpath.service;

import com.example.wildpath.dto.PlaceDTO;
import com.example.wildpath.entity.Place;
import com.example.wildpath.repository.IPlaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlaceService {

    private final IPlaceRepository placeRepository;

    public PlaceService(IPlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    public Optional<Place> findById(Long id) {
        return placeRepository.findById(id);
    }

    public Place createPlace(PlaceDTO dto, MultipartFile image) {
        String  uploadDir = System.getProperty("user.dir") + "/uploads/places";
        File directory = new File(uploadDir);
        if(!directory.exists()) {
            directory.mkdirs();
        }

        String fileName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
        Path path = Paths.get(uploadDir, fileName);

        try {
            Files.write(path, image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image", e);
        }

        Place place = new Place();
        place.setName(dto.getName());
        place.setDescription(dto.getDescription());
        place.setSrc("/uploads/places/" + fileName);

        return placeRepository.save(place);
    }

    public void deleteById(Long id) {
        placeRepository.deleteById(id);
    }
}
