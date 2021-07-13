package com.mercadolibre.projetointegrador.controller;


import com.mercadolibre.projetointegrador.dtos.UserDTO;
import com.mercadolibre.projetointegrador.model.Buyer;
import com.mercadolibre.projetointegrador.service.crud.impl.BuyerServiceImpl;
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
@RequestMapping("/api/v1/fresh-products/buyers")
public class BuyerController {

    private final BuyerServiceImpl buyerService;

    @Operation(summary = "US06 - Buyers - Create new buyer", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Buyer create(
            @Valid @RequestBody Buyer buyer){
        return buyerService.create(buyer);
    }

    @Operation(summary = "US06 - Buyers - Get all buyers in database", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @GetMapping("/buyers")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAllBuyers(){
        return buyerService.findAllBuyers();
    }

    @Operation(summary = "US06 - Buyers - Get a buyer by it's ID", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findById(
            @PathVariable Long id){
        return buyerService.findBuyerById(id);
    }

    @Operation(summary = "US06 - Buyers - Get a buyer by it's name", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findByName(
            @PathVariable String name){
        return buyerService.findBuyerByName(name);
    }

}
