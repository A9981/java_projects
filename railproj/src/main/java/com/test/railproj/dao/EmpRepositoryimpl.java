package com.test.railproj.dao;

import com.test.railproj.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpRepositoryimpl implements EmployeeRepository{

    private static final String insert_Employee="Insert into employeedb (id,name,salary,age) values (?,?,?,?)";

    private static final String update_Employee="update employeedb set name=?,salary=?,age=? where id=?";
    private static final String delete_Employee="delete from employeedb where id=?";
    private static final String select_Employee="Select * from employeedb where id=?";
    @Autowired
    private JdbcTemplate jt;

    @Override
    public Employee saveEmployee(Employee e) {
        jt.update(insert_Employee, e.getId(),e.getName(),e.getSalary(),e.getAge());
        return e;
    }

    @Override
    public Employee updateEmployee(Employee e) {
        jt.update(update_Employee, e.getName(),e.getSalary(),e.getAge(), e.getId());
        return e;
    }

    @Override
    public Employee getById(int id) {
        return jt.queryForObject(select_Employee, (rs, rowNum) -> {
                    return new Employee(rs.getInt("Id"), rs.getString("name"), rs.getInt("age"), rs.getDouble("salary"));
                },id);
    }
        @Override
    public String deleteById(int id) {
        jt.update(delete_Employee,id);
        return "Employee has got deleted by id "+id;
    }
}
