package com.ileossa.hwo;

/**
 * Created by ileossa on 12/07/16.
 */
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customers, Long> {

    List<Customers> findByLastName(String lastName);
}