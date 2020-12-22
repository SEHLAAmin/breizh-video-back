package com.amin.breizhvideo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private int villageId;

    public int getIdShow() {

        return id;
    }

    public void setIdShow(int id) {
        this.id = id;

    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }


}
