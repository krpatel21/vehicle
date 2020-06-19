package com.example.vehicle.vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class VehicleControllerTest {

    @Mock
    VehicleService vehicleService;

    @InjectMocks
    VehicleController vehicleController;

    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        initMocks(this);
        initMocks(this);
        vehicle = new Vehicle();
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");
        vehicle.setYear(2020);
    }

    @Test
    void getAllVehicles() {
        when(vehicleService.getVehicleById(any())).thenReturn(vehicle);
        Vehicle vehicleById = vehicleService.getVehicleById(1L);
        assertEquals(vehicleById, vehicle);
    }

    @Test
    void getAllVehiclesByDate() {
        List<Vehicle> list = new ArrayList<>();
        list.add(vehicle);
        when(vehicleService.getAllVehiclesByDate(anyString(), eq(Type.CAR))).thenReturn(list);
        List<Vehicle> returned = vehicleController.getAllVehiclesByDate("2020-06-19", Type.CAR);
        assertEquals(returned, list);
        assertEquals(returned.size(), 1);
    }

    @Test
    void save() {
        doNothing().when(vehicleService).saveOrUpdate(any());
        vehicleService.saveOrUpdate(vehicle);
        verify(vehicleService, times(1)).saveOrUpdate(vehicle);
    }
}