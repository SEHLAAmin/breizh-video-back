package com.amin.breizhvideo.controller;

import com.amin.breizhvideo.model.Show;

import com.amin.breizhvideo.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/breizhvideo/show")
public class ShowController {


    @Autowired
    ShowService service;


    @CrossOrigin
    @GetMapping("/shows")
    public ResponseEntity<List<Show>> getAllShow(@RequestParam(value = "search", defaultValue = "") String search) {
        List<Show> listShow;
        try {
            listShow = service.findAll(search);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listShow);
    }

    @CrossOrigin
    @GetMapping("/shows/{id}")
    ResponseEntity<Show> getShowById(@PathVariable(value = "id") int id) {
        Optional<Show> show = service.findById(id);
        if (show.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(show.get());
    }


    /*Object a surveiller */

    @CrossOrigin
    @PostMapping("/shows")
    ResponseEntity<Object> addShow(@RequestBody Show show) {
        return ResponseEntity.ok().body(service.insert(show));
    }

    @CrossOrigin
    @PutMapping("/shows/{id}")
    ResponseEntity<Show> updateShow(@PathVariable(value = "id") int id, @RequestBody Show show) {
        Show updateShow = service.update(id, show);
        if (updateShow == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(updateShow);
    }

    @CrossOrigin
    @DeleteMapping("/Shows/{id}")
    ResponseEntity<Show> deleteShow(@PathVariable(value = "id") int id) {
        Optional<Show> show = service.findById(id);
        if (show.isEmpty())
            return ResponseEntity.notFound().build();
        service.delete(show.get().getIdShow());
        return ResponseEntity.accepted().build();

    }
}
