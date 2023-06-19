package com.api.parkingControl.models;

import com.api.parkingControl.dto.ParkingDTO;
import com.api.parkingControl.utils.PasswordUtil;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@Table(name = "TB_PARKING")
public class ParkingModel {
    public ParkingModel(@NotNull ParkingDTO data) {
        this.parkingSpotNumber = data.parkingSpotNumber();
        this.licensePlateCar = data.licensePlateCar();
        this.brandCar = data.brandCar();
        this.colorCar = data.colorCar();
        this.modelCar = data.modelCar();
        this.responsibleName = data.responsibleName();
        this.apartment = data.apartment();
        this.block = data.block();
        this.password = data.password();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String parkingSpotNumber;
    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;
    @Column(nullable = false)
    private String brandCar;
    @Column(nullable = false)
    private String modelCar;
    @Column(nullable = false)
    private String colorCar;
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    @Column(nullable = false)
    private String responsibleName;
    @Column(nullable = false)
    private String apartment;
    @Column(nullable = false)
    private String block;
    @Column(nullable = false)
    private String password;

}
