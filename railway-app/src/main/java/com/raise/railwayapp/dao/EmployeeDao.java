package com.raise.railwayapp.dao;

import com.raise.railwayapp.dto.Employee;

import java.util.List;

public interface EmployeeDao {
    public Employee saveEmployee(Employee e);
    public Employee getById(String id);
    public String deleteById(String id);
    public Employee updateEmployee(Employee e);

    public List<Object> findAll();
}
