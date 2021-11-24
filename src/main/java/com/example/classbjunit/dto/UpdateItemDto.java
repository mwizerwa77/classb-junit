package com.example.classbjunit.dto;

import javax.validation.constraints.NotNull;

public class UpdateItemDto {
	@NotNull
	private String name;
	@NotNull
	private int price;
	@NotNull
	private int quantity;
	
	
	
	public UpdateItemDto() {
		super();
	}
	public UpdateItemDto(@NotNull String name, @NotNull int price, @NotNull int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
