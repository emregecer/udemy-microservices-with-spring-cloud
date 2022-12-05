package com.emregecer.udemy.springboot.microservices.organizationservice.repository;

import com.emregecer.udemy.springboot.microservices.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Organization findByOrganizationCode(String organizationCode);

}
