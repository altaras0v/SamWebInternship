package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.Contact;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {

	List<Contact> findAllByMentorId(long id);

}
