package com.ausy_tehnologies.spring.Service;

import com.ausy_tehnologies.spring.Model.DAO.JobCategory;
import com.ausy_tehnologies.spring.Repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobCategoryService {

    @Autowired
    private JobCategoryRepository jobCategoryRepository;


    public JobCategory saveJobCategory(JobCategory jobCategory)
    {
        return this.jobCategoryRepository.save(jobCategory);
    }

    public List<JobCategory> findAllJobCategory()
    {
        return this.jobCategoryRepository.findAll();
    }

    public void removeById (int id)
    {
        this.jobCategoryRepository.deleteById(id);
    }

    public Optional<JobCategory> getJobCategoryById(int id)
    {
        return this.jobCategoryRepository.findById(id);
    }

}
