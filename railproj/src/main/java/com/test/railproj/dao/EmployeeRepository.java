package com.test.railproj.dao;

import com.test.railproj.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;


public interface EmployeeRepository {
    Employee saveEmployee(Employee e);
    Employee updateEmployee(Employee e);
    Employee getById(int id);
    String deleteById(int id);
}
