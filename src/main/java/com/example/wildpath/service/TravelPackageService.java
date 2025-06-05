package com.example.wildpath.service;

import com.example.wildpath.dto.TravelPackageDTO;
import com.example.wildpath.entity.Category;
import com.example.wildpath.entity.Enterprise;
import com.example.wildpath.entity.Place;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.mapper.TravelPackageMapper;
import com.example.wildpath.repository.ICategoryRepository;
import com.example.wildpath.repository.IEnterpriseRepository;
import com.example.wildpath.repository.IPlaceRepository;
import com.example.wildpath.repository.ITravelPackageRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TravelPackageService {

    private final ITravelPackageRepository packageRepository;
    private final ICategoryRepository categoryRepository;
    private final IPlaceRepository placeRepository;
    private final IEnterpriseRepository enterpriseRepository;

    public TravelPackageService(ITravelPackageRepository packageRepository, ICategoryRepository categoryRepository, IPlaceRepository placeRepository, IEnterpriseRepository enterpriseRepository) {
        this.packageRepository = packageRepository;
        this.categoryRepository = categoryRepository;
        this.placeRepository = placeRepository;
        this.enterpriseRepository = enterpriseRepository;
    }

    public List<TravelPackage> findAll() {
        return packageRepository.findAll();
    }

    public List<TravelPackageDTO> findAllDTOs() {
        return packageRepository.findAll()
                .stream()
                .map(TravelPackageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Page<TravelPackageDTO> findAllPageable(Pageable pageable) {
        return packageRepository.findAll(pageable)
                .map(TravelPackageMapper::toDTO);
    }

    public List<TravelPackageDTO> find10Random() {
        List<TravelPackage> randomPackages = packageRepository.findRandom10();
        return randomPackages.stream()
                .map(TravelPackageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TravelPackage> findById(Long id) {
        return packageRepository.findById(id);
    }

    public Optional<TravelPackageDTO> findDTOById(Long id) {
        return packageRepository.findById(id)
                .map(TravelPackageMapper::toDTO);
    }

    public boolean nameExists(String name) {
        return packageRepository.existsByName(name);
    }

    @Transactional
    public Optional<TravelPackage> createFromDTO(TravelPackageDTO dto) {
        Optional<Category> categoryOpt = categoryRepository.findById(dto.getCategoryId());
        Optional<Place> placeOpt = placeRepository.findById(dto.getPlaceId());
        Optional<Enterprise> enterpriseOpt = enterpriseRepository.findById(dto.getEnterpriseId());

        if(categoryOpt.isEmpty() || placeOpt.isEmpty() || enterpriseOpt.isEmpty()) {
            return Optional.empty();
        }

        TravelPackage p = TravelPackageMapper.toEntity(dto, categoryOpt.get(), placeOpt.get(), enterpriseOpt.get());

        return Optional.of(packageRepository.save(p));
    }

    public void deleteById(Long id) {
        packageRepository.deleteById(id);
    }

    public void updateCategory (Long packageId, Long newCategoryId) {
        TravelPackage travelPackage = packageRepository.findById(packageId)
                .orElseThrow(() -> new RuntimeException("Package not found"));

        Category category = categoryRepository.findById(newCategoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        travelPackage.setCategory(category);
        packageRepository.save(travelPackage);
    }

    public TravelPackageDTO togglePackageStatus(Long id) {
        TravelPackage entity = packageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found"));

        entity.setIsActive(!entity.getIsActive());

        packageRepository.save(entity);

        return TravelPackageMapper.toDTO(entity);
    }
}
