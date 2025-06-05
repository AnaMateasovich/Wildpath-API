package com.example.wildpath.service;

import com.example.wildpath.dto.PackageNoIncludeDTO;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.entity.PackageNoInclude;
import com.example.wildpath.repository.IPackageNoIncludeRepository;
import com.example.wildpath.repository.ITravelPackageRepository;
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
public class PackageNoIncludesService {

    private final IPackageNoIncludeRepository packageNoIncludeRepository;
    private final ITravelPackageRepository packageRepository;

    public PackageNoIncludesService(IPackageNoIncludeRepository packageNoIncludeRepository, ITravelPackageRepository packageRepository) {
        this.packageNoIncludeRepository = packageNoIncludeRepository;
        this.packageRepository = packageRepository;
    }

    public List<PackageNoInclude> findAll() {
        return packageNoIncludeRepository.findAll();
    }

    public Optional<PackageNoInclude> findById(Long id) {
        return packageNoIncludeRepository.findById(id);
    }

    public PackageNoInclude createPackageNoInclude(PackageNoIncludeDTO request, MultipartFile iconFile) {
        TravelPackage foundPackage = packageRepository.findById(request.getPackageId()).orElseThrow(() -> new RuntimeException("Package not found"));

        // Save icon
        String uploadDir = System.getProperty("user.dir") + "/uploads/icons/";
        File directory = new File(uploadDir);
        if(!directory.exists()) {
            directory.mkdirs();
        }

        String originalFilename = iconFile.getOriginalFilename();
        String newFilename = UUID.randomUUID() + "_" + originalFilename;
        Path path = Paths.get(uploadDir + newFilename);

        try {
            Files.write(path, iconFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Filed to save icon",e);
        }

        PackageNoInclude newPackageNoInclude = new PackageNoInclude();
        newPackageNoInclude.setAPackage(foundPackage);
        newPackageNoInclude.setDescription(request.getDescription());
        newPackageNoInclude.setIconSrc(newFilename);

        return packageNoIncludeRepository.save(newPackageNoInclude);
    }

    public void deleteById(Long id) {
        packageNoIncludeRepository.deleteById(id);
    }

    public List<PackageNoInclude> findByPackageId(Long packageId) {
        return packageNoIncludeRepository.findByAPackage_Id(packageId);
    }
}
