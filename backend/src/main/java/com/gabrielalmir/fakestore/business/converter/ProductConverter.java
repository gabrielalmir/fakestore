package com.gabrielalmir.fakestore.business.converter;

import com.gabrielalmir.fakestore.api.dto.ProductDto;
import com.gabrielalmir.fakestore.infrastructure.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class ProductConverter {
    public ProductEntity toEntity(ProductDto productDto) {
        return ProductEntity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .title(productDto.getTitle())
                .category(productDto.getCategory())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .image(productDto.getImage())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
