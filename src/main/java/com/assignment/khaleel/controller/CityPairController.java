/**
 * 
 */
package com.assignment.khaleel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.khaleel.service.CityPairService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author khaleel
 * Rest Controller class which intercepts the http user requests
 *
 */

@RestController
@RequestMapping(value="/connected")
public class CityPairController {

	@Autowired
	CityPairService cityPairService;
	

	  @GetMapping
	  @ApiOperation(value = "isConnected",
	  notes = "Provide origin and destination cities to check if they are connected", response = String.class)
	    public String isConnected(@ApiParam(name = "origin", value = "provide origin city name", required = true) @RequestParam String origin,
	    		@ApiParam(name = "destination", value = "provide destination city name", required = true) @RequestParam String destination) {
		  
	        return cityPairService.isConnected(origin, destination);
	}
}
