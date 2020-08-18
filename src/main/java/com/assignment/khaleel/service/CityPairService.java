/**
 * 
 */
package com.assignment.khaleel.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.assignment.khaleel.util.CityUtil;

/**
 * Service class to perform business operation
 * @author khaleel
 *
 */

@Service
public class CityPairService {
	
	private Map<String, Set<String>> connectedCities;
		  
	  @Autowired
	  private ResourceLoader resourceLoader;
	
	    @PostConstruct
	    public void init(){
	        Resource resource = resourceLoader.getResource("classpath:city.txt");
	        
	        try {
	            InputStream stream = resource.getInputStream();
	            connectedCities = CityUtil.getConnectedCitiesMap(stream);
	        } catch (IOException e) {
	        	
	            e.printStackTrace();
	        }
	    }
	    
	    public String isConnected(String origin, String destination) {
	    	
	    	return checkIfCitiesConnected(origin.toLowerCase(), destination.toLowerCase()) ? "yes" : "no";
	    }
	    
	    private boolean checkIfCitiesConnected(String origin, String destination){
	    	
	        Boolean isConnected = false;

	        if(connectedCities.containsKey(origin) && connectedCities.containsKey(destination)){
	        	
	            Queue<String> citiesToVisit = new LinkedList<>();
	            Set<String> citiesAlreadyVisited = new HashSet<>();
	            citiesToVisit.add(origin);

	            while (!citiesToVisit.isEmpty() && !isConnected) {
	            	
	                String city = citiesToVisit.poll();
	                isConnected = city.equals(destination);
	                Set<String> possibleConnections = connectedCities.get(city);

	                for (String possibleCity : possibleConnections) {
	                	
	                    if (!citiesAlreadyVisited.contains(possibleCity)) {
	                    	
	                        citiesToVisit.add(possibleCity);
	                        citiesAlreadyVisited.add(possibleCity);
	                    }
	                }
	            }
	        }
	        
	      return isConnected;
	    }
}
