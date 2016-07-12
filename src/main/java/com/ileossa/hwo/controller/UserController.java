package com.ileossa.hwo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.ileossa.hwo.exceptions.UserCreateException;
import com.ileossa.hwo.exceptions.UserErrorPatch;
import com.ileossa.hwo.exceptions.UserNotFoundException;
import com.ileossa.hwo.model.UserModel;
import com.ileossa.hwo.model.UserEnum;
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



    @RequestMapping(method = GET)
    public List<UserModel> listMemberGroup(@RequestParam(value = "classe") String classe){
        List<UserModel> memberGroup = new ArrayList<>();
        memberGroup = userRepository.findByClasse(classe);
        return memberGroup;
    }


    @RequestMapping(method = GET , value = "/{id}")
    public UserModel getUser(@PathVariable long id ) throws UserNotFoundException {
        if (userRepository.findOne(id)!=null){
            return userRepository.findOne(id);
        }else{
            throw new UserNotFoundException();
        }
    }

// --------------------------------------------------

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



    @RequestMapping(method = POST)
    public UserModel newUser(@RequestParam(value="pseudo") String pseudo,
                             @RequestParam(value="password")  String password,
                             @RequestParam(value="email")  String email,
                             @RequestParam(value="group")  String group) {
        LOG.debug("Parameters get pseudo: " + pseudo
                + " , email: " + email
                + " , password: " + password
                + " , group: " + group);
        System.out.println("newUser()() toto");
        if(userRepository.findOneByEmail(email) != null || userRepository.findOneByPseudo(pseudo) != null)
        {
            System.out.println("connard");
            //throw new UserCreateException();
        }
        UserModel userModel = new UserModel(pseudo, email, password, group, UserEnum.ETUDIANT.toString(), true);
        return userRepository.save(userModel);
    }



    @RequestMapping( method = POST, value="/promote")
    public UserModel promoteUser(@RequestParam(value = "id") long idUser,
                                 @RequestParam(value = "current_role") String currentRole,
                                 @RequestParam(value = "new_role") String newRole) throws UserErrorPatch {

        if(userRepository.findOne(idUser) != null){
            UserModel userModel = userRepository.findOne(idUser);
            userModel.setClasse(newRole);
            userRepository.save(userModel);
            return userModel;
        }
        throw new UserErrorPatch();
    }



    @RequestMapping(method = POST , value = "/ban" )
    public UserModel banUser(@RequestParam(value = "pseudo")String pseudo ) throws UserNotFoundException {
        if(userRepository.findOneByPseudo(pseudo)!=null){
            UserModel caca = userRepository.findOneByPseudo(pseudo);
            caca.setActive(false);
            userRepository.save(caca);
            return caca;
        }else{
            throw new UserNotFoundException();
        }
    }

// --------------------------------------------------

    @RequestMapping(method = PUT )
    public UserModel userChangePassword(@RequestParam(value = "id") long idUser,
                                        @RequestParam(value = "password") String password) throws UserNotFoundException {
        if(userRepository.findOne(idUser)!=null){
            UserModel userModel = userRepository.findOne(idUser);
            userModel.setPassword(password);
            userRepository.save(userModel);
            return userModel;
        }else {
            throw new UserNotFoundException();
        }
    }
}
