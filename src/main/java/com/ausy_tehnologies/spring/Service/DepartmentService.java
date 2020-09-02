package com.ausy_tehnologies.spring.Service;

import com.ausy_tehnologies.spring.Model.DAO.Department;
import com.ausy_tehnologies.spring.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Optional<Department> getDepartmentById(int id)
    {
        return this.departmentRepository.findById(id);
    }

    public List<Department> findDepartmentAll()
    {
        return this.departmentRepository.findAll();
    }

    public Department saveDepartment(Department department)
    {
        return this.departmentRepository.save(department);
    }

    public void removeById (int id)
    {
        this.departmentRepository.deleteById(id);
    }
}
