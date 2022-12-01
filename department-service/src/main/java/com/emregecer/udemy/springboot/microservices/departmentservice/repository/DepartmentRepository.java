package com.emregecer.udemy.springboot.microservices.departmentservice.repository;

import com.emregecer.udemy.springboot.microservices.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode);

}
