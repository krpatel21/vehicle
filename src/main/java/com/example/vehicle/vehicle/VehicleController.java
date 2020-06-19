package com.example.vehicle.vehicle;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicle")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/vehicle/date/{date}/type/{type}")
    public List<Vehicle> getAllVehiclesByDate(@PathVariable String date, @PathVariable Type type) {
        return vehicleService.getAllVehiclesByDate(date, type);
    }

    @PostMapping("/vehicle")
    public void save(@RequestBody Vehicle vehicle) {
        vehicleService.saveOrUpdate(vehicle);
    }
}
