package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class ProductInOrder {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	    @JoinColumn(name = "cart_id")
	    @JsonIgnore
	    private ShoppingCart cart;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "order_id")
	    @JsonIgnore
	    private OrderMain orderMain;


	    @NotEmpty
	    private String productId;
	    
	    @NotEmpty
	    private String productName;
	    
	    @Min(0)
	    private Integer productStock;

	    @Min(1)
	    private Integer count;
        
	    @NotNull
	    private BigDecimal productPrice;
	    
	    @NotNull
	    private Integer categoryType;
	    
	    private String productIcon;
	    
	    @NotNull
	    private String productDescription;
	    
	    

	    public Long getId() {
			return id;
		}

		public ShoppingCart getCart() {
			return cart;
		}

		public OrderMain getOrderMain() {
			return orderMain;
		}

		public String getProductId() {
			return productId;
		}

		public String getProductName() {
			return productName;
		}

		public Integer getProductStock() {
			return productStock;
		}

		public Integer getCount() {
			return count;
		}

		public BigDecimal getProductPrice() {
			return productPrice;
		}

		public Integer getCategoryType() {
			return categoryType;
		}

		public String getProductIcon() {
			return productIcon;
		}

		public String getProductDescription() {
			return productDescription;
		}
		
		

		public void setId(Long id) {
			this.id = id;
		}

		public void setCart(ShoppingCart cart) {
			this.cart = cart;
		}

		public void setOrderMain(OrderMain orderMain) {
			this.orderMain = orderMain;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public void setProductStock(Integer productStock) {
			this.productStock = productStock;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public void setProductPrice(BigDecimal productPrice) {
			this.productPrice = productPrice;
		}

		public void setCategoryType(Integer categoryType) {
			this.categoryType = categoryType;
		}

		public void setProductIcon(String productIcon) {
			this.productIcon = productIcon;
		}

		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}

		public ProductInOrder(ProductInfo productInfo, Integer quantity) {
	        this.productId = productInfo.getProductId();
	        this.productName = productInfo.getProductName();
	        this.productDescription = productInfo.getProductDescription();
	        this.productIcon = productInfo.getProductIcon();
	        this.categoryType = productInfo.getCategoryType();
	        this.productPrice = productInfo.getProductPrice();
	        this.productStock = productInfo.getProductStock();
	        this.count = quantity;
	    }

	    @Override
	    public String toString() {
	        return "ProductInOrder{" +
	                "id=" + id +
	                ", productId='" + productId + '\'' +
	                ", productName='" + productName + '\'' +
	                ", productDescription='" + productDescription + '\'' +
	                ", productIcon='" + productIcon + '\'' +
	                ", categoryType=" + categoryType +
	                ", productPrice=" + productPrice +
	                ", productStock=" + productStock +
	                ", count=" + count +
	                '}';
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        if (!super.equals(o)) return false;
	        ProductInOrder that = (ProductInOrder) o;
	        return Objects.equals(id, that.id) &&
	                Objects.equals(productId, that.productId) &&
	                Objects.equals(productName, that.productName) &&
	                Objects.equals(productDescription, that.productDescription) &&
	                Objects.equals(productIcon, that.productIcon) &&
	                Objects.equals(categoryType, that.categoryType) &&
	                Objects.equals(productPrice, that.productPrice);
	    }

	    @Override
	    public int hashCode() {

	        return Objects.hash(super.hashCode(), id, productId, productName, productDescription, productIcon, categoryType, productPrice);
	    }

}
