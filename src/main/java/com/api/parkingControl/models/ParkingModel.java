package com.api.parkingControl.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@Table(name = "TB_PARKING")
public class ParkingModel {
    public ParkingModel(String parkingSpotNumber, String licensePlateCar, String brandCar, String modelCar, String colorCar, String responsibleName, String apartment, String block, String password) {
        this.hashPassword = password;
        this. parkingSpotNumber = parkingSpotNumber;
        this.licensePlateCar = licensePlateCar;
        this.brandCar = brandCar;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.responsibleName = responsibleName;
        this.apartment = apartment;
        this.block = block;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
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
    private String hashPassword;

}
