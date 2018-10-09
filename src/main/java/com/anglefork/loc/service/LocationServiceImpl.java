package com.anglefork.loc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anglefork.loc.repository.LocartionRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	public LocartionRepository locationRepository;

	@Override
	public com.anglefork.loc.entity.Location saveLocation(com.anglefork.loc.entity.Location location) {

		return locationRepository.save(location);
	}

	@Override
	public com.anglefork.loc.entity.Location updateLocation(com.anglefork.loc.entity.Location location) {

		return locationRepository.save(location);
	}

	@Override
	public void deleteLocation(com.anglefork.loc.entity.Location location) {
		locationRepository.delete(location);
	}

	@Override
	public com.anglefork.loc.entity.Location getLocationById(int id) {

		return locationRepository.findById(id).get();
	}

	@Override
	public List<com.anglefork.loc.entity.Location> getAllLocation() {

		return locationRepository.findAll();
	}

	public LocartionRepository getLocationRepository() {
		return locationRepository;
	}

	public void setLocationRepository(LocartionRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

}
