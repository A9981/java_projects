package com.demo.redisapp.dao;

import com.demo.redisapp.dto.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends MongoRepository<Employee,String> {
}
