package com.enoca.service;



import com.enoca.dto.EmployeeDtos.EmployeeRequest;
import com.enoca.dto.EmployeeDtos.EmployeeResponse;
import com.enoca.dto.EmployeeDtos.EmployeeUpdate;

import java.util.List;

public interface IEmployeeServices {
    String addEmployee(EmployeeRequest employeeRequest);
    EmployeeResponse getEmployeeByName(String employeeName);
    List< EmployeeResponse> listAllEmployee();
    String deleteEmployeeByName(String employeeName);
    String updateEmployeeByName(EmployeeUpdate employeeUpdate);
    List<EmployeeResponse> findEmployeeByCompany_Id(Long id);}

