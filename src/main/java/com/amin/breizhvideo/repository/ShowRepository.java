package com.amin.breizhvideo.repository;

import com.amin.breizhvideo.model.Show;
import com.amin.breizhvideo.model.Village;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Integer> {

    List<Show> findByNameContaining(String search);
}
