package com.api.parkingControl.repositories;

import com.api.parkingControl.models.ParkingModel;
import org.springframework.data.jpa.repository.JpaRepository;




public interface ParkingRepository extends JpaRepository<ParkingModel, Long> {

}
