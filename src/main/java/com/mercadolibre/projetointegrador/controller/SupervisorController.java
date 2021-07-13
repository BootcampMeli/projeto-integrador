package com.mercadolibre.projetointegrador.controller;


import com.mercadolibre.projetointegrador.dtos.UserDTO;
import com.mercadolibre.projetointegrador.model.Buyer;
import com.mercadolibre.projetointegrador.model.Supervisor;
import com.mercadolibre.projetointegrador.service.crud.impl.SupervisorServiceImpl;
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
@RequestMapping("/api/v1/fresh-products/supervisors")
public class SupervisorController {

    private final SupervisorServiceImpl supervisorService;

    @Operation(summary = "US06 - Supervisors - Create a new supervisor", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Supervisor create(
            @Valid @RequestBody Supervisor supervisor){
        return supervisorService.create(supervisor);
    }

    @Operation(summary = "US06 - Supervisors - Get all supervisors in database", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAllSupervisors(){
        return supervisorService.findAllSupervisors();
    }

    @Operation(summary = "US06 - Supervisors - Get a supervisors by it's ID", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findSupervisorById(
            @PathVariable Long id){
        return supervisorService.findSupervisorById(id);
    }

    @Operation(summary = "US06 - Supervisors - Get a supervisors by it's name", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findByName(
            @PathVariable String name){
        return supervisorService.findSupervisorByName(name);
    }

}
