package com.example.wildpath.service;

import com.example.wildpath.dto.DateAvailableDTO;
import com.example.wildpath.dto.datesAvailable.BulkDatesAvailableDTO;
import com.example.wildpath.entity.DateAvailable;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.mapper.DateAvailableMapper;
import com.example.wildpath.repository.IDateAvailableRepository;
import com.example.wildpath.repository.ITravelPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DateAvailableService {

    private final IDateAvailableRepository dateAvailableRepository;
    private final ITravelPackageRepository packageRepository;

    public DateAvailableService(IDateAvailableRepository dateAvailableRepository, ITravelPackageRepository packageRepository) {
        this.dateAvailableRepository = dateAvailableRepository;
        this.packageRepository = packageRepository;
    }

    public List<DateAvailableDTO> findAll() {
        List<DateAvailable> dates = dateAvailableRepository.findAll();

        return DateAvailableMapper.toDTOList(dates);
    }

    public Optional<DateAvailable> findById(Long id) {
        return dateAvailableRepository.findById(id);
    }

    public List<DateAvailableDTO> createBulk(List<BulkDatesAvailableDTO> bulkRequests) {
        List<DateAvailable> allDates = new ArrayList<>();

        for (BulkDatesAvailableDTO bulkRequest : bulkRequests) {
            Long packageId = bulkRequest.getPackageId();
            List<DateAvailableDTO> dateDtos = bulkRequest.getDates();

            TravelPackage travelPackage = packageRepository.findById(packageId)
                    .orElseThrow(() -> new RuntimeException("Package not found with ID: " + packageId));

            List<DateAvailable> dateEntities = DateAvailableMapper.toEntityList(dateDtos, travelPackage);
            allDates.addAll(dateEntities);
        }

        List<DateAvailable> savedEntities = dateAvailableRepository.saveAll(allDates);

        return DateAvailableMapper.toDTOList(savedEntities);
    }


    public void deleteById(Long id) {
        dateAvailableRepository.deleteById(id);
    }

    public List<DateAvailableDTO> findByPackageId(Long packageId) {
        List<DateAvailable> dates = dateAvailableRepository.findByAPackage_Id(packageId);
        return DateAvailableMapper.toDTOList(dates);
    }
}
