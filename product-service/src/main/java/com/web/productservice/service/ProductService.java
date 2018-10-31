package com.web.productservice.service;

import com.web.productservice.dto.ProductDto;
import com.web.productservice.model.Product;

public interface ProductService extends GrudOperations<Product> {

    Product create(ProductDto productDto);

}
