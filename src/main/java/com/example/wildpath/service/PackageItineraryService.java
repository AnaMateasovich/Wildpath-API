package com.example.wildpath.service;

import com.example.wildpath.dto.PackageItineraryDTO;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.entity.PackageItinerary;
import com.example.wildpath.repository.IPackageItineraryRepository;
import com.example.wildpath.repository.ITravelPackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageItineraryService {

    private final IPackageItineraryRepository packageItineraryRepository;
    private final ITravelPackageRepository packageRepository;

    public PackageItineraryService(IPackageItineraryRepository packageItineraryRepository, ITravelPackageRepository packageRepository) {
        this.packageItineraryRepository = packageItineraryRepository;
        this.packageRepository = packageRepository;
    }


    public List<PackageItinerary> findAll() {
        return packageItineraryRepository.findAll();
    }

    public Optional<PackageItinerary> findById(Long id) {
        return packageItineraryRepository.findById(id);
    }

    public PackageItinerary createPackageItinerary(PackageItineraryDTO request) {
        Optional<TravelPackage> aPackage = packageRepository.findById(request.getPackageId());

        TravelPackage foundPackage = aPackage.orElseThrow(() -> new RuntimeException("Package not found"));

        PackageItinerary newPackageItinerary = new PackageItinerary();
        newPackageItinerary.setAPackage(foundPackage);
        newPackageItinerary.setDay(request.getDay());
        newPackageItinerary.setHour(request.getHour());
        newPackageItinerary.setDescription(request.getDescription());

        return packageItineraryRepository.save(newPackageItinerary);
    }

    public void deleteById(Long id) {
        packageItineraryRepository.deleteById(id);
    }

    public List<PackageItinerary> findByPackageId(Long packageId) {
        return packageItineraryRepository.findByAPackage_Id(packageId);
    }
}
