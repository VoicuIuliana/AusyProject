package com.ausy_tehnologies.spring.Controller;

import com.ausy_tehnologies.spring.Model.DAO.Department;
import com.ausy_tehnologies.spring.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department)
    {
        if(department.getValid()==null)
        {
            department.setValid(true);
        }
        try {
            Department dbDepartment = departmentService.saveDepartment(department);

            if(dbDepartment != null)
            {
                return new ResponseEntity<>(dbDepartment, HttpStatus.ACCEPTED);
            }
        } catch (ConstraintViolationException constraintViolationException){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return null;
    }

    @GetMapping("/getAllDepartments")
    public  ResponseEntity<List<Department>> getAllDepartments()
    {
        List<Department> departments = departmentService.findDepartmentAll();
        return new ResponseEntity<>(departments,HttpStatus.OK);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int id)
    {
        try {
            departmentService.removeById(id);
        } catch (Exception e)
        {
            return new ResponseEntity<>("No value present", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Department deleted !", HttpStatus.OK);
    }

    @GetMapping("/getDepartmentById/{id}")
    public ResponseEntity<Department> findById(@PathVariable int id)
    {
        Optional<Department> dbDepartment= departmentService.getDepartmentById(id);

        if(dbDepartment.isPresent())
        {
            return new ResponseEntity<>(dbDepartment.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

