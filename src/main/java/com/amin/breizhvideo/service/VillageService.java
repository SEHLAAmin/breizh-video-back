package com.amin.breizhvideo.service;

import com.amin.breizhvideo.model.Village;
import com.amin.breizhvideo.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface VillageService {

    Optional<Village> findById(Integer id);
    List<Village> findAll(String search);
    Village insert(Village village);
    Village update(Integer id, Village artist);
    void delete(Integer id);

    @Service
    public class VillageServiceImpl implements VillageService {


        @Autowired
        private VillageRepository repository;

        @Override
        public Optional<Village> findById(Integer id) {
            return repository.findById(id);
        }

        @Override
        public List<Village> findAll(String search) {
            if (! "".equals(search))
                return repository.findByNameContaining(search);
            else
                return repository.findAll();
        }

        @Override
        public Village insert(Village village) {
            return repository.save(village);
        }

        @Override
        public Village update(Integer id, Village village) {
            Optional<Village> optionalVillage = this.findById(id);
            if(optionalVillage.isPresent()) {
                Village villageToUpdate = optionalVillage.get();
                villageToUpdate.setName(village.getName());
                if (village.getPostcode() != null)
                    villageToUpdate.setPostcode(village.getPostcode());
                if (village.getName() != null)
                    villageToUpdate.setName(village.getName());
                return repository.save(villageToUpdate);
            }
            return null;
        }

        @Override
        public void delete(Integer id) {
            Optional<Village> village = this.findById(id);
            if (village.isPresent()) {
                repository.delete(village.get());
            }
        }

    }
}
