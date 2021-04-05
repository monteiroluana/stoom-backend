package br.com.qualification.stoom.controller;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class LocateControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void listAll() throws Exception {
		URI uri = new URI("/locate");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri))			
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));		
	}
	
	
	@Test
	void create() throws Exception {
		URI uri = new URI("/locate");
		String json = "{\n\t\"streetName\": \"teste\",\n\t\"number\": 321,\n\t\"complement\": \"testez\",\n\t\"neighboudhood\": \"testze\",\n\t\"city\": \"testez\",\n\t\"state\": \"tz\",\n\t\"country\": \"testez\",\n\t\"zipcode\": \"04434-110\",\n\t\"latitude\": -45.54564,\n\t\"longitude\": -23.6568\n}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(201));		
	}
	
	

	@Test
	void createError400() throws Exception {
		URI uri = new URI("/locate");
		String json = "{\n\t\"streetName\": \"\",\n\t\"number\": 321,\n\t\"complement\": \"testez\",\n\t\"neighboudhood\": \"testze\",\n\t\"state\": \"tz\",\n\t\"country\": \"testez\",\n\t\"zipcode\": \"04434-110\",\n\t\"latitude\": -45.54564,\n\t\"longitude\": -23.6568\n}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));		
	}
	
	
	@Test
	void findById() throws Exception {
		URI uri = new URI("/locate/1");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri))			
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));		
	}
	
	@Test
	void findByIdError404() throws Exception {
		URI uri = new URI("/locate/4");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri))			
		.andExpect(MockMvcResultMatchers
				.status()
				.is(404));		
	}
	
	
	@Test
	void delete() throws Exception {
		URI uri = new URI("/locate/2");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.delete(uri))			
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));		
	}
	
	
	@Test
	void update() throws Exception {
		URI uri = new URI("/locate/1");
		String json = "{\n\t\"streetName\":\"teste update\", \n\t\"number\":321,\n\t\"complement\":\"teste update\", \n\t\"neighboudhood\":\"teste update\", \n\t\"city\":\"teste update\", \n\t\"state\":\"tz\", \n\t\"country\":\"teste update\", \n\t\"zipcode\":\"testez\",\n\t\"latitude\":-45.54564,\n\t\"longitude\":-23.6568\n}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.put(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));		
	}


}
