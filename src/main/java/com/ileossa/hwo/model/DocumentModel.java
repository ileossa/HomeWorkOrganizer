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
import java.util.Date;

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
    private File file;
    private Date date;
    private Boolean isAccepted;

    protected DocumentModel(){

    }

    public DocumentModel(String classe,String title,File file,Boolean isAccepted){
        this.classe = classe;
        this.title = title;
        this.file = file;
        this.isAccepted = isAccepted;
        this.date = new Date();
    }

}