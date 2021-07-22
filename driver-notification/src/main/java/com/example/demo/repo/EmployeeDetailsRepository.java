package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.EmployeeDetails;


@Repository
public interface EmployeeDetailsRepository extends MongoRepository<EmployeeDetails, Integer> {


}
