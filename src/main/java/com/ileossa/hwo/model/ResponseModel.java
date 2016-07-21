package com.ileossa.hwo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class ResponseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long discusionId;
    private long authorId;
    private String author;
    private String date;
    private String text;


    protected ResponseModel() {
    }

    public ResponseModel(long discusionId, long authorId, String author, String text) {
        this.discusionId = discusionId;
        this.authorId = authorId;
        this.author = author;
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        format.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        this.date = format.format(date);
        this.text = text;
    }
}
