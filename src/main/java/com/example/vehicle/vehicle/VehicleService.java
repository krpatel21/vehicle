package com.example.vehicle.vehicle;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public List<Vehicle> getAllVehiclesByDate(String date, Type type) {
        return vehicleRepository.findAllByDate(date, type.toString());
    }
}
