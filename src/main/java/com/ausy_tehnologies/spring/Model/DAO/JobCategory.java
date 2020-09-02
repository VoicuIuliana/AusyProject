package com.ausy_tehnologies.spring.Model.DAO;

import lombok.Data;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "JOB_CATEGORY")
@Data
public class JobCategory extends NamedEntity {
}
