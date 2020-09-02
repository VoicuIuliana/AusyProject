package com.ausy_tehnologies.spring.Service;

import com.ausy_tehnologies.spring.Model.DAO.Department;
import com.ausy_tehnologies.spring.Model.DAO.Employee;
import com.ausy_tehnologies.spring.Repository.DepartmentRepository;
import com.ausy_tehnologies.spring.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> findById(int id)
    {
        return this.employeeRepository.findById(id);
    }

    public List<Employee> findAll()
    {
        return this.employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee)
    {
        return this.employeeRepository.save(employee);
    }
}
