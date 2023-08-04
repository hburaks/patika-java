package com.allianz.pokemondt.service;

import com.allianz.pokemondt.database.entity.GymEntity;
import com.allianz.pokemondt.database.repository.GymEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {
    @Autowired
    GymEntityRepository gymEntityRepository;

    public GymEntity createGym(String name, int qualityStar, int establishDate){
        GymEntity gym = new GymEntity();
        gym.setName(name);
        gym.setQualityStar(qualityStar);
        gym.setEstablishDate(establishDate);
        gymEntityRepository.save(gym);
        return gym;
    }

    public List<GymEntity> getGymsEstablishBefore(int date){
        return gymEntityRepository.getByEstablishDateIsLessThanEqualOrderByEstablishDateDesc(date);
    }

    public List<GymEntity> getAllGyms() {
        return gymEntityRepository.findAll();
    }
}
