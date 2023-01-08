package com.enoca.controller;


import com.enoca.service.EmployeeManager;
import com.enoca.dto.EmployeeDtos.EmployeeRequest;
import com.enoca.dto.EmployeeDtos.EmployeeResponse;
import com.enoca.dto.EmployeeDtos.EmployeeUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")//localhost:9092/employee/
public class EmployeeApi {
    private final EmployeeManager employeeManager;

    @PostMapping("/addEmployee")//localhost:9092/employee/addEmployee
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequest employeeRequest){
        return ResponseEntity.ok().body(this.employeeManager.addEmployee(employeeRequest));

    }

    @DeleteMapping("/deleteEmployeeByName")//localhost:9092/employee/deleteEmployeeByName
    public  ResponseEntity<String> deleteemployeeNameByName(@RequestParam String employeeName){
        return ResponseEntity.ok().body(this.employeeManager.deleteEmployeeByName(employeeName));
    }

    @PutMapping("/updateEmployeeByName")//localhost:9092/employee/updateEmployeeByName
    public ResponseEntity<String> updateEmployeeByName(@RequestBody EmployeeUpdate employeeUpdate){
        return ResponseEntity.ok().body(this.employeeManager.updateEmployeeByName(employeeUpdate));
    }

    @GetMapping("/listAllEmployee")//localhost:9092/employee/listAllEmployee
    public ResponseEntity<List<EmployeeResponse>> listAllEmployee(){
        return ResponseEntity.ok().body(this.employeeManager.listAllEmployee());
    }

    @GetMapping("/getEmployeeByName")//localhost:9092/employee/getEmployeeByName
    public ResponseEntity<EmployeeResponse> getEmployeeByName(@RequestParam String employeeName){
        return ResponseEntity.ok().body(this.employeeManager.getEmployeeByName(employeeName));
    }

    @GetMapping("/finByCompanyId")//localhost:9092/employee/finByCompanyId
    public ResponseEntity<List<EmployeeResponse>> finByCompanyId(@RequestParam Long id){
        return ResponseEntity.ok().body(this.employeeManager.findEmployeeByCompany_Id(id));
    }

}