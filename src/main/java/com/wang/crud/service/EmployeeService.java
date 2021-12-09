package com.wang.crud.service;

import com.wang.crud.bean.Employee;
import com.wang.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zsw
 * @create 2021-12-01 11:50
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;


    public List<Employee> getAll() {
        List<Employee> employees = employeeMapper.selectByExampleWithDept(null);
        return employees;

    }

    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
     }
}
