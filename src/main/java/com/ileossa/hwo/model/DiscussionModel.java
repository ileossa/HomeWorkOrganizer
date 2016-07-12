package com.ileossa.hwo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by kevin on 12/07/2016.
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
    private java.util.Date Date;


    protected DiscussionModel() {
    }

    public DiscussionModel(long forumId, String sujet, String text, long authorId) {
        this.forumId = forumId;
        this.sujet = sujet;
        this.text = text;
        this.authorId = authorId;
        this.Date = new Date();
    }
}
