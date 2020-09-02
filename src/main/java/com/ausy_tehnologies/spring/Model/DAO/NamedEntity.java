package com.ausy_tehnologies.spring.Model.DAO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Check;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public class NamedEntity extends BaseEntity {

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME",unique = true)
    private String name;

    @Column (name = "VALID")
    private Boolean valid;
}
