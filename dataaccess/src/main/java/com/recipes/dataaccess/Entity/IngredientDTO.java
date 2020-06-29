package com.recipes.dataaccess.Entity;

public class IngredientDTO {
	
	public Long id;
	public String name;
	public int quantity;
	
	public IngredientDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "IngredientDTO [id=" + id + ", name=" + name + ", quantity=" + quantity + "]";
	}
	
	
	
}
