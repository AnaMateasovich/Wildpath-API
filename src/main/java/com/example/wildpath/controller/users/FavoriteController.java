package com.example.wildpath.controller.users;

import com.example.wildpath.dto.travelPackageDTOs.TravelPackageDTO;
import com.example.wildpath.entity.User;
import com.example.wildpath.service.FavoriteService;
import com.example.wildpath.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;
    private final UserService userService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService, UserService userService) {
        this.favoriteService = favoriteService;
        this.userService = userService;
    }

    @PostMapping("/{packageId}")
    public ResponseEntity<?> addFavorite(@PathVariable Long packageId, Authentication auth) {
        User user = userService.getUserFromAuth(auth);
        favoriteService.addFavorite(user, packageId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{packageId}")
    public ResponseEntity<?> removeFavorite(@PathVariable Long packageId, Authentication auth) {
        User user = userService.getUserFromAuth(auth);
        favoriteService.removeFavorite(user, packageId);
        return ResponseEntity.ok("Package with id" + packageId + " removed from favorites");
    }

    @GetMapping
    public  ResponseEntity<List<TravelPackageDTO>> getFavorites(Authentication auth) {
        User user = userService.getUserFromAuth(auth);
        List<TravelPackageDTO> favorites = favoriteService.getUserFavorites(user);
        return ResponseEntity.ok(favorites);
    }

    @GetMapping("/{packageId}/check")
    public ResponseEntity<Boolean> isFavorite(@PathVariable Long packageId, Authentication auth) {
        User user = userService.getUserFromAuth(auth);
        boolean isFav = favoriteService.isFavorite(user, packageId);
        return ResponseEntity.ok(isFav);
    }
}
