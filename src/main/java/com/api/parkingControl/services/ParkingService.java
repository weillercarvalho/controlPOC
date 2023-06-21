package com.api.parkingControl.services;

import com.api.parkingControl.errors.NotFoundException;
import com.api.parkingControl.models.ParkingModel;
import com.api.parkingControl.repositories.ParkingRepository;
import com.api.parkingControl.utils.PasswordUtil;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParkingService {
    
    @Autowired
    private ParkingRepository parkingRepository;

    @Transactional
    public ParkingModel save(ParkingModel parkingModel) {
        parkingModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        parkingModel.setPassword(PasswordUtil.encoder(parkingModel.getPassword()));
        return parkingRepository.save(parkingModel);
    }
    public List<ParkingModel> getAll() {
        return parkingRepository.findAll();
    }
    public ParkingModel getOne(Long id) {
        Optional<ParkingModel> response = parkingRepository.findById(id);
        if (!response.isPresent()) {
            throw new NotFoundException("Parking Spot not found");
        }
        return response.get();
    }
    @Transactional
    public String deleteParking(long id) {
        Optional<ParkingModel> response = parkingRepository.findById(id);
        if (!response.isPresent()) {
            throw new NotFoundException("Parking Spot not found");
        }
        parkingRepository.deleteById(id);
        return "Parking Spot deleted";
    }
    public ParkingModel update(ParkingModel parkingModel, Long id) {
        Optional<ParkingModel> response = parkingRepository.findById(id);
        if (!response.isPresent()) {
            throw new NotFoundException("Parking Spot not found");
        }
        parkingModel.setId(response.get().getId());
        parkingModel.setRegistrationDate(response.get().getRegistrationDate());
        return parkingRepository.save(parkingModel);
    }
}
