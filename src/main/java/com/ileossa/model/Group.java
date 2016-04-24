package com.ileossa.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by swip on 24/04/2016.
 */
@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Collection<User> listUser;

    public Group() {
    }

    public Group(String name, User user, Collection<User> listUser) {
        this.name = name;
        this.user = user;
        this.listUser = listUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<User> getListUser() {
        return listUser;
    }

    public void setListUser(Collection<User> listUser) {
        this.listUser = listUser;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", listUser=" + listUser +
                '}';
    }
}
