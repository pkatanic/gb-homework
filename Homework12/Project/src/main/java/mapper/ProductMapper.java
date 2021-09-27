package mapper;

import java.util.List;

import org.mapstruct.factory.Mappers;

import dto.ProductDto;
import entities.Product;

public interface ProductMapper {
	   ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

	    Product toProduct(ProductDto productDto);
	    ProductDto fromProduct(Product product);

	    List<Product> toProductList(List<ProductDto> productDtos);
	    List<ProductDto> fromProductList(List<Product> products);
}
