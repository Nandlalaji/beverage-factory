package com.tavisca.nand.assignment.beveragefactory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tavisca.nand.assignment.beveragefactory.service.OperateBeverageFactoryService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class OrderController {

	@Autowired
	OperateBeverageFactoryService service;

	@GetMapping(value = "/placeOrder/{orderValue}")
	public Float executeFlow(@PathVariable("orderValue") String orderValue) throws Exception {
		return service.getPrice(orderValue);
	}

}
