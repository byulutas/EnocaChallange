package com.enoca.repository;

import com.enoca.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeDao extends JpaRepository<Employee,Long> {


    List<Employee> findEmployeeByCompany_Id(Long id);
    Employee findByEmployeeName(String employeeName);
}
