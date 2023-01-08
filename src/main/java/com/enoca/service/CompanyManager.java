package com.enoca.service;

import com.enoca.dto.CompanyDtos.CompanyRequest;
import com.enoca.dto.CompanyDtos.CompanyResponse;
import com.enoca.dto.CompanyDtos.CompanyUpdate;
import com.enoca.model.Company;
import com.enoca.repository.ICompanyDao;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CompanyManager implements ICompanyServices {

    private final ICompanyDao iCompanyDao;
    private final ModelMapper modelMapper;
    @Override
    public String addCompany(CompanyRequest companyRequest) {
        Company company =this.modelMapper.map(companyRequest, Company.class);
        if (this.iCompanyDao.findByCompanyName(company.getCompanyName())==null){
            this.iCompanyDao.save(company);
            return "Successful Save in Database";
        }else {
            return "You are already have ["+company.getCompanyName()+"] company";


        }


    }

    @Override
    public CompanyResponse getCompanyByName(String companyName) {
        Company company=this.iCompanyDao.findByCompanyName(companyName);
        CompanyResponse companyResponse=this.modelMapper.map(company, CompanyResponse.class);

        return companyResponse;
    }

    @Override
    public List<CompanyResponse> listAllCompany() {
        List<CompanyResponse>companyResponseList=new ArrayList<>();
        List<Company>companies=this.iCompanyDao.findAll();
        for (Company company : companies) {
            CompanyResponse companyResponse=this.modelMapper.map(company,CompanyResponse.class);
            companyResponseList.add(companyResponse);
        }

        return companyResponseList;
    }

    @Override
    public String deleteCompanyByName(String companyName) {


        if (this.iCompanyDao.findByCompanyName(companyName)==null){
            return "You are not have Company whit name ["+companyName+"] !!!";



        }else {
            Company company=this.iCompanyDao.findByCompanyName(companyName);
            this.iCompanyDao.delete(company);
            return "Successful Delete in DataBase";
        }


    }

    @Override
    public String updateCompanyByName(CompanyUpdate companyUpdate) {

        if (this.iCompanyDao.findByCompanyName(companyUpdate.getUpdateName())==null){
            return "You are not have Company whit name ["+companyUpdate.getUpdateName()+"] !!!";

        }else {
            Company company=this.iCompanyDao.findByCompanyName(companyUpdate.getUpdateName());
            company.setCompanyAddress(companyUpdate.getCompanyAddress());
            company.setCompanyName(companyUpdate.getCompanyName());
            company.setCompanyEmail(companyUpdate.getCompanyEmail());
            company.setCompanyNumber(companyUpdate.getCompanyNumber());
            this.iCompanyDao.save(company);
            return "Successful Update";


        }


    }
}
