package com.ileossa.hwo.controller;

import com.ileossa.hwo.exceptions.DiscussionNotFroundException;
import com.ileossa.hwo.exceptions.UserNotFoundException;
import com.ileossa.hwo.model.DiscussionModel;
import com.ileossa.hwo.repository.DiscusionRepository;
import com.ileossa.hwo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by kevin on 12/07/2016.
 */
@RestController
@RequestMapping("/discussion")
public class DiscussionController {

    /**
     * Permet d'initialiser et utiliser les méthodes pour manipuler et requêter la base de données
     */
    @Autowired
    private DiscusionRepository discusionRepository;

    /**
     * Premet de créer une nouvelle discution
     * @param forumId
     * @param sujet
     * @param text
     * @param author
     * @param authorId
     * @return DiscussionModel
     */
    @RequestMapping(method = POST)
    public DiscussionModel createDiscussion(@RequestParam(value = "forumId") long forumId,
                                            @RequestParam(value = "sujet") String sujet,
                                            @RequestParam(value = "text") String text,
                                            @RequestParam(value = "author") String author,
                                            @RequestParam(value = "authorId") long authorId) {
        DiscussionModel discussionModel = new DiscussionModel(forumId, sujet, text, author, authorId);
        discusionRepository.save(discussionModel);
        return discussionModel;
    }

    /**
     * Permet de récupérer la liste des discution suivant le filtre "forumId"
     * @param forumID
     * @return
     */
    @RequestMapping(method = GET)
    public List<DiscussionModel> getListDiscussion(@RequestParam(value = "forumId") long forumID) {
        return discusionRepository.findByForumId(forumID);
    }

    /**
     * Permet de retourner l'Object Discution suivant le filtre id passé en paramètre
     * @param id
     * @return
     * @throws DiscussionNotFroundException
     */
    @RequestMapping(method = GET, value = "/{id}")
    public DiscussionModel getDiscussion(@PathVariable long id) throws DiscussionNotFroundException {
        if (discusionRepository.findOne(id) != null) {
            return discusionRepository.findOne(id);
        } else {
            throw new DiscussionNotFroundException();
        }
    }

}
