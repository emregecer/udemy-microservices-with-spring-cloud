package com.emregecer.udemy.springboot.microservices.departmentservice.service;

import com.emregecer.udemy.springboot.microservices.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String departmentCode);

}
