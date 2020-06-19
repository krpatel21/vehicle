package com.example.vehicle.vehicle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicle")
    private List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/vehicle/today")
    private List<Vehicle> getAllVehiclesByDate() {
        return vehicleService.getAllVehiclesByDate();
    }

    @PostMapping("/vehicle")
    private void save(@RequestBody Vehicle vehicle) {
        vehicleService.saveOrUpdate(vehicle);
    }
}
