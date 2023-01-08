package com.enoca.service;


import com.enoca.dto.EmployeeDtos.EmployeeRequest;
import com.enoca.dto.EmployeeDtos.EmployeeResponse;
import com.enoca.dto.EmployeeDtos.EmployeeUpdate;
import com.enoca.model.Company;
import com.enoca.model.Employee;
import com.enoca.repository.ICompanyDao;
import com.enoca.repository.IEmployeeDao;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeManager implements IEmployeeServices{

    private final IEmployeeDao iEmployeeDao;
    private final ICompanyDao iCompanyDao;
    private final ModelMapper modelMapper;
    @Override
    public String addEmployee(EmployeeRequest employeeRequest) {

        if (this.iEmployeeDao.findByEmployeeName(employeeRequest.getEmployeeName())==null){
            Employee employee=this.modelMapper.map(employeeRequest, Employee.class);
            Company company=this.iCompanyDao.findAll().get(employeeRequest.getCompanyId());
            employee.setCompany(company);
            this.iEmployeeDao.save(employee);
            return "Successful Save";
        }else {
            return "You are already have ["+employeeRequest.getEmployeeName()+"] Employee";
        }

    }

    @Override
    public EmployeeResponse getEmployeeByName(String employeeName) {
        Employee employee=this.iEmployeeDao.findByEmployeeName(employeeName);
        EmployeeResponse employeeResponse=this.modelMapper.map(employee,EmployeeResponse.class);

        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> listAllEmployee() {
        List<EmployeeResponse>employeeResponseList=new ArrayList<>();
        List<Employee> employees=this.iEmployeeDao.findAll();
        for (Employee employee : employees) {
            EmployeeResponse employeeResponse=this.modelMapper.map(employee,EmployeeResponse.class);
            employeeResponseList.add(employeeResponse);
        }
        return employeeResponseList;
    }

    @Override
    public String deleteEmployeeByName(String employeeName) {

        if (this.iEmployeeDao.findByEmployeeName(employeeName)==null){
            return "You are not have Company whit name ["+employeeName+"] !!!";

        }else {
            Employee employee=this.iEmployeeDao.findByEmployeeName(employeeName);
            this.iEmployeeDao.delete(employee);
            return "Successful Delete in DataBase";
        }
    }

    @Override
    public String updateEmployeeByName(EmployeeUpdate employeeUpdate) {
        if (this.iEmployeeDao.findByEmployeeName(employeeUpdate.getUpdateName())==null){
            return "You are not have Employee whit name ["+employeeUpdate.getUpdateName()+"] !!!";
        }
        Employee employee=this.iEmployeeDao.findByEmployeeName(employeeUpdate.getUpdateName());
        employee.setEmployeeName(employeeUpdate.getUpdateName());
        employee.setEmployeeSurname(employeeUpdate.getEmployeeSurname());
        employee.setEmployeeEmail(employeeUpdate.getEmployeeEmail());
        employee.setEmployeeAddress(employeeUpdate.getEmployeeAddress());
        employee.setEmployeeAge(employeeUpdate.getEmployeeAge());
        Company company=this.iCompanyDao.findAll().get(employeeUpdate.getCompanyId());
        employee.setCompany(company);
        this.iEmployeeDao.save(employee);
        return "Successful Update";

    }

    @Override
    public List<EmployeeResponse> findEmployeeByCompany_Id(Long id) {
        List<EmployeeResponse>employeeResponseList=new ArrayList<>();
        List<Employee>employees=this.iEmployeeDao.findEmployeeByCompany_Id(id);
        for (Employee employee : employees) {
            EmployeeResponse employeeResponse=this.modelMapper.map(employee,EmployeeResponse.class);
            employeeResponseList.add(employeeResponse);
        }
        return employeeResponseList;
    }
}
