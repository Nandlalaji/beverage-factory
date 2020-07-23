package com.tavisca.nand.assignment.beveragefactory.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.tavisca.nand.assignment.beveragefactory.service.OperateBeverageFactoryService;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
	
	@MockBean
	OperateBeverageFactoryService service;
	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;
	
	@Before
	public void init() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testExecuteFlow() throws Exception {
	when(service.getPrice(Mockito.any(String.class))).thenReturn(new Float(3.0));

	mockMvc.perform( MockMvcRequestBuilders
			      .get("/placeOrder/Chai,-sugar,-milk")
			      .accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andReturn();
	}

}
