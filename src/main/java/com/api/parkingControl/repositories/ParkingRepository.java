package com.api.parkingControl.repositories;

import com.api.parkingControl.models.ParkingModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;


public interface ParkingRepository extends JpaRepository<ParkingModel, UUID> {
}
