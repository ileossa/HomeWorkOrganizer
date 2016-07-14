package com.ileossa.hwo.model;

/**
 * Created by kevin on 12/07/2016.
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;


@Setter
@Getter
@ToString
@Entity
public class EventModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String classe;
    private String description;
    private String date;
    private String time;
    private String matiere;

    protected EventModel(){
    }

    public EventModel(String title,String classe,String description, String time, String matiere){
        this.title = title;
        this.classe = classe;
        this.description = description;
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat ("dd/MM/yyyy hh:mm");
        this.date = format.format(date);
        this.time = time;
        this.matiere = matiere;
    }
}
