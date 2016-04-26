package com.ileossa.repository;

import com.ileossa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by swip on 25/04/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findOneByPseudo(String pseudo);
    public User findOneByEmail(String email);
    public List<User> findUserList(long id);
}
