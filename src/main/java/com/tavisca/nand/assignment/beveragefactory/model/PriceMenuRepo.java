package com.tavisca.nand.assignment.beveragefactory.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class PriceMenuRepo {
	
	Map<String,Float> priceMenuList = DefaultMenuValue.getPriceMenuList();
	
	public Float getPriceOfOneItem(String itemName) {
		return priceMenuList.get(itemName);
	}
	public Map<String, Float> getPriceMenuList() {
		return new HashMap<>(priceMenuList);
	}

	public void addItem(String items, Float price) {
		this.priceMenuList.put(items, price);
	}
	
	public void setPriceMenuList(Map<String, Float> priceMenuList) {
		this.priceMenuList = priceMenuList;
	}

}
