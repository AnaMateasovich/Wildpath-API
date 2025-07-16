package com.example.wildpath.mapper;


import com.example.wildpath.dto.*;
import com.example.wildpath.dto.travelPackageDTOs.RequestPaginatedDTO;
import com.example.wildpath.dto.travelPackageDTOs.ResponsePaginatedDTO;
import com.example.wildpath.dto.travelPackageDTOs.TravelPackageDTO;
import com.example.wildpath.entity.*;
import com.example.wildpath.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TravelPackageMapper {

    private final IImageRepository imageRepository;
    private final ICategoryRepository categoryRepository;
    private final IPlaceRepository placeRepository;
    private final IDateAvailableRepository dateAvailableRepository;
    private final IReviewRepository reviewRepository;

    @Autowired
    public TravelPackageMapper(IImageRepository imageRepository,
                               ICategoryRepository categoryRepository,
                               IPlaceRepository placeRepository,
                               IDateAvailableRepository dateAvailableRepository, IReviewRepository reviewRepository) {
        this.imageRepository = imageRepository;
        this.categoryRepository = categoryRepository;
        this.placeRepository = placeRepository;
        this.dateAvailableRepository = dateAvailableRepository;
        this.reviewRepository = reviewRepository;
    }

    public static TravelPackage toEntity(TravelPackageDTO dto, Category category, Place place, Enterprise enterprise) {
        TravelPackage p = new TravelPackage();
        p.setName(dto.getName());
        p.setCategory(category);
        p.setPlace(place);
        p.setDuration(convertToISODuration(dto.getDurationData()));
        p.setNights(dto.getDurationData().getNights());
        p.setLatitude(dto.getLatitude());
        p.setLongitude(dto.getLongitude());
        p.setLocationAddress(dto.getLocationAddress());
        p.setPricePerPerson(dto.getPricePerPerson());
        p.setDifficulty(dto.getDifficulty());
        p.setDescription(dto.getDescription());
        p.setDiscount(dto.getDiscount());
        p.setCancelPolicy(dto.getCancelPolicy());
        p.setIsActive(dto.getIsActive());
        p.setEnterprise(enterprise);
        return p;
    }

    public TravelPackageDTO toDTO(TravelPackage entity) {
        TravelPackageDTO dto = new TravelPackageDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setReadableDuration(formatDuration(entity.getDuration(), entity.getNights()));
        dto.setLocationAddress(entity.getLocationAddress());
        dto.setPricePerPerson(entity.getPricePerPerson());
        dto.setDifficulty(entity.getDifficulty());
        dto.setDescription(entity.getDescription());
        dto.setDiscount(entity.getDiscount());
        dto.setIsActive(entity.getIsActive());
        dto.setCancelPolicy(entity.getCancelPolicy());

        List<ImageDTO> images = entity.getImages().stream()
                .map(ImageMapper::toDTO)
                .toList();
        dto.setImages(images);

        List<DateAvailableDTO> dateAvailable = entity.getDatesAvailable().stream()
                .map(DateAvailableMapper::toDTO)
                .toList();
        dto.setDatesAvailable(dateAvailable);

        List<RequirementsDTO> requirements = entity.getRequirements().stream()
                .map(RequirementsMapper::toDTO)
                .toList();
        dto.setRequirements(requirements);

        List<PackageIncludeDTO> packageIncludeDTOS = entity.getPackageIncludes().stream()
                .map(PackageIncludesMapper::toDTO)
                .toList();
        dto.setPackageIncludes(packageIncludeDTOS);

        dto.setCategoryId(entity.getCategory().getId());
        dto.setPlaceId(entity.getPlace().getId());
        dto.setEnterpriseId(entity.getEnterprise().getId());

        Double avg = reviewRepository.findAverageRatingByTravelPackageId(entity.getId());
        dto.setAverageStars(avg != null ? Math.round(avg * 10.0) / 10.0 : 0.0);

        Integer totalReviews = reviewRepository.countByTravelPackageId(dto.getId());
        int totalReviewsCount = totalReviews != null ? totalReviews : 0;

        dto.setTotalReviews(totalReviewsCount);

        dto.setCategoryName(entity.getCategory().getName());
        dto.setPlaceName(entity.getPlace().getName());
        dto.setEnterpriseName(entity.getEnterprise().getName());

        return dto;
    }

    public List<TravelPackageDTO> toDTOList(List<TravelPackage> packages) {
        return packages.stream()
                .map(this::toDTO)
                .toList();
    }

    public List<ResponsePaginatedDTO> toResponseDTOList(List<RequestPaginatedDTO> dtos) {
        // Get all packagesIds, categoriesIds, placesIds
        List<Long> packageIds = dtos.stream().map(RequestPaginatedDTO::getId).toList();
        List<Long> categoryIds = dtos.stream().map(RequestPaginatedDTO::getCategoryId).distinct().toList();
        List<Long> placeIds = dtos.stream().map(RequestPaginatedDTO::getPlaceId).distinct().toList();

        // get all images from all packages with just one query
        Map<Long, List<ImageDTO>> imagesByPackageId = imageRepository.findImagesByPackageIds(packageIds)
                .stream()
                .map(ImageMapper::toDTO)
                .collect(Collectors.groupingBy(ImageDTO::getPackageId));

        Map<Long, String> categoryNames = categoryRepository.findByIdIn(categoryIds)
                .stream()
                .collect(Collectors.toMap(Category::getId, Category::getName));

        Map<Long, String> placeNames = placeRepository.findByIdIn(placeIds)
                .stream()
                .collect(Collectors.toMap(Place::getId, Place::getName));

        Map<Long, List<DateAvailableDTO>> datesByPackageId = dateAvailableRepository.findByPackageIds(packageIds)
                .stream()
                .map(DateAvailableMapper::toDTO)
                .collect(Collectors.groupingBy(DateAvailableDTO::getPackageId));


        // mapper all packages a ResponsePaginatedDTO
        return dtos.stream().map(dto -> {
            List<ImageDTO> images = imagesByPackageId.getOrDefault(dto.getId(), List.of());
            List<DateAvailableDTO> datesAvailable = datesByPackageId.getOrDefault(dto.getId(), List.of());

            String categoryName = categoryNames.getOrDefault(dto.getCategoryId(), "Uncategorized");
            String placeName = placeNames.getOrDefault(dto.getPlaceId(), "No assigned place");

            String durationLegible = formatDuration(dto.getDuration(), dto.getNights());

            Double avg = reviewRepository.findAverageRatingByTravelPackageId(dto.getId());
            double averageStars = avg != null ? Math.round(avg * 10.0) / 10.0 : 0.0;

            Integer totalReviews = reviewRepository.countByTravelPackageId(dto.getId());
            int totalReviewsCount = totalReviews != null ? totalReviews : 0;


            return new ResponsePaginatedDTO(
                    dto.getId(),
                    dto.getName(),
                    categoryName,
                    placeName,
                    durationLegible,
                    dto.getDescription(),
                    dto.getLocationAddress(),
                    dto.getPricePerPerson(),
                    dto.getDiscount(),
                    images,
                    datesAvailable,
                    averageStars,
                    totalReviewsCount
            );
        }).toList();
    }

    private static String formatDuration(String isoString, Integer nights) {
        if (isoString == null || isoString.isBlank()) return "No specified duration";
        try {
            Duration duration = Duration.parse(isoString);
            long days = duration.toDays();
            long hours = duration.minusDays(days).toHours();
            long minutes = duration.minusDays(days).minusHours(hours).toMinutes();

            StringBuilder sb = new StringBuilder();
            if (days > 0) sb.append(days).append(days == 1 ? " día" : " días");
            if (hours > 0) sb.append(hours).append(" h");
            if (minutes > 0) sb.append(minutes).append(" min");
            if (nights != null && nights > 0)
                sb.append(" / ").append(nights).append(nights == 1 ? " noche" : " noches");

            return sb.toString().trim();
        } catch (Exception e) {
            return "Unknown format";
        }
    }

    private static String convertToISODuration(DurationInputDTO dto) {
        int days = dto.getDays() != null ? dto.getDays() : 0;
        int hours = dto.getHours() != null ? dto.getHours() : 0;
        int minutes = dto.getMinutes() != null ? dto.getMinutes() : 0;

        Duration duration = Duration.ofDays(days).plusHours(hours).plusMinutes(minutes);
        return duration.toString();
    }

}