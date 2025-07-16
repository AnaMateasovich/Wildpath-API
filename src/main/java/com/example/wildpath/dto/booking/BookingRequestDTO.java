package com.example.wildpath.dto.booking;

import com.example.wildpath.dto.UserUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingRequestDTO {

    private Long packageId;
    private Long dateAvailableId;
    private Integer quantityPeople;
    private UserUpdateDTO userInfo;
}
