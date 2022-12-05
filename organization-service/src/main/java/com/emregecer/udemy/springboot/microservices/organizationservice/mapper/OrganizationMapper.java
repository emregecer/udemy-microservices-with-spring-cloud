package com.emregecer.udemy.springboot.microservices.organizationservice.mapper;

import com.emregecer.udemy.springboot.microservices.organizationservice.dto.OrganizationDto;
import com.emregecer.udemy.springboot.microservices.organizationservice.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDto mapToOrganizationDto(Organization organization) {
        return new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedDate()
        );
    }

    public static Organization mapToOrganization(OrganizationDto organizationDto) {
        return new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreatedDate()
        );
    }
}
