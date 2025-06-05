package com.example.wildpath.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "date_available")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DateAvailable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "package_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_package",
            foreignKeyDefinition = "FOREIGN KEY (package_id) REFERENCES packages(id) ON DELETE CASCADE"))
    private TravelPackage APackage;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "capacity")
    private Integer capacity;
}
