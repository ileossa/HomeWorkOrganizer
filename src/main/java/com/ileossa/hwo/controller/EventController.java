package com.ileossa.hwo.controller;


import com.ileossa.hwo.exceptions.EventNotFoundException;
import com.ileossa.hwo.model.EventModel;
import com.ileossa.hwo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by kevin on 11/07/2016.
 */

@RestController
@RequestMapping("/event")
public class EventController {

    /**
     * Permet de faire appel à l'interface et de manipuler les modèles avec la base de donnée
     */
    @Autowired
    private EventRepository eventRepository;


    /**
     * Permet de créer un nouvel évènement dans la base de donnée
     * @param groupeId
     * @param title
     * @param desc
     * @param time
     * @param date
     * @param matiere
     * @return
     */
    @RequestMapping(method = POST)
    public EventModel createEvent(@RequestParam(value = "groupId") String groupeId,
                                  @RequestParam(value = "title") String title,
                                  @RequestParam(value = "desc") String desc,
                                  @RequestParam(value = "time") String time,
                                  @RequestParam(value = "date") String date,
                                  @RequestParam(value = "matiere") String matiere) {

        groupeId = groupeId.toUpperCase();
        EventModel eventModel = new EventModel(title, groupeId, desc, time,date, matiere);
        eventRepository.save(eventModel);
        return eventModel;
    }

    /**
     * Permet de mettre à jour un évènement déjà existant dans la base dedonnée, si il n'y a aucun changement hibernate ne feras pas de mise à jour de ces tables
     * @param groupeId
     * @param id
     * @param title
     * @param desc
     * @param time
     * @param date
     * @param matiere
     * @return
     * @throws EventNotFoundException
     */
    @RequestMapping(method = PUT)
    public EventModel updateEvent(@RequestParam(value = "groupId", defaultValue = "null") String groupeId,
                                  @RequestParam(value = "id") long id,
                                  @RequestParam(value = "title", defaultValue = "null") String title,
                                  @RequestParam(value = "desc", defaultValue = "null") String desc,
                                  @RequestParam(value = "time", defaultValue = "null") String time,
                                  @RequestParam(value = "date", defaultValue = "null") String date,
                                  @RequestParam(value = "matiere", defaultValue = "null") String matiere) throws EventNotFoundException {

        groupeId = groupeId.toUpperCase();
        if (eventRepository.findOne(id) != null) {
            EventModel eventModel = eventRepository.findOne(id);
            if (!groupeId.equals("null")) {
                eventModel.setClasse(groupeId);
            }
            if (!title.equals("null")) {
                eventModel.setTitle(title);
            }
            if (!desc.equals("null")) {
                eventModel.setDescription(desc);
            }
            if (!time.equals("null")) {
                eventModel.setTime(time);
            }
            if (!date.equals("null")) {
                eventModel.setDate(date);
            }
            if (!matiere.equals("null")) {
                eventModel.setMatiere(matiere);
            }

            eventRepository.save(eventModel);
            return eventModel;
        } else {
            throw new EventNotFoundException();
        }
    }

    /**
     * Permet de supprimer un evènement enregistré dans la base donnée, ce faisan on la supprime aussi pour les utilisateurs appartenant à l'évènement.
     * @param id
     */
    @RequestMapping(method = DELETE)
    public void deleteEvent(@RequestParam(value = "id") long id) {
        if (eventRepository.findOne(id) != null) {
            eventRepository.delete(id);
        }
    }

    /**
     * Permet de retourner la liste des évènement avec le filtre "groupId" dans la demande HTTP. (cf : voir le répository repository/EventRepository
     * @param groupe
     * @return
     */
    @RequestMapping(method = GET)
    public List<EventModel> listEvent(@RequestParam(value = "groupId") String groupe) {
        groupe = groupe.toUpperCase();
        List<EventModel> listEvent = new ArrayList<>();
        return eventRepository.findByClasse(groupe);
    }
}