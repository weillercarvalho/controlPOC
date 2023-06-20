package com.api.parkingControl.controllers;
import com.api.parkingControl.dto.ParkingDTO;
import com.api.parkingControl.models.ParkingModel;
import com.api.parkingControl.services.ParkingService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/parking")
public class ParkingController {
    final ParkingService parkingService;
    public ParkingController(ParkingService service) {
        this.parkingService = service;
    }
    @PostMapping
    public ResponseEntity<ParkingModel> saveParkingSpot(@RequestBody @Valid ParkingDTO req) {
        ParkingModel parkingModel = new ParkingModel();
        BeanUtils.copyProperties(req, parkingModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingService.save(parkingModel));
    }
    @GetMapping
    public ResponseEntity<List<ParkingModel>> getAllParking() {
        return ResponseEntity.status(HttpStatus.OK).body(parkingService.getAll());
    }
}
