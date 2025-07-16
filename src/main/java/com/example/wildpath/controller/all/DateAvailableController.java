package com.example.wildpath.controller.all;

import com.example.wildpath.dto.DateAvailableDTO;
import com.example.wildpath.entity.DateAvailable;
import com.example.wildpath.service.DateAvailableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/all/datesavailable")
public class DateAvailableController {

    private final DateAvailableService dateAvailableService;

    public DateAvailableController(DateAvailableService dateAvailableService) {
        this.dateAvailableService = dateAvailableService;
    }

    @GetMapping
    public ResponseEntity<List<DateAvailableDTO>> getAllDatesAvailable() {
        List<DateAvailableDTO> datesAvailable = dateAvailableService.findAll();
        return ResponseEntity.ok(datesAvailable);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<DateAvailable>> getDateAvailableById(@PathVariable Long id) {
        Optional<DateAvailable> foundDateAvailable = dateAvailableService.findById(id);
        return ResponseEntity.ok(foundDateAvailable);
    }

    @GetMapping("/package/{packageId}")
    public ResponseEntity<List<DateAvailableDTO>> getDatesAvailableByPackageId(@PathVariable Long packageId) {
        List<DateAvailableDTO> datesAvailable = dateAvailableService.findByPackageId(packageId);
        return ResponseEntity.ok(datesAvailable);
    }
}
