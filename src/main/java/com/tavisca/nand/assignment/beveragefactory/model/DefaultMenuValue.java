package com.tavisca.nand.assignment.beveragefactory.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultMenuValue {
	
	private static Map<String, List<String>> recipeList = new HashMap<>();
	private static Map<String,Float> priceMenuList = new HashMap<>();
	
	
	public static Map<String, List<String>> getRecipeList() {
		List<String> coffeeIngredient = Arrays.asList("Coffee", "milk", "sugar", "water");
		List<String> chaiIngredient = Arrays.asList("Tea", "milk", "sugar", "water");
		List<String> bananaSmoothieIngredient = Arrays.asList("banana", "milk", "sugar", "water");
		List<String> strawberryShakeIngredient = Arrays.asList("Strawberries", "milk", "sugar", "water");
		List<String> mojitoIngredient = Arrays.asList("Lemon", "soda", "sugar", "water","mint");
		recipeList.put("Coffee",coffeeIngredient );
		recipeList.put("Chai",chaiIngredient);
		recipeList.put("Banana Smoothie",bananaSmoothieIngredient);
		recipeList.put("Strawberry Shake",strawberryShakeIngredient);
		recipeList.put("Mojito",mojitoIngredient);
		
		return recipeList;
	}
	public static Map<String, Float> getPriceMenuList() {
		/*Milk: 1 $
		Sugar: 0.5 $
		Soda: 0.5 $
		mint: 0.5 $
		water: 0.5 $*/
		priceMenuList.put("milk", 0.5f);
		priceMenuList.put("sugar", 0.5f);
		priceMenuList.put("soda", 0.5f);
		priceMenuList.put("mint", 0.5f);
		priceMenuList.put("water", 0.5f);
		priceMenuList.put("Coffee", 5f);
		priceMenuList.put("Chai", 4f);
		priceMenuList.put("Banana Smoothie", 6f);
		priceMenuList.put("Strawberry Shake", 7f);
		priceMenuList.put("Mojito", 7.5f);
		
		return priceMenuList;
	}
	
	 
	
	

}
