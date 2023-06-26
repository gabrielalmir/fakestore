package com.gabrielalmir.fakestore.business.service;

import com.gabrielalmir.fakestore.infrastructure.entities.ProductEntity;
import com.gabrielalmir.fakestore.infrastructure.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public ProductEntity saveProduct(ProductEntity productEntity) {
        try {
            return productRepository.save(productEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving products" + e);
        }
    }
}
