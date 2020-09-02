package com.ausy_tehnologies.spring.Controller;

import com.ausy_tehnologies.spring.Model.DAO.Department;
import com.ausy_tehnologies.spring.Model.DAO.JobCategory;
import com.ausy_tehnologies.spring.Service.DepartmentService;
import com.ausy_tehnologies.spring.Service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobcategories")
public class JobCategoryController {

    @Autowired
    private JobCategoryService jobCategoryService;

    @PostMapping("/addJobCategory")
    public ResponseEntity<JobCategory> saveJobCategory(@RequestBody JobCategory jobCategory) {

        try {
            if (jobCategory.getValid() == null) {
                jobCategory.setValid(true);
            }
            JobCategory dbJobCategory = jobCategoryService.saveJobCategory(jobCategory);

            if (jobCategory != null) {
                return new ResponseEntity<>(jobCategory, HttpStatus.CREATED);
            }
        }catch (ConstraintViolationException constraintViolationException){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return null;
    }

    @GetMapping("/getAllJobCategories")
    public ResponseEntity<List<JobCategory>> addJobCategories()
    {
        List<JobCategory> jobCategories = jobCategoryService.findAllJobCategory();
        return new ResponseEntity<>(jobCategories,HttpStatus.OK);
    }

    @DeleteMapping("/deleteJobCategory/{id}")
    public ResponseEntity<String> deleteJobCategory(@PathVariable int id)
    {
        try {
           jobCategoryService.removeById(id);
        } catch (Exception e)
        {
            return new ResponseEntity<>("Job Category not found!", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Job category deleted !", HttpStatus.OK);
    }

    @GetMapping("/getJobCategoryById/{id}")
    public ResponseEntity<JobCategory> findById(@PathVariable int id)
    {
        Optional<JobCategory> dbjobCategory= jobCategoryService.getJobCategoryById(id);

        if(dbjobCategory.isPresent())
        {
            return new ResponseEntity<>(dbjobCategory.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

