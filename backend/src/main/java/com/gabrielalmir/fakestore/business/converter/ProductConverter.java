package com.gabrielalmir.fakestore.business.converter;

import com.gabrielalmir.fakestore.api.dto.ProductDto;
import com.gabrielalmir.fakestore.infrastructure.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
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

    public ProductEntity toEntityUpdate(ProductEntity productEntity, ProductDto productDto, String id) {
        return ProductEntity.builder()
                .id(id)
                .title(productDto.getTitle() != null ? productDto.getTitle() : productEntity.getTitle())
                .category(productDto.getCategory() != null ? productDto.getCategory() : productEntity.getCategory())
                .description(productDto.getCategory() != null ? productDto.getCategory() : productEntity.getCategory())
                .price(productDto.getPrice() != null ? productDto.getPrice() : productEntity.getPrice())
                .image(productDto.getImage() != null ? productDto.getImage() : productEntity.getImage())
                .createdAt(productEntity.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public ProductDto toDto(ProductEntity productEntity) {
        return ProductDto.builder()
                .entityId(productEntity.getId())
                .title(productEntity.getTitle())
                .category(productEntity.getCategory())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .image(productEntity.getImage())
                .build();
    }

    public List<ProductDto> toListDto(List<ProductEntity> productEntityList) {
        return productEntityList.stream().map(this::toDto).toList();
    }
}
