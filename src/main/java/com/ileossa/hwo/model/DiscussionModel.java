package com.ileossa.hwo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
public class DiscussionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long forumId;
    private String sujet;
    private String text;
    private long authorId;
    private String author;
    private String date;


    protected DiscussionModel() {
    }

    public DiscussionModel(long forumId, String sujet, String text,String author, long authorId) {
        this.forumId = forumId;
        this.sujet = sujet;
        this.text = text;
        this.author = author;
        this.authorId = authorId;
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat ("dd/MM/yyyy HH:mm");
        format.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        this.date = format.format(date);
    }
}
