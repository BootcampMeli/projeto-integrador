package com.mercadolibre.projetointegrador.controller;


import com.mercadolibre.projetointegrador.dtos.UserDTO;
import com.mercadolibre.projetointegrador.model.Supervisor;
import com.mercadolibre.projetointegrador.service.crud.impl.SupervisorServiceImpl;
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

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Supervisor create(
            //TODO validate supervisor or admin
            @Valid @RequestBody Supervisor supervisor){
        return supervisorService.create(supervisor);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAllSupervisors(){
        return supervisorService.findAllSupervisors();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findSupervisorById(
            @PathVariable Long id){
        return supervisorService.findSupervisorById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findByName(
            @PathVariable String name){
        return supervisorService.findSupervisorByName(name);
    }

}
