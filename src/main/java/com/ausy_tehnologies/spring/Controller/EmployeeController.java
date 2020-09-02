package com.ausy_tehnologies.spring.Controller;

import com.ausy_tehnologies.spring.Model.DAO.Department;
import com.ausy_tehnologies.spring.Model.DAO.Employee;
import com.ausy_tehnologies.spring.Model.DAO.JobCategory;
import com.ausy_tehnologies.spring.Repository.DepartmentRepository;
import com.ausy_tehnologies.spring.Repository.EmployeeRepository;
import com.ausy_tehnologies.spring.Service.DepartmentService;
import com.ausy_tehnologies.spring.Service.EmployeeService;
import com.ausy_tehnologies.spring.Service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private JobCategoryService jobCategoryService;

    @GetMapping("/find/{id}")
    public Employee findEmployeeById(@PathVariable int id)
    {
        return this.employeeService.findById(id).get();
    }

    @GetMapping("/findAll")
    public List<Employee> findAllEmployee()
    {
        return employeeService.findAll();
    }

    @PostMapping("/addEmployee/{departmentId}/{jobCategoryId}")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee,@PathVariable int departmentId,@PathVariable int jobCategoryId)
    {
        Optional<Department> dbDepartment = departmentService.getDepartmentById(departmentId);
        if(!dbDepartment.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        employee.setDepartment(dbDepartment.get());

        Optional<JobCategory> dbJobCategory = jobCategoryService.getJobCategoryById(jobCategoryId);
        if(!dbJobCategory.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        employee.setJobCategory(dbJobCategory.get());

        try {
           Employee dbEmployee = employeeService.saveEmployee(employee);

            if(dbEmployee != null)
            {
                return new ResponseEntity<>(dbEmployee, HttpStatus.ACCEPTED);
            }
        } catch (ConstraintViolationException constraintViolationException){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return null;
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        List<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
