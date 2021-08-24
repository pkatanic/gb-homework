package model;

import java.math.BigDecimal;

public class Product implements Copyable {
	private String name;
	private Long id;
	private BigDecimal price;
	
	public Product() {
		
	}
	
	public Product( Long id,String name, BigDecimal price) {
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
	        this.price = price;
	}
	 @Override
	    public String toString() {
	        return String.format("Product {id = %-2s | name = %-15s | price = %-8s}", id, name, price);
	    }

	@Override
	public Object copy() {
		Product copy = new Product(id,name,price);
		return copy;
	}

}