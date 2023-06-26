package com.gabrielalmir.fakestore.api.dto;

import com.gabrielalmir.fakestore.business.service.FakeApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name="fakestore")
public class FakeApiController {
    private final FakeApiService service;

    @Operation(summary = "Search all products", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Products search successful"),
        @ApiResponse(responseCode = "500", description = "Error on products search result")
    })
    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getProductList() {
        return ResponseEntity.ok(service.getProductList());
    }
}
