package com.mercadolibre.projetointegrador.controller;


import com.mercadolibre.projetointegrador.dtos.UserDTO;
import com.mercadolibre.projetointegrador.model.Employee;
import com.mercadolibre.projetointegrador.service.crud.impl.EmployeeServiceImpl;
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

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(
            @Valid @RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findById(
            @PathVariable Long id){
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findByName(
            @PathVariable String name){
        return employeeService.findEmployeeByName(name);
    }

}
