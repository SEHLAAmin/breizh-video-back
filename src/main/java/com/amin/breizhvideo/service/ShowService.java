package com.amin.breizhvideo.service;

import com.amin.breizhvideo.model.Show;
import com.amin.breizhvideo.model.Village;
import com.amin.breizhvideo.repository.ShowRepository;
import com.amin.breizhvideo.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ShowService {
    List<Show> findAll(String search);

    Optional<Show> findById(int id);

    void delete(int id);

    Show update(int id, Show show);

    Object insert(Show show);

    @Service
    public class ShowServiceImpl implements ShowService {

        @Autowired
        ShowRepository repository;


        @Override
        public List<Show> findAll(String search) {
            if (! "".equals(search))
                return repository.findByNameContaining(search);
            else
                return repository.findAll();
        }

        @Override
        public Optional<Show> findById(int id) {
            return repository.findById(id);
        }

        @Override
        public void delete(int id) {
            Optional<Show> show = this.findById(id);
            if (show.isPresent()) {
                repository.delete(show.get());
            }
        }

        @Override
        public Show update(int id, Show show) {
            Optional<Show> optionalShow = this.findById(id);
            if(optionalShow.isPresent()) {
                Show showToUpdate = optionalShow.get();
                showToUpdate.setDate(show.getDate());
                if (show.getDate() != null)
                    showToUpdate.setIdShow(show.getIdShow());
                if (show.getDate() != null)
                    showToUpdate.setDate(show.getDate());
                return repository.save(showToUpdate);
            }
            return null;
        }

        @Override
        public Object insert(Show show) {
            return repository.save(show);
        }
    }
}
