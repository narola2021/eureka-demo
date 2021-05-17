package com.narola.discoveryclient.serviceimpl;

import com.narola.discoveryclient.entity.Vehicle;
import com.narola.discoveryclient.repository.VehicleRepository;
import com.narola.discoveryclient.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle addVehicles(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicleById(int id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public Vehicle getVehicleById(int id) {
        return vehicleRepository.findById(id).get();
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
}
