package com.emregecer.udemy.springboot.microservices.employeeservice.service;

import com.emregecer.udemy.springboot.microservices.employeeservice.dto.APIResponseDto;
import com.emregecer.udemy.springboot.microservices.employeeservice.dto.DepartmentDto;
import com.emregecer.udemy.springboot.microservices.employeeservice.dto.EmployeeDto;
import com.emregecer.udemy.springboot.microservices.employeeservice.entity.Employee;
import com.emregecer.udemy.springboot.microservices.employeeservice.mapper.EmployeeMapper;
import com.emregecer.udemy.springboot.microservices.employeeservice.repository.EmployeeRepository;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    //private RestTemplate restTemplate;

    private WebClient webClient;

    //private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getEmployeeById(Long employeeId) {
        LOGGER.info("Inside getEmployeeById() method");
        Employee employee = employeeRepository.findById(employeeId).get();

        /*
        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
                "http://localhost:8079/api/departments/" + employee.getDepartmentCode(),
                DepartmentDto.class
        );

        DepartmentDto departmentDto = responseEntity.getBody();
         */

        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8079/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        //DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto(
                employeeDto,
                departmentDto
        );

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {
        LOGGER.info("Inside getDefaultDepartment() method");

        Employee employee = employeeRepository.findById(employeeId).get();

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        return new APIResponseDto(
                employeeDto,
                departmentDto
        );
    }
}
