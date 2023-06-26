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
        var productList = client.getProductList();
        productList.forEach(productDto -> {
            productService.saveProduct(productConverter.toEntity(productDto));
        });
        return productList;
    }
}
