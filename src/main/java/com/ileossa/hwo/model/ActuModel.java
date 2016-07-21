package com.ileossa.hwo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by kevin on 12/07/2016.
 */

/**
 * Model de donnée permettant de représenter les donnée qui seront par la suite stocke dans la base de donnée
 */
@Setter
@Getter
@ToString
@Entity
public class ActuModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String classe;
    private String title;
    private String text;
    private String date;

    protected ActuModel(){

    }

    public ActuModel(String classe,String title,String text){
        this.classe = classe;
        this.title =title;
        this.text = text;
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat ("dd/MM/yyyy HH:mm");
        format.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        this.date = format.format(date);
    }

 }
