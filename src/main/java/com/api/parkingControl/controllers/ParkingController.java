package com.api.parkingControl.controllers;
import com.api.parkingControl.dto.ParkingDTO;
import com.api.parkingControl.models.ParkingModel;
import com.api.parkingControl.services.ParkingService;
import com.api.parkingControl.utils.PasswordUtil;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/parking")
public class ParkingController {
    final ParkingService parkingService;
    public ParkingController(ParkingService service) {
        this.parkingService = service;
    }
    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingDTO req) {
        ParkingModel parkingModel = new ParkingModel();
        BeanUtils.copyProperties(req, parkingModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingService.save(parkingModel));
    }

}
