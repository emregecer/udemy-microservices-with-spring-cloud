package com.emregecer.udemy.springboot.microservices.employeeservice.repository;

import com.emregecer.udemy.springboot.microservices.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
