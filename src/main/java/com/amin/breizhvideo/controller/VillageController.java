package com.amin.breizhvideo.controller;


import com.amin.breizhvideo.model.Village;
import com.amin.breizhvideo.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/breizhvideo")

public class VillageController {
    @Autowired
    VillageService service;


    @CrossOrigin
    @GetMapping("/villages")
    public ResponseEntity<List<Village>> getAllVillage(@RequestParam(value="search", defaultValue="") String search) {
        List<Village> listVillage;
        try {
            listVillage = service.findAll(search);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listVillage);
    }
    @CrossOrigin
    @GetMapping("/villages/{id}")
    ResponseEntity<Village> getArtistById(@PathVariable(value="id") int id) {
        Optional<Village> artist = service.findById(id);
        if (artist.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(artist.get());
    }
    @CrossOrigin
    @PostMapping("/villages")
    ResponseEntity<Village> addArtist(@RequestBody Village village){
        return ResponseEntity.ok().body(service.insert(village));
    }
    @CrossOrigin
    @PutMapping("/villages/{id}")
    ResponseEntity<Village> updateVillage(@PathVariable(value="id") int id, @RequestBody Village village){
        Village updatedVillage = service.update(id, village);
        if(updatedVillage == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(updatedVillage);
    }
    @CrossOrigin
    @DeleteMapping("/villages/{id}")
    ResponseEntity<Village> deleteArtist(@PathVariable(value="id") int id){
        Optional<Village> village = service.findById(id);
        if(village.isEmpty())
            return ResponseEntity.notFound().build();
        service.delete(village.get().getId());
        return ResponseEntity.accepted().build();
    }


}
