package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AdminContacts;

@Repository
public interface AdminContactsRepository extends MongoRepository<AdminContacts, Integer> {

	

}
