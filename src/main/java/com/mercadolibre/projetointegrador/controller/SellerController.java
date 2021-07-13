package com.mercadolibre.projetointegrador.controller;


import com.mercadolibre.projetointegrador.dtos.UserDTO;
import com.mercadolibre.projetointegrador.model.Seller;
import com.mercadolibre.projetointegrador.service.crud.impl.SellerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/fresh-products/sellers")
public class SellerController {

    private final SellerServiceImpl sellerService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Seller create(
            @Valid @RequestBody Seller seller){
        return sellerService.create(seller);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAllSellers(){
        return sellerService.findAllSellers();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findById(@PathVariable Long id){
        return sellerService.findSellerById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findByName(@PathVariable String name){
        return sellerService.findSellerByName(name);
    }
}
