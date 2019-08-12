package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.Contact;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {


}
