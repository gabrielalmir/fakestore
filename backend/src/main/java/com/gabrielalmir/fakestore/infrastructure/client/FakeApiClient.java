package com.gabrielalmir.fakestore.infrastructure.client;

import com.gabrielalmir.fakestore.api.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value="fakestore", url="${fakestore.url:#{null}}")
public interface FakeApiClient {
    @GetMapping("/products")
    List<ProductDto> getProductList();
}
