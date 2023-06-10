package com.raise.railwayredis.dao;

import com.raise.railwayredis.dto.Employee;

import java.util.Map;


public interface EmployeeDao {
    public String saveEmployee(Employee e);
    public Employee getById(Integer id);
    public String deleteById(Integer id);
    public Employee updateEmployee(Employee e);

//    public Map<Integer, Employee> getAllEmployees();
}
