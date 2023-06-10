package com.raise.railwayredis.dao;

import com.raise.railwayredis.dto.Employee;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

@Repository
public class EmpDaoImpl implements EmployeeDao{
    private final String hashReference= "Employee";
    @Resource(name="redisTemplate")
    private HashOperations<String, Integer, Employee> hashOperations;

    @Override
    public String saveEmployee(Employee emp) {
        hashOperations.putIfAbsent(hashReference, emp.getId(), emp);
//        return emp;
        return "Data Saved";
    }

    @Override
    public Employee getById(Integer id) {
        return hashOperations.get(hashReference, id);
    }

    @Override
    public String deleteById(Integer id) {
        hashOperations.delete(hashReference, id);
        return "Data has deleted by "+id;
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        hashOperations.put(hashReference, emp.getId(), emp);
        return emp;
    }

//    @Override
//    public Map<Integer, Employee> getAllEmployees() {
//        return null;
//    }
}
