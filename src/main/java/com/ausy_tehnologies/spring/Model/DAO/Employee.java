package com.ausy_tehnologies.spring.Model.DAO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "EMPLOYEE", schema = "employees_management")
@Data
public class Employee extends BaseEntity{

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "JOB_CATEGORY_ID")
    public  JobCategory jobCategory;

    @OneToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    public Department department;

    @Column(name = "IS_MANAGER")
    private boolean isManager;

    @Column(name =  "START_DATA")
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date startDate;

    @Column(name = "END_DATA")
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date endDate;

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "CP")
    private  String cp;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "BIRTHDAY")
    @JsonFormat(pattern="dd-MM-yyyy")
    private  Date birthday;

    @Column(name = "NO_CHILDREN")
    private boolean noChildren;

    @Column(name = "SALARY")
    private double salary;

    @Column(name = "STUDIES")
    private String studies;

    @Column(name = "SOCIAL_SECURITY_NUMBER")
    private String socialSecurityNumber;

    @Column(name = "HAS_DRIVING_LICENSE")
    private boolean hasDrivingLicense;

}
