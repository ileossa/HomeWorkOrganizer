package com.ileossa.repository;

import com.ileossa.model.CategoryPost;
import com.ileossa.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by swip on 25/04/2016.
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
