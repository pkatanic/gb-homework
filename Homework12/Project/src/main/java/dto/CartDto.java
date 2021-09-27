package dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import entities.Product;

@Data
public class CartDto {

    private Map<Product, Integer> cartMap = new HashMap<>();
    private BigDecimal totalSum;

}
