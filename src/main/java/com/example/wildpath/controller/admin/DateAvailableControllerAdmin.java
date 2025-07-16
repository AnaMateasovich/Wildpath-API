package com.example.wildpath.controller.admin;

import com.example.wildpath.dto.DateAvailableDTO;
import com.example.wildpath.dto.datesAvailable.BulkDatesAvailableDTO;
import com.example.wildpath.entity.DateAvailable;
import com.example.wildpath.service.DateAvailableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/datesavailable")
public class DateAvailableControllerAdmin {

    private final DateAvailableService dateAvailableService;

    public DateAvailableControllerAdmin(DateAvailableService dateAvailableService) {
        this.dateAvailableService = dateAvailableService;
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<DateAvailableDTO>> createBulk(@RequestBody List<BulkDatesAvailableDTO> bulkList) {
        List<DateAvailableDTO> result = dateAvailableService.createBulk(bulkList);
        return ResponseEntity.ok(result);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDateAvailable(@PathVariable Long id) {
        dateAvailableService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
