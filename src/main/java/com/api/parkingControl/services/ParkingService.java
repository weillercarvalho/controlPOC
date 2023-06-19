package com.api.parkingControl.services;

import com.api.parkingControl.models.ParkingModel;
import com.api.parkingControl.repositories.ParkingRepository;
import com.api.parkingControl.utils.PasswordUtil;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParkingService {

    final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository repository) {
        this.parkingRepository = repository;
    }
    @Transactional
    public ParkingModel save(ParkingModel parkingModel) {
        parkingModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        parkingModel.setPassword(PasswordUtil.encoder(parkingModel.getPassword()));
        return parkingRepository.save(parkingModel);
    }
}
