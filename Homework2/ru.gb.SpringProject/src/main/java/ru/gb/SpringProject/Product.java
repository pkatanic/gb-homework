package ru.gb.SpringProject;

import java.math.BigDecimal;
public class Product {
	private String name;
	private Long id;
	private int price;
	
	public Product() {
		
	}
	
	public Product( Long id,String name, int price) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
	}
	public void setName(String name) {
        this.name = name;
    }
	public String getName() {
		return name;
	}
	public void setID(Long id)
	{
		this.id=id;
	}
	public Long getID() {
		return id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
	        this.price = price;
	}
	 @Override
	    public String toString() {
	        return String.format("Product {id = %-2s | name = %-15s | price = %-8s}", id, name, price);
	    }

	

}
