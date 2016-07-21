package com.ileossa.hwo.controller;

import com.ileossa.hwo.exceptions.ActuNotFoundException;
import com.ileossa.hwo.model.ActuModel;
import com.ileossa.hwo.repository.ActuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by kevin on 11/07/2016.
 * Permet de pouvoir générer les appels URL pour le type Evenement
 */
@RestController
@RequestMapping("/actus")
public class ActuController {

    /**
     * Permet d'initialiser et utiliser les méthodes pour manipuler et requêter la base de données
     */
    @Autowired
    private ActuRepository actuRepository;

    /**
     * Permet de créer et sauvegarder une nouvelle actualité dans la base de donnée
     * @param groupeId
     * @param title
     * @param text
     * @return
     */
    @RequestMapping(method = POST)
    public ActuModel createActu(@RequestParam(value = "groupId") String groupeId,
                                @RequestParam(value = "title") String title,
                                @RequestParam(value = "text") String text) {
        groupeId = groupeId.toUpperCase();
        ActuModel actuModel = new ActuModel(groupeId, title, text);
        actuRepository.save(actuModel);
        return actuModel;
    }

    /**
     * Permet de réaliser une mise à jour sur l'actualité cible
     * @param id
     * @param title
     * @param text
     * @return
     * @throws ActuNotFoundException
     */
    @RequestMapping(method = PUT)
    public ActuModel updateActu(@RequestParam(value = "id") long id,
                                @RequestParam(value = "title", defaultValue = "null") String title,
                                @RequestParam(value = "text", defaultValue = "null") String text) throws ActuNotFoundException {
        if (actuRepository.findOne(id) != null) {
            ActuModel actuModel = actuRepository.findOne(id);
            if (title != "null") {
                actuModel.setTitle(title);
            }
            if (text != "null") {
                actuModel.setText(text);
            }
            actuRepository.save(actuModel);
            return actuModel;
        } else {
            throw new ActuNotFoundException();
        }
    }

    /**
     * Permet de supprimer de la base de donnée l'actualité
     * @param id
     * @throws ActuNotFoundException
     */
    @RequestMapping(method = DELETE)
    public void deleteActu(@RequestParam(value = "id") long id) throws ActuNotFoundException {

        if (actuRepository.findOne(id) != null) {

            actuRepository.delete(id);

        } else {
            throw new ActuNotFoundException();
        }
    }

    /**
     * Retourne une liste d'actualité dans le JSON, avec comme filtre le group id de la classe
     * @param groupeId
     * @return
     */
    @RequestMapping(method = GET)
    public List<ActuModel> listActu(@RequestParam(value = "groupId") String groupeId) {
        groupeId = groupeId.toUpperCase();
        List<ActuModel> listActu = new ArrayList<>();
        listActu = actuRepository.findByClasse(groupeId);
        return listActu;
    }
}