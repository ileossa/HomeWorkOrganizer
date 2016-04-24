package com.ileossa.repository;

import com.ileossa.model.CategoryPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by swip on 25/04/2016.
 */
@Repository
public interface CategoryPostRepository extends JpaRepository<CategoryPost, Long> {
}
