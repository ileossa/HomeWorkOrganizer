package com.ileossa.model;

import javax.persistence.*;

/**
 * Created by swip on 24/04/2016.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String pseudo;
    private String email;
    @ManyToOne(fetch = FetchType.EAGER)
    private long idRole;

    public User() {}

    public User(String pseudo, String email, long idRole) {
        this.pseudo = pseudo;
        this.email = email;
        this.idRole = idRole;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", id=" + idRole +
                '}';
    }
}
