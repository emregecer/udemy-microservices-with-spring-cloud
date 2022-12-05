package com.emregecer.udemy.springboot.microservices.organizationservice.service;

import com.emregecer.udemy.springboot.microservices.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizationByCode(String organizationCode);

}
