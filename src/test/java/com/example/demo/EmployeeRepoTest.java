package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeRepoTest {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Test
    public void EmployeeRepo_SaveAll_ReturnSavedEmployees() {
        Employee employee = Employee.builder()
        .id(1)
        .lastName("John")
        .firstName("Johns")
        .designation("Engineer").build();

        Employee savedEmployee = employeeRepo.save(employee);

        Assertions.assertThat(savedEmployee).isNotNull();
        Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);

        System.out.println("Test passed: Employee saved successfully with ID " + savedEmployee.getId());
    }
}
