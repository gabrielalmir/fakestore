package com.gabrielalmir.fakestore.business.service;

import com.gabrielalmir.fakestore.api.dto.ProductDto;
import com.gabrielalmir.fakestore.business.converter.ProductConverter;
import com.gabrielalmir.fakestore.infrastructure.client.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {
    private final FakeApiClient client;
    private final ProductConverter productConverter;
    private final ProductService productService;

    public List<ProductDto> getProductList() {
        try {
            var productList = client.getProductList();
            productList.forEach(productDto -> {
                var productExists = productService.existsByTitle(productDto.getTitle());
                if (!productExists) productService.saveProduct(productConverter.toEntity(productDto));
            });
            return productService.getAllProducts();
        } catch (Exception e) {
            throw new RuntimeException("Error while searching and saving the product: " + e);
        }
    }


}
