package com.amin.breizhvideo.model;

import javax.persistence.*;
import java.time.Year;
import java.util.List;


@Entity
public class Film {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int Date;
    String title;
    String description;
    int Year;
    int lenght;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        Date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}
