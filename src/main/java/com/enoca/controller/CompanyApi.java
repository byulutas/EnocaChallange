package com.enoca.controller;

import com.enoca.service.CompanyManager;
import com.enoca.dto.CompanyDtos.CompanyRequest;
import com.enoca.dto.CompanyDtos.CompanyResponse;
import com.enoca.dto.CompanyDtos.CompanyUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")//localhost:9092/company/
public class CompanyApi {
    private final CompanyManager companyManager;

    @PostMapping("/addCompany")//localhost:9092/company/addCompany
    public ResponseEntity<String> addCompany(@RequestBody CompanyRequest companyRequest){
        return ResponseEntity.ok(this.companyManager.addCompany(companyRequest));
    }

    @DeleteMapping("/deleteCompanyByName")//localhost:9092/company/deleteCompanyByName
    public  ResponseEntity<String> deleteCompanyByName(@RequestParam String companyName){
        return ResponseEntity.ok().body(this.companyManager.deleteCompanyByName(companyName));
    }

    @PutMapping("/updateCompanyByName")//localhost:9092/company/updateCompanyByName
    public ResponseEntity<String> updateCompanyByName(@RequestBody CompanyUpdate companyUpdate){
        return ResponseEntity.ok().body(this.companyManager.updateCompanyByName(companyUpdate));
    }

    @GetMapping("/listAllCompany")//localhost:9092/company/listAllCompany
    public ResponseEntity<List<CompanyResponse>> listAllCompany(){
        return ResponseEntity.ok().body(this.companyManager.listAllCompany());
    }

    @GetMapping("/getCompanyByName")//localhost:9092/company/getCompanyByName
    public  ResponseEntity<CompanyResponse> getCompanyByName(@RequestParam String companyName){
        return ResponseEntity.ok().body(this.companyManager.getCompanyByName(companyName));
    }

}