package com.ileossa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by swip on 25/04/2016.
 */
@Entity
public class News {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private Group group;

    private User user;

    private String titre;
    private String description;
    private CategoryPost categoryPost;

    public News() {
    }

    public News(Group group, User user, String titre, String description, CategoryPost categoryPost) {
        this.group = group;
        this.user = user;
        this.titre = titre;
        this.description = description;
        this.categoryPost = categoryPost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryPost getCategoryPost() {
        return categoryPost;
    }

    public void setCategoryPost(CategoryPost categoryPost) {
        this.categoryPost = categoryPost;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", group=" + group +
                ", user=" + user +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", categoryPost=" + categoryPost +
                '}';
    }
}
