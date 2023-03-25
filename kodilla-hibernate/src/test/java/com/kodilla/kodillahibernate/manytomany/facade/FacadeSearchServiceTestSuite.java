package com.kodilla.kodillahibernate.manytomany.facade;

import com.kodilla.kodillahibernate.manytomany.Company;
import com.kodilla.kodillahibernate.manytomany.Employee;
import com.kodilla.kodillahibernate.manytomany.dao.CompanyDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FacadeSearchServiceTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private FacadeSearchService facadeSearchService;

    private int testId1;
    private int testId2;
    private int testId3;

    @BeforeEach
    public void prepareData() {
        Employee johnSmith = new Employee("John", "Smith");
        Employee eveSmith = new Employee("Eve", "Smith");
        Employee monicaGeller = new Employee("Monica", "Geller");
        Employee chandlerBing = new Employee("Chandler", "Bing");

        Company transponster = new Company("Transponster");
        Company dataAnalytics = new Company("Data Analytics");
        Company alessandros = new Company("Alessandro's");

        transponster.getEmployees().add(chandlerBing);
        transponster.getEmployees().add(eveSmith);
        dataAnalytics.getEmployees().add(chandlerBing);
        dataAnalytics.getEmployees().add(johnSmith);
        alessandros.getEmployees().add(monicaGeller);
        alessandros.getEmployees().add(eveSmith);

        chandlerBing.getCompanies().add(transponster);
        chandlerBing.getCompanies().add(dataAnalytics);
        johnSmith.getCompanies().add(dataAnalytics);
        monicaGeller.getCompanies().add(alessandros);
        eveSmith.getCompanies().add(alessandros);
        eveSmith.getCompanies().add(dataAnalytics);

        companyDao.save(transponster);
        testId1 = transponster.getId();
        companyDao.save(dataAnalytics);
        testId2 = dataAnalytics.getId();
        companyDao.save(alessandros);
        testId3 = alessandros.getId();
    }

    @AfterEach
    public void cleanUpData() {
        try {
            companyDao.deleteById(testId1);
            companyDao.deleteById(testId2);
            companyDao.deleteById(testId3);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void findEmployeesByNameFragmentTest() {
        //Given && //When
        List<Employee> resultListOfEmployees = facadeSearchService.findEmployeesByNameFragment("ll");
        //Then
        assertEquals(1,resultListOfEmployees.size());
        System.out.println("\nResult list of employees:\n");
        for (Employee employee:resultListOfEmployees) {
            System.out.println(employee.getFirstname() + " " + employee.getLastname());
        }
        System.out.println("\nEnd of list\n");
    }

    @Test
    void findCompaniesByNameFragmentTest() {
        //Given && //When
        List<Company> resultListOfCompanies = facadeSearchService.findCompaniesByNameFragment("an");
        //Then
        assertEquals(3,resultListOfCompanies.size());
        System.out.println("\nResult list of companies:\n");
        for (Company company:resultListOfCompanies) {
            System.out.println(company.getName());
        }
        System.out.println("\nEnd of list\n");
    }
}