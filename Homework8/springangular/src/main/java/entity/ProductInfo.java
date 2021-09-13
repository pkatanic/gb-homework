package entity;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductInfo implements Serializable {
	  @Id
	    private String productId;

	    
	    @NotNull
	    private String productName;

	    
	    @NotNull
	    private BigDecimal productPrice;

	    
	    @NotNull
	    @Min(0)
	    private Integer productStock;

	   
	    private String productDescription;

	    
	    private String productIcon;

	    
	    

	    public void setProductId(String productId) {
			this.productId = productId;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public void setProductPrice(BigDecimal productPrice) {
			this.productPrice = productPrice;
		}

		public void setProductStock(Integer productStock) {
			this.productStock = productStock;
		}

		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}

		public void setProductIcon(String productIcon) {
			this.productIcon = productIcon;
		}

		public void setProductStatus(Integer productStatus) {
			this.productStatus = productStatus;
		}

		public void setCategoryType(Integer categoryType) {
			this.categoryType = categoryType;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}

		public String getProductId() {
			return productId;
		}

		public String getProductName() {
			return productName;
		}

		public BigDecimal getProductPrice() {
			return productPrice;
		}

		public Integer getProductStock() {
			return productStock;
		}

		public String getProductDescription() {
			return productDescription;
		}

		public String getProductIcon() {
			return productIcon;
		}

		public Integer getProductStatus() {
			return productStatus;
		}

		public Integer getCategoryType() {
			return categoryType;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public Date getUpdateTime() {
			return updateTime;
		}

		@ColumnDefault("0")
	    private Integer productStatus;


	   
	    @ColumnDefault("0")
	    private Integer categoryType;

	    @CreationTimestamp
	    private Date createTime;
	    @UpdateTimestamp
	    private Date updateTime;

	    public ProductInfo() {
	    }
}
