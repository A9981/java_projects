package com.raise.railwayapp.dao;

import com.raise.railwayapp.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    public static final String Hash_Key="Employee";
    @Autowired
    @Qualifier("redisTemplate")
    public StringRedisTemplate template;

    @Override
    public Employee saveEmployee(Employee e) {
        // employee object can not be cast by string that why toString used.
        template.opsForHash().put(Hash_Key,e.getId(),e.toString());
        return e;
    }

    @Override
    public Employee updateEmployee(Employee e) {
        template.opsForHash().put(Hash_Key,e.getId(),e.toString());
        return e;
    }

    @Override
    public Employee getById(String id) {
        return (Employee)template.opsForHash().get(Hash_Key,id);
    }

    @Override
    public String deleteById(String id) {
        template.opsForHash().delete(Hash_Key,id);
        return "Employee record removed successfully ";
    }
    @Override
    public List<Object> findAll(){
        return template.opsForHash().values(Hash_Key);
    }

}
