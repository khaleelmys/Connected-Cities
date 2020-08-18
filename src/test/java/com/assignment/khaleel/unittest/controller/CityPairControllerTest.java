package com.assignment.khaleel.unittest.controller;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.assignment.khaleel.controller.CityPairController;
import com.assignment.khaleel.service.CityPairService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CityPairController.class)
class CityPairControllerTest {
   
	@Autowired
	private MockMvc mockMvc;
	
    @MockBean
  	private CityPairService cityService;
	
     
    @Test
    public void testCheckRoutesExistsOrNot_yes() throws Exception {
        Mockito.when(
        		cityService.isConnected(Mockito.anyString(),
                        Mockito.anyString())).thenReturn("yes");
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/connected?origin=boston&destination=new york");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("yes", result.getResponse().getContentAsString());
    }

    @Test
    public void testCheckRoutesExistsOrNot_no() throws Exception {
        Mockito.when(
        		cityService.isConnected(Mockito.anyString(),
                        Mockito.anyString())).thenReturn("no");
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/connected?origin=philadelphia&destination=albany");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("no", result.getResponse().getContentAsString());
    }
    
    @Test
    public void testRouteExistsOrNotWhenInputIsInvalidThenNo() throws Exception {
        Mockito.when(
        		cityService.isConnected(Mockito.anyString(),
                        Mockito.anyString())).thenReturn("no");
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/connected?origin=&destination=unknown");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("no", result.getResponse().getContentAsString());
    }

    @Test
    public void testRouteExistsOrNotWhenCityIsUnknown() throws Exception {
        Mockito.when(
        		cityService.isConnected(Mockito.anyString(),
                        Mockito.anyString())).thenReturn("no");
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/connected?origin=unknownOrig&destination=unknownDest");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("no", result.getResponse().getContentAsString());
    }
    
}
