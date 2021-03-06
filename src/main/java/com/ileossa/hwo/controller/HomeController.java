package com.ileossa.hwo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ileossa on 12/07/16.
 */
@RestController
@RequestMapping("/")
public class HomeController {

    /**
     * Permet d'afficher un message de bienvenus, par défaut avec le mode dev l'url est
     *          localhost:8080
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String homePage(){
        return "Welcom API Home Work Organizer";
    }
}
