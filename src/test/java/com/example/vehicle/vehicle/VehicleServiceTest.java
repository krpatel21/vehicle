package com.example.vehicle.vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;


class VehicleServiceTest {

    @Mock
    VehicleRepository vehicleRepository;

    @InjectMocks
    VehicleService vehicleService;

    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        initMocks(this);
        vehicle = new Vehicle();
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");
        vehicle.setYear(2020);
    }

    @Test
    void getVehicleById() {
        when(vehicleRepository.findById(anyLong())).thenReturn(Optional.of(vehicle));
        Vehicle returned = vehicleService.getVehicleById(1L);
        assertEquals(returned, vehicle);
    }

    @Test
    void saveOrUpdate() {
        when(vehicleRepository.save(any())).thenReturn(vehicle);
        vehicleService.saveOrUpdate(vehicle);
        verify(vehicleRepository, times(1)).save(vehicle);
    }

    @Test
    void getAllVehicles() {
        List<Vehicle> list = new ArrayList<>();
        list.add(vehicle);
        when(vehicleRepository.findAll()).thenReturn(list);
        List<Vehicle> returned = vehicleService.getAllVehicles();
        assertEquals(returned, list);
        assertEquals(returned.size(), 1);
    }

    @Test
    void getAllVehiclesByDate() {
        List<Vehicle> list = new ArrayList<>();
        list.add(vehicle);
        when(vehicleRepository.findAllByDate(anyString(), anyString())).thenReturn(list);
        List<Vehicle> returned = vehicleService.getAllVehiclesByDate("2020-06-19", Type.CAR);
        assertEquals(returned, list);
        assertEquals(returned.size(), 1);
    }
}