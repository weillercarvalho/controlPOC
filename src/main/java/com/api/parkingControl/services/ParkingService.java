package com.api.parkingControl.services;

import com.api.parkingControl.repositories.ParkingRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    final ParkingRepository repository;

    public ParkingService(ParkingRepository repository) {
        this.repository = repository;
    }
}
