import java.util.List;

import implementation.CartImpl;
import implementation.ProductImpl;
import model.CartInterface;
import model.ProductInterface;

public class ShoppingApp {
	private  ProductInterface productInter;
	private CartInterface cartInter;
	
	public ShoppingApp(ProductInterface productInter, CartImpl cartInter)
	{
		this.productInter=productInter;
		this.cartInter = cartInter;
	}
	 private static void printList(List<?> list) {
	        System.out.println("—œ»—Œ  œ–Œƒ” “Œ¬:");
	        for (Object el : list) {
	            System.out.println(el.toString());
	        }
	    }
	 public static void main(String[] args) {
	 
	 }

}
