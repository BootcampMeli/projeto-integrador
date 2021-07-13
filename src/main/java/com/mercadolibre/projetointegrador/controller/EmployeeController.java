package com.mercadolibre.projetointegrador.controller;


import com.mercadolibre.projetointegrador.dtos.UserDTO;
import com.mercadolibre.projetointegrador.model.Buyer;
import com.mercadolibre.projetointegrador.model.Employee;
import com.mercadolibre.projetointegrador.service.crud.impl.EmployeeServiceImpl;
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
@RequestMapping("/api/v1/fresh-products/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @Operation(summary = "US06 - Employees - Create new employees", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(
            @Valid @RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @Operation(summary = "US06 - Employees - Get all employees in database", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @Operation(summary = "US06 - Employees - Get all employee by it's ID", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findById(
            @PathVariable Long id){
        return employeeService.findEmployeeById(id);
    }

    @Operation(summary = "US06 - Employees - Get all employee by it's name", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Buyer.class)))
    })
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findByName(
            @PathVariable String name){
        return employeeService.findEmployeeByName(name);
    }

}
