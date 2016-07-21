package com.ileossa.hwo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class ForumModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String classe;
    private String name;

    protected ForumModel() {
    }

    public ForumModel(String classe, String name) {
        this.classe = classe;
        this.name = name;
    }
}
