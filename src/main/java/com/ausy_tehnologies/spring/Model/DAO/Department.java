package com.ausy_tehnologies.spring.Model.DAO;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "DEPARTMENT")
@Data
public class Department extends NamedEntity{
}
