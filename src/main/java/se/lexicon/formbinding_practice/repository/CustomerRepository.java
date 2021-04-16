package se.lexicon.formbinding_practice.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.formbinding_practice.entity.Customer;

public interface CustomerRepository extends CrudRepository <Customer, String> {

    /*CRUD Automatic*/

}
