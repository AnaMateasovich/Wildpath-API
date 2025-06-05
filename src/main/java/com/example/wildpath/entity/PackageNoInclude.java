package com.example.wildpath.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "package_no_includes")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PackageNoInclude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private TravelPackage APackage;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "icon_src")
    private String iconSrc;
}
