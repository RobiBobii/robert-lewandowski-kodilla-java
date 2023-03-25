package com.kodilla.kodillahibernate.manytomany.facade;

import com.kodilla.kodillahibernate.manytomany.Company;
import com.kodilla.kodillahibernate.manytomany.Employee;
import com.kodilla.kodillahibernate.manytomany.dao.CompanyDao;
import com.kodilla.kodillahibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class FacadeSearchService {

    private EmployeeDao employeeDao;
    private CompanyDao companyDao;

    @Autowired
    public FacadeSearchService(EmployeeDao employeeDao, CompanyDao companyDao) {
        this.employeeDao = employeeDao;
        this.companyDao = companyDao;
    }

    public List<Company> findCompaniesByNameFragment(String fragment) {
        fragment = "%" + fragment + "%";
        return companyDao.retrieveCompaniesByNameFragment(fragment);
    }

    public List<Employee> findEmployeesByNameFragment(String fragment) {
        fragment = "%" + fragment + "%";
        return employeeDao.retrieveEmployeesByNameFragment(fragment);
    }
}