package com.tavisca.nand.assignment.beveragefactory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavisca.nand.assignment.beveragefactory.model.PriceMenuRepo;
import com.tavisca.nand.assignment.beveragefactory.model.RecipesRepo;

@Service
public class OperateBeverageFactoryService {

	@Autowired
	PriceMenuRepo priceMenu;

	@Autowired
	RecipesRepo recipes;

	public Float getPrice(String itemWithIngredientInfo) throws Exception {
		String[] items = itemWithIngredientInfo.split(",");
		List<String> ingreident = recipes.getIngredientForOneItem(items[0]);
		Float initalPrice = priceMenu.getPriceOfOneItem(items[0]);
		List<String> ingredientToRemove = getIngredientFromInput(itemWithIngredientInfo);
		if(ingreident.equals(ingredientToRemove)){
			throw new Exception("Can't remove all items");
		}
		for (String oneIngredent : ingredientToRemove) {
			if (ingreident.contains(oneIngredent)) {
				initalPrice -= priceMenu.getPriceOfOneItem(oneIngredent);
			}
		}
		return initalPrice;
	}

	private List<String> getIngredientFromInput(String itemWithIngredientInfo) {
		String[] items = itemWithIngredientInfo.split(",");
		List<String> ingredientToRemove = new ArrayList<>();
		for (int i = 1; i < items.length; i++) {
			if (items[i].charAt(0) == '-') {
				ingredientToRemove.add(items[i].substring(1, items[i].length()));
			}
		}
		return ingredientToRemove;
	}

}
