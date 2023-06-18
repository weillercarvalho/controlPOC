package com.api.parkingControl.controllers;

import com.api.parkingControl.services.ParkingService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/parking")
public class ParkingController {
    final ParkingService service;
    public ParkingController(ParkingService service) {
        this.service = service;
    }
}
