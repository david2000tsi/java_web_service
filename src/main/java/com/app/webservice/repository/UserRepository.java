package com.app.webservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.webservice.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
