package com.gabrielalmir.fakestore.business.service;

import com.gabrielalmir.fakestore.api.dto.ProductDto;
import com.gabrielalmir.fakestore.business.converter.ProductConverter;
import com.gabrielalmir.fakestore.infrastructure.entities.ProductEntity;
import com.gabrielalmir.fakestore.infrastructure.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public void saveProduct(ProductEntity productEntity) {
        try {
            productRepository.save(productEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving products: " + e);
        }
    }

    public ProductDto saveProductDTO(ProductDto productDto) {
        try {
            var productEntity = productConverter.toEntity(productDto);
            return productConverter.toDto(productRepository.save(productEntity));
        } catch (Exception e) {
            throw new RuntimeException("Error while saving products: " + e);
        }
    }

    public ProductDto getProductByTitle(String title) {
        try {
            return productConverter.toDto(productRepository.findByTitle(title));
        } catch (Exception e) {
            throw new RuntimeException("Error while getting the product by title: " + title + e);
        }
    }

    public List<ProductDto> getAllProducts() {
        try {
            return productConverter.toListDto(productRepository.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Error while getting all products: " + e);
        }
    }

    public void deleteProduct(String title) {
        try {
            productRepository.deleteByTitle(title);
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting the product by title: " + title + e);
        }
    }

    public ProductDto updateProduct(String id, ProductDto productDto) {
        try {
            var productEntity = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product id not found"));
            saveProduct(productConverter.toEntityUpdate(productEntity, productDto, id));
            return productConverter.toDto(productRepository.findByTitle(productEntity.getTitle()));
        } catch (Exception e) {
            throw new RuntimeException("Error while updating the product by title: " + id + e);
        }
    }

    public boolean existsByTitle(String title) {
        try {
            return productRepository.existsByTitle(title);
        } catch (Exception e) {
            throw new RuntimeException("Error while getting the product by title: " + title + e);
        }
    }
}
