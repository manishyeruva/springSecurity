package com.springSecurity.springSecurityImplementation.repository;

import com.springSecurity.springSecurityImplementation.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	
}
