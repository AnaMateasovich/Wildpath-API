package com.example.wildpath.service;

import com.example.wildpath.dto.DateAvailableDTO;
import com.example.wildpath.entity.DateAvailable;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.repository.IDateAvailableRepository;
import com.example.wildpath.repository.ITravelPackageRepository;
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

    public List<DateAvailable> findAll() {
        return dateAvailableRepository.findAll();
    }

    public Optional<DateAvailable> findById(Long id) {
        return dateAvailableRepository.findById(id);
    }

    public List<DateAvailable> createDateAvailable(List<DateAvailableDTO> requests) {

        List<DateAvailable> savedDatesAvailable = new ArrayList<>();

        for(DateAvailableDTO request : requests) {
            TravelPackage foundPackage = packageRepository.findById(request.getPackageId())
                    .orElseThrow(() -> new RuntimeException("Package not found with id: " + request.getPackageId()));

        DateAvailable newDateAvailable = new DateAvailable();

        newDateAvailable.setDate(request.getDate());
        newDateAvailable.setCapacity(request.getCapacity());
        newDateAvailable.setAPackage(foundPackage);

        savedDatesAvailable.add(newDateAvailable);
        }
        return dateAvailableRepository.saveAll(savedDatesAvailable);
    }

    public void deleteById(Long id) {
        dateAvailableRepository.deleteById(id);
    }

    public List<DateAvailable> findByPackageId(Long packageId) {
        return dateAvailableRepository.findByAPackage_Id(packageId);
    }
}
