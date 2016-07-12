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
    private Date date;
    private Date time;
    private String matiere;

    protected EventModel(){
    }

    public EventModel(String title,String classe,String description, Date time, String matiere){
        this.title = title;
        this.classe = classe;
        this.description = description;
        this.date = new Date();
        this.time = time;
        this.matiere = matiere;
    }
}
