package com.example.wildpath.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "package_includes")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PackageInclude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private TravelPackage APackage;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "icon_src")
    private String iconSrc;
}
