package com.enoca.repository;


import com.enoca.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyDao extends JpaRepository<Company,Long> {
    Company findByCompanyName(String companyName);

}
