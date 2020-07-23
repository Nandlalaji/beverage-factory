package com.tavisca.nand.assignment.beveragefactory.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.tavisca.nand.assignment.beveragefactory.model.PriceMenuRepo;
import com.tavisca.nand.assignment.beveragefactory.model.RecipesRepo;

@RunWith(SpringRunner.class)
public class OperateBeverageFactoryServiceTest {

	@InjectMocks
	OperateBeverageFactoryService service;

	@Mock
	PriceMenuRepo priceMenu;

	@Mock
	RecipesRepo recipes;

	@Before
	public void init() {
	}

	@Test
	public void testGgetPrice() throws Exception {
		when(recipes.getIngredientForOneItem(Mockito.any(String.class))).thenReturn(Arrays.asList("Tea", "milk", "sugar", "water"));
		when(priceMenu.getPriceOfOneItem("Chai")).thenReturn(5.0f);
		when(priceMenu.getPriceOfOneItem("sugar")).thenReturn(1f);
		when(priceMenu.getPriceOfOneItem("milk")).thenReturn(0.5f);
		System.out.println(service.getPrice("Chai,-sugar,-milk"));
		assertTrue(service.getPrice("Chai,-sugar,-milk")==3.5f);
	}

}
