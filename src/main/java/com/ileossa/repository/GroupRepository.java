package com.ileossa.repository;

import com.ileossa.model.CategoryPost;
import com.ileossa.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by swip on 25/04/2016.
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
