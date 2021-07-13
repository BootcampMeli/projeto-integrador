package com.mercadolibre.projetointegrador.controller;


import com.mercadolibre.projetointegrador.model.Buyer;
import com.mercadolibre.projetointegrador.service.crud.impl.BuyerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/fresh-products/buyers")
public class BuyerController {

    private final BuyerServiceImpl buyerService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Buyer create(
            //TODO validate buyer or supervisor
            @Valid @RequestBody Buyer buyer){
        return buyerService.create(buyer);
    }

    @GetMapping("/buyers")
    @ResponseStatus(HttpStatus.OK)
    public List<Buyer> findAllBuyers(){
        return buyerService.findAll();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Buyer findById(
            @PathVariable Long id){
        return buyerService.findById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Buyer findByName(
            @PathVariable String name){
        return buyerService.findByName(name);
    }

}
