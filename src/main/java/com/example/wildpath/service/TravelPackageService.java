package com.example.wildpath.service;

import com.example.wildpath.dto.travelPackageDTOs.RequestPaginatedDTO;
import com.example.wildpath.dto.travelPackageDTOs.ResponsePaginatedDTO;
import com.example.wildpath.dto.travelPackageDTOs.TravelPackageDTO;
import com.example.wildpath.entity.*;
import com.example.wildpath.mapper.TravelPackageMapper;
import com.example.wildpath.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TravelPackageService {

    private final ITravelPackageRepository packageRepository;
    private final ICategoryRepository categoryRepository;
    private final IPlaceRepository placeRepository;
    private final IEnterpriseRepository enterpriseRepository;
    @Autowired
    private TravelPackageMapper packageMapper;



    public TravelPackageService(ITravelPackageRepository packageRepository,
                                ICategoryRepository categoryRepository,
                                IPlaceRepository placeRepository,
                                IEnterpriseRepository enterpriseRepository) {
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
                .map(packageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Page<ResponsePaginatedDTO> findAllPageable(Pageable pageable) {
       Page<RequestPaginatedDTO> basePage = packageRepository.findAllDTOs(pageable);

       List<ResponsePaginatedDTO> packages = packageMapper.toResponseDTOList(basePage.getContent());

       return new PageImpl<>(packages, pageable, basePage.getTotalElements());
    }

    public List<TravelPackageDTO> find10Random() {
        List<TravelPackage> randomPackages = packageRepository.findRandom10();

        return randomPackages.stream()
                .map(packageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<String> getLocationSuggestions(String query) {
        return packageRepository.findLocationSuggestions(query);
    }

    public List<ResponsePaginatedDTO> searchFilteredPackages(Long categoryId, String location, LocalDate startDate, LocalDate endDate) {
        List<RequestPaginatedDTO> dtos = packageRepository.searchFiltered(categoryId, location, startDate, endDate);

        return packageMapper.toResponseDTOList(dtos);
    }

    public Optional<TravelPackage> findById(Long id) {
        return packageRepository.findById(id);
    }

    public Optional<TravelPackageDTO> findDTOById(Long id) {
        return packageRepository.findById(id)
                .map(packageMapper::toDTO);
    }

    public boolean nameExists(String name) {
        return packageRepository.existsByNameIgnoreCase(name.trim());
    }

    @Transactional
    public Optional<TravelPackage> createFromDTO(TravelPackageDTO dto) {
        Optional<Category> categoryOpt = categoryRepository.findById(dto.getCategoryId());
        Optional<Place> placeOpt = placeRepository.findById(dto.getPlaceId());
        Optional<Enterprise> enterpriseOpt = enterpriseRepository.findById(dto.getEnterpriseId());

        if (categoryOpt.isEmpty() || placeOpt.isEmpty() || enterpriseOpt.isEmpty()) {
            return Optional.empty();
        }

        TravelPackage p = TravelPackageMapper.toEntity(dto, categoryOpt.get(), placeOpt.get(), enterpriseOpt.get());

        return Optional.of(packageRepository.save(p));
    }

    public void deleteById(Long id) {
        packageRepository.deleteById(id);
    }

    public void updateCategory(Long packageId, Long newCategoryId) {
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

        return packageMapper.toDTO(entity);
    }

    public List<TravelPackageDTO> getPackagesByCategory(Long categoryId) {
        List<TravelPackage> entities = packageRepository.findByCategoryId(categoryId);
        return packageMapper.toDTOList(entities);
    }

    public List<TravelPackageDTO> searchPackageByName(String name) {
        List<TravelPackage> packages = packageRepository.findByNameContainingIgnoreCase(name);
        return packageMapper.toDTOList(packages);
    }

}
