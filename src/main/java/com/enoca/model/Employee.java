package com.enoca.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Employee")
public class Employee {
    @Id
    @SequenceGenerator(name = "employee_Id", sequenceName = "employee_Id", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_Id")
    private Long id;
    private String employeeName;
    private String employeeSurname;
    private String employeeAddress;
    private String employeeEmail;
    private int employeeAge;
    @ManyToOne
    @JoinColumn(name = "Company_Id")
    private Company company;

}
