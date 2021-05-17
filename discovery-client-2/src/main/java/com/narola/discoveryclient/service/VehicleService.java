package com.narola.discoveryclient.service;

import com.narola.discoveryclient.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle addVehicles(Vehicle vehicle);
    void deleteVehicleById(int id);
    Vehicle getVehicleById(int id);
    Vehicle updateVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
}
