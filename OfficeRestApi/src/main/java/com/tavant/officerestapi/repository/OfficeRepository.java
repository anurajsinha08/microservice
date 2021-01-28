package com.tavant.officerestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.officerestapi.model.Offices;

@Repository
public interface OfficeRepository extends JpaRepository<Offices, String> {

}
