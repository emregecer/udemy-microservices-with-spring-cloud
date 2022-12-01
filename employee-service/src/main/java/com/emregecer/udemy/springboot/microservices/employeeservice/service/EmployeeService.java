package com.emregecer.udemy.springboot.microservices.employeeservice.service;

import com.emregecer.udemy.springboot.microservices.employeeservice.dto.APIResponseDto;
import com.emregecer.udemy.springboot.microservices.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
