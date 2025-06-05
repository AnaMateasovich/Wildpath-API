package com.example.wildpath.service;

import com.example.wildpath.dto.RequirementsDTO;
import com.example.wildpath.dto.TravelPackageDTO;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.entity.Requirements;
import com.example.wildpath.mapper.RequirementsMapper;
import com.example.wildpath.mapper.TravelPackageMapper;
import com.example.wildpath.repository.ITravelPackageRepository;
import com.example.wildpath.repository.IRequirementsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RequirementsService {

    private final IRequirementsRepository requirementsRepository;
    private final ITravelPackageRepository packageRepository;


    public RequirementsService(IRequirementsRepository requirementsRepository, ITravelPackageRepository packageRepository) {
        this.requirementsRepository = requirementsRepository;
        this.packageRepository = packageRepository;
    }

    public List<Requirements> findAll() {
        return requirementsRepository.findAll();
    }

    public List<RequirementsDTO> findAllDTOs() {
        return requirementsRepository.findAll()
                .stream()
                .map(RequirementsMapper::toDTO)
                .collect(Collectors.toList());
    }


    public Optional<Requirements> findById(Long id) {
        return requirementsRepository.findById(id);
    }

    public List<Requirements> createRequirement(List<RequirementsDTO> requests) {
        List<Requirements> savedRequirements = new ArrayList<>();

        for (RequirementsDTO request : requests) {
            TravelPackage foundPackage = packageRepository.findById(request.getPackageId())
                    .orElseThrow(() -> new RuntimeException("Package not found with id: " + request.getPackageId()));

            Requirements newRequirements = new Requirements();

            newRequirements.setAPackage(foundPackage);
            newRequirements.setTitle(request.getTitle());
            newRequirements.setDescription(request.getDescription());

            savedRequirements.add(newRequirements);
        }


        return requirementsRepository.saveAll(savedRequirements);
    }

    public void deleteById(Long id) {
        requirementsRepository.deleteById(id);
    }

    public List<Requirements> findByPackageId(Long packageId) {
        return requirementsRepository.findByAPackage_Id(packageId);
    }
}
