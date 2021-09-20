package service.impl;

import service.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.ProductCategory;
import enums.ResultEnum;
import exception.MyException;
import repository.ProductCategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	 @Autowired
	    ProductCategoryRepository productCategoryRepository;



	    @Override
	    public List<ProductCategory> findAll() {
	        List<ProductCategory> res = productCategoryRepository.findAllByOrderByCategoryType();
	      
	        return res;
	    }

	    @Override
	    public ProductCategory findByCategoryType(Integer categoryType) {
	        ProductCategory res = productCategoryRepository.findByCategoryType(categoryType);
	        if(res == null) throw new MyException(ResultEnum.CATEGORY_NOT_FOUND);
	        return res;
	    }

	    @Override
	    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
	        List<ProductCategory> res = productCategoryRepository.findByCategoryTypeInOrderByCategoryTypeAsc(categoryTypeList);
	       
	        return res;
	    }

	    @Override
	    @Transactional
	    public ProductCategory save(ProductCategory productCategory) {
	        return productCategoryRepository.save(productCategory);
	    }

}
