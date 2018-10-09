package com.anglefork.loc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anglefork.loc.entity.Location;
import com.anglefork.loc.service.LocationService;

@Controller
//@RequestMapping("/location")
public class LocationController {

	@Autowired
	LocationService locationService;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {

		Location locationSaved = locationService.saveLocation(location);
		String message = "Location Saved with id:" + locationSaved.getId();
		modelMap.addAttribute("msg", message);
		return "createLocation";

	}

	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = locationService.getAllLocation();
		modelMap.addAttribute("locations", locations);

		return "displayLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocations(@RequestParam("id") int id,ModelMap modelMap) {
		Location location = locationService.getLocationById(id);
		locationService.deleteLocation(location);
		List<Location> locations = locationService.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	@RequestMapping("/updateLocation")
	public String showUpdate(@RequestParam("id") int id,ModelMap modelMap) {
		Location location = locationService.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "editLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		
		locationService.updateLocation(location);
		List<Location> locations = locationService.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
}
