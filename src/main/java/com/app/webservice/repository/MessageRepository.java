package com.app.webservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.webservice.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

}
