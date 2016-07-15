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

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(method = POST)
    public EventModel createEvent(@RequestParam(value = "groupId") String groupeId,
                                  @RequestParam(value = "title") String title,
                                  @RequestParam(value = "desc") String desc,
                                  @RequestParam(value = "time") String time,
                                  @RequestParam(value = "matiere") String matiere) {
        EventModel eventModel = new EventModel(title, groupeId, desc, time, matiere);
        eventRepository.save(eventModel);
        return eventModel;
    }

    @RequestMapping(method = PUT)
    public EventModel updateEvent(@RequestParam(value = "groupId", defaultValue = "null") String groupeId,
                                  @RequestParam(value = "id") long id,
                                  @RequestParam(value = "title", defaultValue = "null") String title,
                                  @RequestParam(value = "desc", defaultValue = "null") String desc,
                                  @RequestParam(value = "time", defaultValue = "null") String time,
                                  @RequestParam(value = "matiere", defaultValue = "null") String matiere) throws EventNotFoundException {
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
            if (!time.equals(time)) {
                eventModel.setTime(time);
            }
            if (!matiere.equals(matiere)) {
                eventModel.setMatiere(matiere);
            }

            eventRepository.save(eventModel);
            return eventModel;
        } else {
            throw new EventNotFoundException();
        }
    }

    @RequestMapping(method = DELETE)
    public void deleteEvent(@RequestParam(value = "id") long id) {
        if (eventRepository.findOne(id) != null) {
            eventRepository.delete(id);
        }
    }

    @RequestMapping(method = GET)
    public List<EventModel> listEvent(@RequestParam(value = "groupId") String groupe) {
        List<EventModel> listEvent = new ArrayList<>();
        return eventRepository.findByClasse(groupe);
    }
}