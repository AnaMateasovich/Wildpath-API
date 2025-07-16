package com.example.wildpath.service;

import com.example.wildpath.dto.travelPackageDTOs.TravelPackageDTO;
import com.example.wildpath.entity.Favorite;
import com.example.wildpath.entity.TravelPackage;
import com.example.wildpath.entity.User;
import com.example.wildpath.mapper.TravelPackageMapper;
import com.example.wildpath.repository.IFavoriteRepository;
import com.example.wildpath.repository.ITravelPackageRepository;
import com.example.wildpath.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private IFavoriteRepository favoriteRepository;
    @Autowired
    private ITravelPackageRepository travelPackageRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private TravelPackageMapper travelPackageMapper;


    public void addFavorite(User user, Long travelPackageId) {
       TravelPackage travelPackage = travelPackageRepository.findById(travelPackageId)
               .orElseThrow(() -> new RuntimeException("Travel package not found"));


       boolean alreadyExists = favoriteRepository.findByUserAndTravelPackage(user, travelPackage).isPresent();

       if(!alreadyExists) {
           Favorite favorite = new Favorite();
           favorite.setUser(user);
           favorite.setTravelPackage(travelPackage);
           favoriteRepository.save(favorite);
       }
    }

    @Transactional
    public void removeFavorite(User user, Long travelPackageId) {
        TravelPackage travelPackage = travelPackageRepository.findById(travelPackageId)
                .orElseThrow(() -> new RuntimeException("Travel package not found"));
        favoriteRepository.deleteByUserAndTravelPackage(user, travelPackage);
    }

    public List<TravelPackageDTO> getUserFavorites(User user) {
        List<Favorite> favorites = favoriteRepository.findAllByUser(user);
        List<TravelPackage> packages = favorites.stream()
                .map(Favorite::getTravelPackage)
                .toList();
        return travelPackageMapper.toDTOList(packages);
    }

    public Boolean isFavorite(User user, Long packageId) {
        User searchedUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        TravelPackage travelPackage = travelPackageRepository.findById(packageId)
                .orElseThrow(() -> new RuntimeException("Package not found"));

        return favoriteRepository.findByUserAndTravelPackage(searchedUser, travelPackage).isPresent();
    }
}
