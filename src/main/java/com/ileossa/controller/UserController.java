package com.ileossa.controller;

import com.ileossa.exception.UserExistException;
import com.ileossa.model.User;
import com.ileossa.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by swip on 25/04/2016.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = POST)
    public void createUser(@RequestParam(value = "pseudo") String pseudo,
                           @RequestParam(value = "email") String email){
        //create user mais il y a pas de password ????
        LOG.debug("Create new user[ pseudo: " + pseudo + " , email: " + email );
        if(userRepository.findOneByEmail(email)!=null || userRepository.findOneByPseudo(pseudo)!=null){
            throw  new UserExistException();
        }else{
            //constructeur par défault pour utilisateur sans role?
            User user = new User(pseudo,email,0);
            userRepository.save(user);
            //méthode void? pas de renvoi de true ou false ?
        }

    }


    @RequestMapping(method = DELETE, value = "{id}")
    public void deleteUser(@PathVariable Long id){
        LOG.debug("Delete user id: " + id  );
        userRepository.delete(id);

    }

    @RequestMapping(method = GET, value = "{id}")
    public User findUserById(@PathVariable Long id){
        LOG.debug("find user by user id: " + id  );
        return userRepository.findOne(id);
    }

    @RequestMapping(method = GET, value = "{pseudo}")
    public User findUserById(@PathVariable String pseudo){
        LOG.debug("find user by user pseudo: " + pseudo  );
        return userRepository.findOneByPseudo(pseudo);
    }

    @RequestMapping(method = GET, value = "{email}")
    public User findUserByEmail(@PathVariable String email){
        LOG.debug("find user by user emai: " + email  );
        return userRepository.findOneByEmail(email);
    }

    @RequestMapping(method = GET, value = "{idRole}")
    public List<User> findListUserByIdRole(@PathVariable Long idRole){
        LOG.debug("find user by user idRole: " + idRole  );
        return userRepository.findUserList(idRole);
    }

    @RequestMapping(method = PATCH, value = "{id}")
    public User createUser(@PathVariable Long id,
                           @RequestParam(value = "pseudo") String pseudo,
                           @RequestParam(value = "email") String email,
                           @RequestParam(value = "idRole") Long idRole){
        //pareil pas de mdp?
        //create user qui fait un patch et qui save un user avec un id ???? WHAT?
        LOG.debug("Update new user[ pseudo: " + pseudo + " , email: " + email +", idRole: " + idRole);
        User user = userRepository.findOne(id);
        //todo faire les tests pour savoir si on doit modifier la valeur ou pas.
        return userRepository.save(user);
    }




    @RequestMapping(method = GET)
    public String helloWorld(){
        LOG.debug("Hello controller" );
        return "hello world";
    }
}
