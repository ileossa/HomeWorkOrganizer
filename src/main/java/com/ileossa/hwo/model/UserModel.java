package com.ileossa.hwo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Setter
@Getter
@ToString
@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String pseudo;
    private String email;
    private String password;
    private String classe;
    private String role;
    private boolean active;


    protected UserModel() {
    }


    public UserModel(String pseudo, String email, String password, String classe, String role, boolean active) {
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.classe = classe;
        this.role = role;
        this.active = active;
    }

}