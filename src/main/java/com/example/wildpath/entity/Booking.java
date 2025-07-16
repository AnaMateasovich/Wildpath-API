package com.example.wildpath.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookingStatus status;

    @Column(name = "quantity_people")
    private Integer quantityPeople;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    @ManyToOne
    private User user;

    @ManyToOne
    private TravelPackage travelPackage;

    @ManyToOne
    private DateAvailable dateAvailable;
}
