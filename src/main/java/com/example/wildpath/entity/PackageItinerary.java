package com.example.wildpath.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "package_itineraries")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PackageItinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private TravelPackage APackage;

    @Column(name = "day")
    private String day;

    @Column(name = "hour")
    private String hour;

    @Lob
    @Column(name = "description")
    private String description;
}
