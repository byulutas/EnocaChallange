package com.enoca.service;



import com.enoca.dto.CompanyDtos.CompanyRequest;
import com.enoca.dto.CompanyDtos.CompanyResponse;
import com.enoca.dto.CompanyDtos.CompanyUpdate;

import java.util.List;

public interface ICompanyServices {

    String addCompany(CompanyRequest companyRequest);
    CompanyResponse getCompanyByName(String companyName);
    List<CompanyResponse> listAllCompany();
    String deleteCompanyByName(String companyName);
    String updateCompanyByName(CompanyUpdate companyUpdate);

}
