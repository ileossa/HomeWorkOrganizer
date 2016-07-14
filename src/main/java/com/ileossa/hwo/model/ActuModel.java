package com.ileossa.hwo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kevin on 12/07/2016.
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
        SimpleDateFormat format = new SimpleDateFormat ("dd/MM/yyyy hh:mm");
        this.date = format.format(date);
    }

 }
