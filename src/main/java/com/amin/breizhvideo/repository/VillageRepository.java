package com.amin.breizhvideo.repository;

import com.amin.breizhvideo.model.Village;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VillageRepository extends JpaRepository<Village , Integer> {

    public List<Village> findByNameContaining(String name) ;
}
