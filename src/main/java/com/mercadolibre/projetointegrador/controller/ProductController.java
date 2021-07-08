package com.mercadolibre.projetointegrador.controller;


import com.mercadolibre.projetointegrador.dtos.response.ProductSectionResponseDTO;
import com.mercadolibre.projetointegrador.model.Product;
import com.mercadolibre.projetointegrador.service.crud.impl.ProductServiceImpl;
import com.mercadolibre.projetointegrador.service.impl.SessionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.mercadolibre.projetointegrador.service.impl.SessionServiceImpl.getUsername;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    private final ProductServiceImpl productService;

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(
            @Valid @RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(
            @Valid @PathVariable Long id){
        productService.delete(id);
        return "Product of Id " + id + " deleted.";
    }

    @GetMapping
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
    public List<ProductSectionResponseDTO> findSectionsByProductId(
            @RequestParam(value = "product-id", required = true) Long id,
            @RequestParam(value = "order-by", required = false, defaultValue = "") String orderBy,
            @RequestHeader("Authorization") String token){
        return productService.findSectionByProductId(id,orderBy, SessionServiceImpl.getUsername(token));
    }

}
