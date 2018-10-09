package com.anglefork.loc.service;

import java.util.List;

import com.anglefork.loc.entity.Location;

public interface LocationService {

	/**
	 * 
	 * @param location
	 * @return
	 */
	public Location saveLocation(Location location);

	/**
	 * 
	 * @param location
	 * @return
	 */
	public Location updateLocation(Location location);
	/**
	 * 
	 * @param location
	 */

	public void deleteLocation(Location location);
	/**
	 * 
	 * @param id
	 * @return
	 */

	public Location getLocationById(int id);
	/**
	 * 
	 * @return
	 */

	public List<Location> getAllLocation();

}
