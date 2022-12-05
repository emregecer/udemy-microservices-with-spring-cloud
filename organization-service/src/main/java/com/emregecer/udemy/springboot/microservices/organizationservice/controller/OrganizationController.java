package com.emregecer.udemy.springboot.microservices.organizationservice.controller;

import com.emregecer.udemy.springboot.microservices.organizationservice.dto.OrganizationDto;
import com.emregecer.udemy.springboot.microservices.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    // Build Save Organization REST API
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);

        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    // Build Get Organization by Code REST API
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("code") String organizationCode) {
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);

        return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }
}
