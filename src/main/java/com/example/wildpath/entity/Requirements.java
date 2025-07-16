package com.example.wildpath.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "requirements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Requirements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private TravelPackage APackage;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
