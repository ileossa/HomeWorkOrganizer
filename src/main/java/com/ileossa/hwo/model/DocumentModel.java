package com.ileossa.hwo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.print.Doc;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by kevin on 12/07/2016.
 */

@Setter
@Getter
@ToString
@Entity
public class DocumentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String classe;
    private String title;
    private String pathFile;
    private String date;
    private Boolean isAccepted;

    protected DocumentModel(){

    }

    public DocumentModel(String classe,String title,String pathFile,Boolean isAccepted){
        this.classe = classe;
        this.title = title;
        this.pathFile = pathFile;
        this.isAccepted = isAccepted;
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat ("dd/MM/yyyy HH:mm");
        format.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        this.date = format.format(date);
    }

}
