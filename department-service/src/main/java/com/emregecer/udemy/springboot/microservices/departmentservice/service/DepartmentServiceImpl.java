package com.emregecer.udemy.springboot.microservices.departmentservice.service;

import com.emregecer.udemy.springboot.microservices.departmentservice.dto.DepartmentDto;
import com.emregecer.udemy.springboot.microservices.departmentservice.entity.Department;
import com.emregecer.udemy.springboot.microservices.departmentservice.mapper.DepartmentMapper;
import com.emregecer.udemy.springboot.microservices.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto the department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
