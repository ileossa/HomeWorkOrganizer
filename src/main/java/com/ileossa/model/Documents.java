package com.ileossa.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by swip on 25/04/2016.
 */
@Entity
public class Documents {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="group_id")
    private User user;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="group_id")
    private Group group;

    private String name;
    private String extension;
    private Date dateUpdate;


    public Documents() {
    }

    public Documents(User user, Group group, String name, String extension, Date dateUpdate) {
        this.user = user;
        this.group = group;
        this.name = name;
        this.extension = extension;
        this.dateUpdate = dateUpdate;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }


    @Override
    public String toString() {
        return "Documents{" +
                "id=" + id +
                ", user=" + user +
                ", group=" + group +
                ", name='" + name + '\'' +
                ", extension='" + extension + '\'' +
                ", dateUpdate=" + dateUpdate +
                '}';
    }
}
