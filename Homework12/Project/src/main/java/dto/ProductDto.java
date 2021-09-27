package dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductDto {

    private Long id;
    private String title;
    private BigDecimal price;
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void setTitle(String title) {
		this.title = title;
	}
    
    

}