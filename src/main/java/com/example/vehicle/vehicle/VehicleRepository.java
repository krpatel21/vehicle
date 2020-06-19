package com.example.vehicle.vehicle;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    Optional<Vehicle> findById(Long id);

    Vehicle save(Vehicle vehicle);

    List<Vehicle> findAll();

    @Query("SELECT * FROM VEHICLE where CAST(CREATED_TIME AS DATE)= '2020-06-19'")
    List<Vehicle> findAll();

    @Override
    void deleteById(Long integer);
}
