package com.enoca.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Company")
public class Company {

    @Id
    @SequenceGenerator(name = "Company_Id", sequenceName = "Company_Id", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Company_Id")
    private Long id;
    private String companyName;
    private String companyEmail;
    private String companyAddress;
    private String companyNumber;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees =new ArrayList<>();
}
