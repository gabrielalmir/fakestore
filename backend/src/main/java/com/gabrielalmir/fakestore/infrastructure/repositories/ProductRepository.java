package com.gabrielalmir.fakestore.infrastructure.repositories;

import com.gabrielalmir.fakestore.infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
