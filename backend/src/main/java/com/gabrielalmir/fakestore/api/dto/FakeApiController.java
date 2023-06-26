package com.gabrielalmir.fakestore.api.dto;

import com.gabrielalmir.fakestore.business.service.FakeApiService;
import com.gabrielalmir.fakestore.business.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name="fakestore")
public class FakeApiController {
    private final FakeApiService service;
    private final ProductService productService;

    @Operation(summary = "Search and save all products", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Products searched/saved successfully"),
        @ApiResponse(responseCode = "500", description = "Error on products search & save result")
    })
    @PostMapping("/api")
    public ResponseEntity<List<ProductDto>> saveProductsApi() {
        return ResponseEntity.ok(service.getProductList());
    }

    @Operation(summary = "Save new products", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product saved successfully"),
            @ApiResponse(responseCode = "500", description = "Error on saving product")
    })
    @PostMapping("/")
    public ResponseEntity<ProductDto> saveProducts(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.saveProductDTO(productDto));
    }

    @Operation(summary = "Update products", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully"),
            @ApiResponse(responseCode = "500", description = "Error on updating product")
    })
    @PutMapping("/")
    public ResponseEntity<ProductDto> updateProduct(
            @RequestParam String id,
            @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(id, productDto));
    }

    @Operation(summary = "Delete products", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "500", description = "Error on deleting product")
    })
    @DeleteMapping("/")
    public ResponseEntity<Void> deleteProduct(@RequestParam String title) {
        productService.deleteProduct(title);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Search all products", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products searched successfully"),
            @ApiResponse(responseCode = "500", description = "Error on products search & save result")
    })
    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Operation(summary = "Search products by title", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products searched by title successfully"),
            @ApiResponse(responseCode = "500", description = "Error on products search & save result")
    })
    @GetMapping("/{title}")
    public ResponseEntity<ProductDto> getProductByTitle(@PathVariable String title) {
        return ResponseEntity.ok(productService.getProductByTitle(title));
    }
}
