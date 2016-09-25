package com.tcs.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tcs.model.Country;

public class CountryService {
	
	private Map<Integer,Country> countryMap = getCountryMap();
	/*
	 * Initially this countryMap will be null
	 */
	
	public CountryService()
	{
		super();
		if(countryMap == null)
		{
			countryMap = new HashMap<Integer, Country>();
			Country india = new Country(1, "India", 1000000);
			Country china = new Country(2, "China", 4000000);
			Country america = new Country(3, "America", 5000000);
			Country australia = new Country(4, "Australia", 2000000);
			countryMap.put(1, india);
			countryMap.put(2, china);
			countryMap.put(3, america);
			countryMap.put(4, australia);
		}
	}
	
	public List<Country> getCountries()
	{
		Map<Integer, Country> countryMap = getCountryMap();
		List<Country> list = new ArrayList<Country>(countryMap.values());
		return list;
	}
	
	public Country getCountryById(int id)
	{
		Map<Integer, Country> countryMap = getCountryMap();
		Country country = countryMap.get(id);
		return country;
	}
	
	public Country addCountry(Country country)  
	 {  
	  country.setId(getMaxId()+1);  
	  System.out.println(country.getId());
	  countryMap.put(country.getId(), country); 
	  System.out.println("Now here");
	  return country;  
	 }  
	   

	
	public Country updateCountry(Country country)
	{
		
		if(country.getId() < 0)
		{
			return null;
		}
		else
		{
			countryMap.put(country.getId(), country);
			return country;
		}
	}
	
	public String deleteCountry(int id)
	{
		Map<Integer, Country> countryMap = getCountryMap();
		countryMap.remove(id);
		
		return "success";
	}
	
	public Map<Integer,Country> getCountryMap()
	{
		return countryMap; // This countryMap will be null initially. Therefore, null be returned initially.
	}
	
	
	public int getMaxId()
	{
		int max = 0;
		Map<Integer, Country> countryMap = getCountryMap();
		Set<Integer> keys = countryMap.keySet();
		Iterator<Integer> itr = keys.iterator();
		while(itr.hasNext())
		{
			System.out.println("Inside here");
			int num = itr.next();
			if(max < num)
			{
				max = num;
			}
		}
		System.out.println("Id : " + max);
		return max;
	}

}
