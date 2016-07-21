package com.ileossa.hwo.controller;

import com.ileossa.hwo.model.ResponseModel;
import com.ileossa.hwo.repository.ResponseRepository;
import com.ileossa.hwo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by kevin on 12/07/2016.
 */

@RestController
@RequestMapping("/reponse")
public class ReponseController {

    /**
     * Instance pour réaliser les requêtes sur la base de donnée
     */
    @Autowired
    private ResponseRepository responseRepository;

    /**
     * Permet de créer un reponse dans le forum à une discussion séléctionné
     * @param discussionID
     * @param authorId
     * @param author
     * @param text
     * @return
     */
    @RequestMapping(method = POST)
    public ResponseModel createReponse(@RequestParam(value = "discussionId") long discussionID,
                                       @RequestParam(value = "authorId")long authorId,
                                       @RequestParam(value = "author") String author,
                                       @RequestParam(value = "text") String text){
        ResponseModel responseModel = new ResponseModel(discussionID,authorId,author,text);
        responseRepository.save(responseModel);
        return responseModel;
    }


    /**
     * Permet de récupérer la liste des discussion suivant la "discussionId"
     * @param discussionId
     * @return
     */
    @RequestMapping(method = GET)
    public List<ResponseModel> getListDiscussion(@RequestParam(value = "discussionId") long discussionId){
        return responseRepository.findByDiscusionId(discussionId);
    }

}
