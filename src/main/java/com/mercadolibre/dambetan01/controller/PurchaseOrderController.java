package com.mercadolibre.dambetan01.controller;

import com.mercadolibre.dambetan01.dtos.NewPurchaseOrderDTO;
import com.mercadolibre.dambetan01.model.Product;
import com.mercadolibre.dambetan01.service.PurchaseOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/orders")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts(@PathVariable Long id){
        return purchaseOrderService.getProducts(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public double insertPurchaseOder(@Valid @RequestBody NewPurchaseOrderDTO purchaseOrderDTO){

        return 0;
    }
}
