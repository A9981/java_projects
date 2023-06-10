package com.raise.railwayredis.controller;

import com.raise.railwayredis.dao.EmpDaoImpl;
import com.raise.railwayredis.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/emp")
public class RailController {
    private EmpDaoImpl ed;

    @PostMapping
    public String save(@RequestBody Employee em){
        return ed.saveEmployee(em);
    }

    @GetMapping("/{id}")
    public Employee getData(@PathVariable("id") Integer id){
        return ed.getById(id);
    }

    @PutMapping
    public Employee updateData(@RequestBody Employee em){
        return ed.updateEmployee(em);
    }

    @DeleteMapping("/{id}")
    public String deleteData(@PathVariable("id") Integer id){
        return ed.deleteById(id);
    }

//    @GetMapping
//    public Map<Integer, Employee> findALLEmployees(Map<Integer,Employee> map) {
//        return ed.getAllEmployees();
//    }

}
