package com.test.railproj.Controller;

import com.test.railproj.dao.EmployeeRepository;
import com.test.railproj.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class EmployeeController {
    @Autowired
    EmployeeRepository er;
    @PostMapping("/emp")
    public Employee saveEmployee(@RequestBody Employee e) {
        return er.saveEmployee(e);
    }
    @PutMapping("/emp")
    public Employee updateEmployee(@RequestBody Employee e) {
        return er.updateEmployee(e);
    }
    @GetMapping("/emp/{id}")
    public Employee getById(@PathVariable("id") int id) {
        return er.getById(id);
    }
    @DeleteMapping("/emp/{id}")
    public String deleteById(@PathVariable("id") int id) {
        return er.deleteById(id);
    }
}
