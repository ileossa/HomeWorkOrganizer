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
import java.util.Date;

/**
 * Created by kevin on 12/07/2016.
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
    private Date date;
    private String text;


    protected ResponseModel() {
    }

    public ResponseModel(long discusionId, long authorId, String text) {
        this.discusionId = discusionId;
        this.authorId = authorId;
        this.date = new Date();
        this.text = text;
    }
}
