package com.kodilla.kodillahibernate.manytomany.dao;

import com.kodilla.kodillahibernate.manytomany.Company;
import com.kodilla.kodillahibernate.manytomany.Employee;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testNamedQueries() {
        //Given
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
        int transponsterId = transponster.getId();
        companyDao.save(dataAnalytics);
        int dataAnalyticsId = dataAnalytics.getId();
        companyDao.save(alessandros);
        int alessandrosId = alessandros.getId();

        //When
        List<Employee> employeesByLastname = employeeDao.retrieveEmployeesByLastname("Smith");
        List<Company> companiesByFirstThreeCharactersOfName = companyDao.retrieveCompaniesByFirstThreeCharactersOfName("Tra");

        //Then
        assertEquals(2, employeesByLastname.size());
        assertEquals(1, companiesByFirstThreeCharactersOfName.size());

        //CleanUp
        try {
            companyDao.deleteById(transponsterId);
            companyDao.deleteById(dataAnalyticsId);
            companyDao.deleteById(alessandrosId);
        } catch (Exception e) {
            //do nothing
        }
    }
}