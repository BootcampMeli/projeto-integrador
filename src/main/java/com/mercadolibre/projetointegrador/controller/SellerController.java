package com.mercadolibre.projetointegrador.controller;


import com.mercadolibre.projetointegrador.dtos.UserDTO;
import com.mercadolibre.projetointegrador.model.Buyer;
import com.mercadolibre.projetointegrador.model.Seller;
import com.mercadolibre.projetointegrador.service.crud.impl.SellerServiceImpl;
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
@RequestMapping("/api/v1/fresh-products/sellers")
public class SellerController {

    private final SellerServiceImpl sellerService;

    @Operation(summary = "US06 - Sellers - Create a new seller", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Seller create(
            @Valid @RequestBody Seller seller){
        return sellerService.create(seller);
    }

    @Operation(summary = "US06 - Sellers - Get all sellers in database", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAllSellers(){
        return sellerService.findAllSellers();
    }

    @Operation(summary = "US06 - Sellers - Get a seller by it's ID", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findById(@PathVariable Long id){
        return sellerService.findSellerById(id);
    }

    @Operation(summary = "US06 - Sellers - Get a seller by it's name", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findByName(@PathVariable String name){
        return sellerService.findSellerByName(name);
    }
}
