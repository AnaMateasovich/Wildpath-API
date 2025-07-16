package com.example.wildpath.controller.admin;

import com.example.wildpath.dto.PackageIncludeDTO;
import com.example.wildpath.entity.PackageInclude;
import com.example.wildpath.service.PackageIncludesService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/admin/includes")
public class PackageIncludeControllerAdmin {

    private final PackageIncludesService packageIncludesService;

    public PackageIncludeControllerAdmin(PackageIncludesService packageIncludesService) {
        this.packageIncludesService = packageIncludesService;
    }

    @PostMapping(value= "/bulk", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<PackageInclude>> createPackageInclude(@RequestPart("data") List<PackageIncludeDTO> requests,
                                                                     @RequestPart("icon") List<MultipartFile> iconFiles) {

        if(requests.size() != iconFiles.size()) {
            return ResponseEntity.badRequest().build();
        }

        List<PackageInclude> createdIncludes = packageIncludesService.createMultiplePackageInclude(requests, iconFiles);
        return ResponseEntity.ok(createdIncludes);
    }

    @PatchMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PackageIncludeDTO> updatePackageInclude(@PathVariable Long id,
                                                                  @RequestPart("data") PackageIncludeDTO dto,
                                                                  @RequestPart(value = "icon", required = false) MultipartFile iconFile) {

        PackageInclude updateInclude = packageIncludesService.updatePackageInclude(dto, iconFile);

        PackageIncludeDTO responseDTO = new PackageIncludeDTO();
        responseDTO.setPackageId(updateInclude.getAPackage().getId());
        responseDTO.setId(updateInclude.getId());
        responseDTO.setDescription(updateInclude.getDescription());
        responseDTO.setIconSrc(updateInclude.getIconSrc());

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackageInclude(@PathVariable Long id) {
        packageIncludesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
