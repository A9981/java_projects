package com.raise.railwayapp.controller;

import com.raise.railwayapp.dao.EmployeeDaoImpl;
import com.raise.railwayapp.dto.Employee;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private  EmployeeDaoImpl ed;
@PostMapping
    public Employee saveEmployee(@RequestBody Employee e) {
//        System.out.println(ed.saveEmployee(e));
//        String resp = ed.saveEmployee(e);
//        return resp;
    return ed.saveEmployee(e);

    }
@PutMapping
    public Employee updateEmployee(@RequestBody Employee e) {
        return ed.updateEmployee(e);
    }
@GetMapping("/{id}")
//@Cacheable(value = "employee",key = "#id",unless = "#result.id<5")
    public Employee getById(@PathVariable("id") String id) {
        return ed.getById(id);
    }
    @GetMapping
    public List findAll() {
     return ed.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") String id) {
        return ed.deleteById(id);
    }
}
