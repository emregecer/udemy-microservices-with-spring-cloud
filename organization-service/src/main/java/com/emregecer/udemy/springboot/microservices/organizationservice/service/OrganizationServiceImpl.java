package com.emregecer.udemy.springboot.microservices.organizationservice.service;

import com.emregecer.udemy.springboot.microservices.organizationservice.dto.OrganizationDto;
import com.emregecer.udemy.springboot.microservices.organizationservice.entity.Organization;
import com.emregecer.udemy.springboot.microservices.organizationservice.mapper.OrganizationMapper;
import com.emregecer.udemy.springboot.microservices.organizationservice.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert organizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);

        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
