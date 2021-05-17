package com.narola.discoveryclient.controller;

import com.narola.discoveryclient.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/add")
    public Vehicle addVehicles(@RequestBody Vehicle vehicle) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Vehicle> entity = new HttpEntity<>(vehicle, headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://eureka-client-2/vehicles/add", entity, Vehicle.class);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVehicle(@PathVariable int id){
        restTemplate.delete("http://eureka-client-2/vehicles/delete/"+id);
    }

    @GetMapping("/get/{id}")
    public Vehicle getVehicle(@PathVariable int id){
        return restTemplate.getForObject("http://eureka-client-2/vehicles/get/"+id, Vehicle.class);
    }

    @PutMapping("/update/{id}")
    public void updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicle){
        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);
        restTemplate.put("http://eureka-client-2/vehicles/update/"+id, vehicle, param);
    }

    @GetMapping("/list")
    public Vehicle[] getAllVehicles(){
        return restTemplate.getForObject("http://eureka-client-2/vehicles/list", Vehicle[].class);
    }
}
