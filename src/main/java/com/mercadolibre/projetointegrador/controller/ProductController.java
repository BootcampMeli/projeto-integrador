package com.mercadolibre.projetointegrador.controller;

import com.mercadolibre.projetointegrador.dtos.response.ProductSectionResponseDTO;
import com.mercadolibre.projetointegrador.dtos.response.WarehouseStockResponseDTO;
import com.mercadolibre.projetointegrador.model.Product;
import com.mercadolibre.projetointegrador.service.crud.impl.ProductServiceImpl;
import com.mercadolibre.projetointegrador.service.impl.SessionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@Valid @RequestBody Product product){
        return productService.create(product);
    }

    @Operation(summary = "US02 - Get all Products", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))),
    })
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Product findByName(@PathVariable String name){
        return productService.findByName(name);
    }

    @GetMapping("/seller/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAllBySellerName(@PathVariable String name){
        return productService.findAllBySellerName(name);
    }

    @GetMapping("/section")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "US03 - Check Product Location in Warehouse", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductSectionResponseDTO.class))),
    })
    public List<ProductSectionResponseDTO> findSectionsByProductId(
            @RequestParam(value = "product-id") Long id,
            @RequestParam(value = "order-by", required = false, defaultValue = "") String orderBy,
            @RequestHeader("Authorization") String token){
        return productService.findSectionStockByProductId(id,orderBy, SessionServiceImpl.getUsername(token));
    }

    @GetMapping("/warehouse")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "US04 - Check Product Stock in Warehouse", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = WarehouseStockResponseDTO.class))),
    })
    public WarehouseStockResponseDTO findProductstockInWarehouse(
            @RequestParam(value = "product-id") Long id){
        return productService.findProductstockInWarehouses(id);
    }
}
