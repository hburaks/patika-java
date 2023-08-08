package com.allianz.example.util;

import com.allianz.example.util.dbutil.BaseEntity;
import com.allianz.example.util.dbutil.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseService<Entity extends BaseEntity> implements IBaseService<Entity>{

    @Autowired
    BaseRepository<Entity> baseRepository;
     public List<Entity> findAll() throws Exception {
        try {
            List<Entity> entityList = baseRepository.findAll();
            return entityList;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public Entity save(Entity entity) throws Exception {
        try {
        return baseRepository.save(entity);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            baseRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Optional<Entity> findById(Long id) throws Exception {
        try {
            return baseRepository.findById(id);
        } catch (Exception e) {
            throw e;
        }
    }
}



