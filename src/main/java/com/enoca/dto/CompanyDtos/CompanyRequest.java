package com.enoca.dto.CompanyDtos;

import lombok.Data;

@Data
public class CompanyRequest {

    private String companyName;
    private String companyEmail;
    private String companyAddress;
    private String companyNumber;

}
