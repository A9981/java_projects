package com.demo.redisapp.controller;

import com.demo.redisapp.dao.EmpRepository;
import com.demo.redisapp.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class EmpController {
    @Autowired
    EmpRepository repository;
    @PostMapping("/user")
    @CachePut(value = "emp", key = "#emp.id")
    public Employee addNewUser(@RequestBody Employee emp) {
        Employee emps = repository.save(emp);
        return emps;
    }
    @GetMapping("/getUser")
    @Cacheable(value = "emp", key = "#id")
    public Employee getUserById(@RequestParam String id){
        return  repository.findById(id).isPresent() ? repository.findById(id).get():null;
    }
    @PostMapping("/update")
    @CachePut(value = "emp", key = "#emp.id")
    public Employee updateUser(@RequestBody Employee emp) {
        Employee emps = repository.save(emp);
        return emps;
    }
    @GetMapping("/delete")
    @CacheEvict(value = "employee", key = "#id")
    public String deleteUserById(@RequestParam String id) {
        repository.deleteById(id);
        return "Successfully Deleted";
    }

}
