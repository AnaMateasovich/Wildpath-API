package com.example.wildpath.service;

import com.example.wildpath.dto.PackageIncludeDTO;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.entity.PackageInclude;
import com.example.wildpath.repository.IPackageIncludeRepository;
import com.example.wildpath.repository.ITravelPackageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PackageIncludesService {

    private final IPackageIncludeRepository packageIncludeRepository;
    private final ITravelPackageRepository packageRepository;

    public PackageIncludesService(IPackageIncludeRepository packageIncludeRepository, ITravelPackageRepository packageRepository) {
        this.packageIncludeRepository = packageIncludeRepository;
        this.packageRepository = packageRepository;
    }

    public List<PackageInclude> findAll() {
        return packageIncludeRepository.findAll();
    }

    public Optional<PackageInclude> findById(Long id) {
        return packageIncludeRepository.findById(id);
    }

    public List<PackageInclude> createMultiplePackageInclude(List<PackageIncludeDTO> requests, List<MultipartFile> iconFiles) {

        // Guardar el icono
        String uploadDir = System.getProperty("user.dir") + "/uploads/icons/";
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        List<PackageInclude> includes = new ArrayList<>();

        for (int i = 0; i < requests.size(); i++) {
            PackageIncludeDTO request = requests.get(i);
            MultipartFile iconFile = iconFiles.get(i);

            TravelPackage foundPackage = packageRepository.findById(request.getPackageId())
                    .orElseThrow(() -> new RuntimeException("Package not found with id: " + request.getPackageId()));
            String originalFilename = iconFile.getOriginalFilename();
            String newFilename = UUID.randomUUID() + "_" + originalFilename;
            Path path = Paths.get(uploadDir + newFilename);
            try {
                Files.write(path, iconFile.getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Failed to save icon", e);
            }
            PackageInclude include = new PackageInclude();
            include.setAPackage(foundPackage);
            include.setDescription(request.getDescription());
            include.setIconSrc("/uploads/icons/" + newFilename);

            includes.add(include);
        }

        return packageIncludeRepository.saveAll(includes);
    }

    public void deleteById(Long id) {
        packageIncludeRepository.deleteById(id);
    }

    public List<PackageInclude> findByPackageId(Long packageId) {
        return packageIncludeRepository.findByAPackage_Id(packageId);
    }
}
