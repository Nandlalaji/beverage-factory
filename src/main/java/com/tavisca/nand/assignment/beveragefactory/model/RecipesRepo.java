package com.tavisca.nand.assignment.beveragefactory.model;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class RecipesRepo {
	
	Map<String, List<String>> recipeList = DefaultMenuValue.getRecipeList();
	

	public Map<String, List<String>> getRecipeList() {
		return recipeList;
	}
	
	public List<String> getIngredientForOneItem(String item){
		if(recipeList.containsKey(item))
			return recipeList.get(item);
		return null;
	}
	
	public void setRecipeList(Map<String, List<String>> recipeList) {
		this.recipeList = recipeList;
	}
	
	public void addIngredientToReceipe(String mainItem, String ingredient){
		List<String> ingredients = recipeList.get(mainItem);
		ingredients.add(ingredient);
		recipeList.put(mainItem, ingredients);
	}
	public void removeIngredientToReceipe(String mainItem, String ingredient){
		//To do
	}
}
