package com.ileossa.hwo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.ileossa.hwo.exceptions.UserCreateException;
import com.ileossa.hwo.exceptions.UserErrorPatch;
import com.ileossa.hwo.exceptions.UserNotFoundException;
import com.ileossa.hwo.model.ForumModel;
import com.ileossa.hwo.model.UserModel;
import com.ileossa.hwo.model.UserEnum;
import com.ileossa.hwo.repository.ForumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ileossa.hwo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


/**
 * @author v.lafosse
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

    @Autowired
    private ForumRepository forumRepository;


    /**
     * Permet de supprimer un liste d'utilisateur de la base de donnée suivant le filtre "groupId"
     * @param classe
     * @return
     */
    @RequestMapping(method = GET)
    public List<UserModel> listMemberGroup(@RequestParam(value = "groupId") String classe){
        List<UserModel> memberGroup = new ArrayList<>();
        memberGroup = userRepository.findByClasse(classe.toUpperCase());
        return memberGroup;
    }

    /**
     * Désactive la liste des membre appartenant à une classe en passant la valeur active définie dans le modèle USER à false.
     * @param classe
     * @return
     */
    @RequestMapping(method = POST, value = "/ban/all")
    public String removeAllMember(@RequestParam(value = "groupId") String classe){
        List<UserModel> memberGroup = new ArrayList<>();
        memberGroup = userRepository.findByClasse(classe.toUpperCase());
        for (UserModel user: memberGroup) {
            user.setActive(false);
            userRepository.save(user);
        }
        return classe;
    }


    /**
     *récupère l'utilisateur de la base dedonnée suivant le critère id du modèle User
     * @param id
     * @return
     * @throws UserNotFoundException
     */
    @RequestMapping(method = GET , value = "/{id}")
    public UserModel getUser(@PathVariable long id ) throws UserNotFoundException {
        if (userRepository.findOne(id)!=null){
            return userRepository.findOne(id);
        }else{
            throw new UserNotFoundException();
        }
    }

// --------------------------------------------------


    /**
     * Permet de connecter l'utilisateur grâce à son email et son password
     * @param email
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    @RequestMapping(method = POST , value = "/authenticate")
    public UserModel connectUser(@RequestParam(value = "email") String email,
                                 @RequestParam(value = "password") String password) throws UserNotFoundException {
        if(userRepository.findOneByEmail(email) != null )
        {
            UserModel userModel = userRepository.findOneByEmail(email);
            if (userModel.getPassword().equals(password)){
                return userModel;
            }else{
                throw new UserNotFoundException();
            }
        }else{
            throw new UserNotFoundException();
        }
    }


    /**
     * Créer un nouveau utilisateur est l'affecte à la classe qu'il à passé en paramètre -> "groupId"
     * @param pseudo
     * @param password
     * @param email
     * @param group
     * @return
     * @throws UserCreateException
     */
    @RequestMapping(method = POST)
    public UserModel newUser(@RequestParam(value="pseudo") String pseudo,
                             @RequestParam(value="password")  String password,
                             @RequestParam(value="email")  String email,
                             @RequestParam(value="groupId")  String group) throws UserCreateException {
        group = group.toUpperCase();
        LOG.debug("Parameters get pseudo: " + pseudo
                + " , email: " + email
                + " , password: " + password
                + " , group: " + group);

        String role = UserEnum.ETUDIANT.toString();


        if(userRepository.findOneByEmail(email) != null || userRepository.findOneByPseudo(pseudo) != null)
        {
            throw new UserCreateException();
        }

        if(userRepository.findByClasse(group).isEmpty()){
            role = UserEnum.DELEGUE.toString();
            ForumModel forumModel = new ForumModel(group,"Général");
            forumRepository.save(forumModel);
        }
        UserModel userModel = new UserModel(pseudo, email, password, group, role , true);
        return userRepository.save(userModel);
    }


    /**
     * permet d'attributer de nouveau droits (augmenté ou diminué), pour le type de droit possible voir model/userEnum.
     * @param idUser
     * @param currentRole
     * @param newRole
     * @return
     * @throws UserErrorPatch
     */
    @RequestMapping( method = POST, value="/promote")
    public UserModel promoteUser(@RequestParam(value = "id") long idUser,
                                 @RequestParam(value = "current_role") String currentRole,
                                 @RequestParam(value = "new_role") String newRole) throws UserErrorPatch {

        if(userRepository.findOne(idUser) != null){
            UserModel userModel = userRepository.findOne(idUser);
            userModel.setRole(newRole);
            userRepository.save(userModel);
            return userModel;
        }
        throw new UserErrorPatch();
    }


    /**
     * Permet de ban un utilisateur et passant son activité à false ( cf UserModel)
     * @param pseudo
     * @return
     * @throws UserNotFoundException
     */
    @RequestMapping(method = POST , value = "/ban" )
    public UserModel banUser(@RequestParam(value = "pseudo")String pseudo ) throws UserNotFoundException {
        if(userRepository.findOneByPseudo(pseudo)!=null){
            UserModel user = userRepository.findOneByPseudo(pseudo);
            user.setActive(false);
            userRepository.save(user);
            return user;
        }else{
            throw new UserNotFoundException();
        }
    }

// --------------------------------------------------

    @RequestMapping(method = PUT )
    public UserModel userChangePassword(@RequestParam(value = "id") long idUser,
                                        @RequestParam(value = "current_password") String password,
                                        @RequestParam(value = "new_password")String newPassword) throws UserNotFoundException, UserErrorPatch {
        if(userRepository.findOne(idUser)!=null){
            UserModel userModel = userRepository.findOne(idUser);
            if(userModel.getPassword().equals(password)) {
                userModel.setPassword(newPassword);
                userRepository.save(userModel);
                return userModel;
            }else{
                throw new UserErrorPatch();
            }
        }else {
            throw new UserNotFoundException();
        }

    }

}





























