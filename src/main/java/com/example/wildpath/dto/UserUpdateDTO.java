package com.example.wildpath.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateDTO {
    private String address;
    private String zipcode;
    private String city;
    private String country;
    private Integer phoneNumber;
}
