package com.ausy_tehnologies.spring.Repository;

import com.ausy_tehnologies.spring.Model.DAO.Department;
import com.ausy_tehnologies.spring.Model.DAO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    @Override
    List<Department>findAll();

    @Override
    Optional<Department> findById(Integer integer);

    Optional<Department> findByName(String name);

    void deleteById(int id);
}
