package com.allianz.pokemondt.controller;

import com.allianz.pokemondt.database.entity.GymEntity;
import com.allianz.pokemondt.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class GymController {

    @Autowired
    GymService gymService;

    @GetMapping("gym-establish-before/date/{date}")
    public ResponseEntity<List<GymEntity>> getGymEntityById(@PathVariable int date){
        List<GymEntity> gymEntity = gymService.getGymsEstablishBefore(date);
        if (gymEntity != null) {
            return new ResponseEntity<>(gymEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("gym")
    public ResponseEntity<List<GymEntity>> getGymEntities(){
        List<GymEntity> gymEntities = gymService.getAllGyms();
        return new ResponseEntity<>(gymEntities, HttpStatus.OK);
    }

    @PostMapping("gym")
    public ResponseEntity<GymEntity> createGym(@RequestBody GymEntity gym){
        GymEntity gym1 = gymService.createGym(gym.getName(),gym.getQualityStar(),gym.getEstablishDate());
        return new ResponseEntity<>(gym1, HttpStatus.CREATED);
    }
}
