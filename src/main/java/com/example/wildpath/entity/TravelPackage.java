package com.example.wildpath.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "packages")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    @Column(name = "duration")
    private String duration;

    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Column(name = "location_address")
    private String locationAddress;

    @Column(name = "price_per_person")
    private BigDecimal pricePerPerson;

    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "discount")
    private String discount;

    @Lob
    @Column(name = "cancel_policy")
    private String cancelPolicy;

    @Column(name = "isActive")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "enterprise_id", nullable = false)
    private Enterprise enterprise;

    @OneToMany(mappedBy = "APackage")
    private List<DateAvailable> datesAvailable;

    @OneToMany(mappedBy = "APackage")
    private List<PackageInclude> packageIncludes;

    @OneToMany(mappedBy = "APackage")
    private List<PackageNoInclude> packageNoIncludes;

    @OneToMany(mappedBy = "APackage")
    private List<PackageItinerary> packageItineraries;

    @OneToMany(mappedBy = "APackage", fetch = FetchType.LAZY)
    private List<Image> images;

    @OneToMany(mappedBy = "APackage")
    private List<Requirements> requirements;
}
