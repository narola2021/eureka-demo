package com.narola.discoveryclient.controller;

import com.narola.discoveryclient.entity.Vehicle;
import com.narola.discoveryclient.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;


    @PostMapping("/add")
    public Vehicle addVehicles(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicles(vehicle);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVehicle(@PathVariable int id){
        vehicleService.deleteVehicleById(id);
    }

    @GetMapping("/get/{id}")
    public Vehicle getVehicle(@PathVariable int id){
        return vehicleService.getVehicleById(id);
    }

    @PutMapping("/update/{id}")
    public void updateVehicle(@RequestBody Vehicle vehicle, @PathVariable int id){
        vehicle.setVehicleId(id);
        vehicleService.updateVehicle(vehicle);
    }

    @GetMapping("/list")
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }
}
