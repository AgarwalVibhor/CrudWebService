package com.tcs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcs.services.CountryService;
import com.tcs.model.Country;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService service;
	
	@RequestMapping(value = "/countries.spring", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Country> getCountries()
	{
		return service.getCountries();
	}
	
	@RequestMapping(value = "/country/{id}.spring", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Country getCountryById(@PathVariable int id)
	{
		return service.getCountryById(id);
	}
	
	@RequestMapping(value = "/countries.spring", method = RequestMethod.POST, headers = "Accept=application/json")
	 public @ResponseBody Country addCountry(@RequestBody Country country) {  
	  return service.addCountry(country);  
	 }  

	
	@RequestMapping(value = "/countries.spring", method = RequestMethod.PUT, headers = "Accept=application/json")
	@ResponseBody
	public Country updateCountry(@RequestBody Country country)
	{
		return service.updateCountry(country);
	}
	
	@RequestMapping(value = "/country/{id}.spring", method = RequestMethod.DELETE ) // headers="Accept=application/json" are not to be used in DELETE
	@ResponseBody
	public String deleteCountry(@PathVariable int id)
	{
	
		return service.deleteCountry(id);
	}

}
