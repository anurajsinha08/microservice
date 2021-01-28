package com.tavant.officerestapi.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.officerestapi.model.Offices;
import com.tavant.officerestapi.repository.OfficeRepository;

@Service
public class OfficeServiceImpl implements OfficeService {

	@Autowired
	OfficeRepository officeDAO;
	
	@Override
	public boolean addOffice(Offices office) {
		Offices off = officeDAO.save(office); 
		return off!=null;
	}

	@Override
	public Optional<Offices> updateOffice(String offID, Offices office) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteOffice(String offID) {
		// TODO Auto-generated method stub
		if(officeDAO.existsById(offID)) {
			officeDAO.deleteById(offID);
			return "success";
		}
		return "fail";
	}

	@Override
	public Optional<Offices> getOfficeById(String offID) {
		// TODO Auto-generated method stub
		return officeDAO.findById(offID);
	}

	@Override
	public Optional<List<Offices>> getOffices() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(officeDAO.findAll());
	}

	@Override
	public boolean officeExistById(String offID) {
		// TODO Auto-generated method stub
		if(officeDAO.existsById(offID)) {
			return true;
		}
		else
			return false;
	}

	@Override
	public Optional<Set<String>> checkOfficeCode() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
