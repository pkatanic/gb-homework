package model;
import java.util.ArrayList;
import java.util.List;
public class ShoppingCart {
	
List<Product> products;
	
	public ShoppingCart(){
		this.products=new ArrayList<Product>();
	}
	
	public void addProduct(Product product){
		this.products.add(product);
	}
	
	public void removeProduct(Product product){
		this.products.remove(product);
	}
	
	

}
