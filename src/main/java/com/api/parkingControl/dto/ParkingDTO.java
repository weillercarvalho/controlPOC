package com.api.parkingControl.dto;

import jakarta.validation.constraints.NotBlank;

public record ParkingDTO(
        @NotBlank
        String parkingSpotNumber,
        @NotBlank
        String licensePlateCar,
        @NotBlank
        String brandCar,
        @NotBlank
        String modelCar,
        @NotBlank
        String responsibleName,
        @NotBlank
        String apartment,
        @NotBlank
        String block,
        @NotBlank
        String password
) {
}
