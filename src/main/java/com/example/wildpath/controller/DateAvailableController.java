package com.example.wildpath.controller;

import com.example.wildpath.dto.DateAvailableDTO;
import com.example.wildpath.entity.DateAvailable;
import com.example.wildpath.service.DateAvailableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/datesavailable")
public class DateAvailableController {

    private final DateAvailableService dateAvailableService;

    public DateAvailableController(DateAvailableService dateAvailableService) {
        this.dateAvailableService = dateAvailableService;
    }

    @PostMapping
    public ResponseEntity<List<DateAvailable>> createDateAvailable(@RequestBody List<DateAvailableDTO> requests) {
        List<DateAvailable> createdDatesAvailable = dateAvailableService.createDateAvailable(requests);
        return ResponseEntity.ok(createdDatesAvailable);
    }

    @GetMapping
    public  ResponseEntity<List<DateAvailable>> getAllDateAvailables() {
        List<DateAvailable> dateAvailables = dateAvailableService.findAll();
        return ResponseEntity.ok(dateAvailables);
    }

     @GetMapping("/id/{id}")
    public ResponseEntity<Optional<DateAvailable>> getDateAvailableById(@PathVariable Long id) {
        Optional<DateAvailable> foundDateAvailable = dateAvailableService.findById(id);
        return ResponseEntity.ok(foundDateAvailable);
    }

    @GetMapping("/package/{packageId}")
    public ResponseEntity<List<DateAvailable>> getDateAvailableByPackageId(@PathVariable Long packageId) {
        List<DateAvailable> dateAvailables = dateAvailableService.findByPackageId(packageId);
        return ResponseEntity.ok(dateAvailables);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDateAvailable(@PathVariable Long id) {
        dateAvailableService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
