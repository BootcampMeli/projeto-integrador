package com.mercadolibre.projetointegrador.service.crud.impl;

import com.mercadolibre.projetointegrador.dtos.UserDTO;
import com.mercadolibre.projetointegrador.exceptions.NotFoundException;
import com.mercadolibre.projetointegrador.model.Supervisor;
import com.mercadolibre.projetointegrador.repository.SupervisorRepository;
import com.mercadolibre.projetointegrador.service.crud.ICRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SupervisorServiceImpl implements ICRUD<Supervisor> {

    private final SupervisorRepository supervisorRepository;

    @Override
    public Supervisor create(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    @Override
    public Supervisor update(Supervisor supervisor) {
        supervisorRepository.findById(supervisor.getId());
        return supervisorRepository.save(supervisor);
    }

    @Override
    public void delete(Long id) {
        supervisorRepository.findById(id);
        supervisorRepository.deleteById(id);
    }

    @Override
    public Supervisor findById(Long id) {
        return supervisorRepository.findById(id).orElseThrow(() -> new NotFoundException("Supervisor de id: "+id+" não encontrado"));
    }

    @Override
    public List<Supervisor> findAll() {
        return supervisorRepository.findAll();
    }


    public List<UserDTO> findAllSupervisors() {
        List<Supervisor> list = supervisorRepository.findAll();
        List<UserDTO> result = new ArrayList<>();
        for (Supervisor supervisor : list){
            UserDTO userDTO = UserDTO.builder()
                    .email(supervisor.getEmail())
                    .name(supervisor.getName())
                    .password(supervisor.getPassword())
                    .username(supervisor.getUsername())
                    .build();
            result.add(userDTO);
        }
        return result;

    }

    public UserDTO findSupervisorById(Long id) {
        Supervisor supervisor = supervisorRepository.findById(id).orElseThrow(() -> new NotFoundException("Supervisor de id: "+id+" não encontrado"));
        UserDTO result = UserDTO.builder()
                    .email(supervisor.getEmail())
                    .name(supervisor.getName())
                    .password(supervisor.getPassword())
                    .username(supervisor.getUsername())
                    .build();
        return result;
    }

    public Supervisor findByName(String name) {
        return supervisorRepository.findSupervisorByUsername(name).orElseThrow(() -> new NotFoundException("Supervisor de nome: "+name+" não encontrado"));
    }

    public UserDTO findSupervisorByName(String name) {
        Supervisor supervisor = supervisorRepository.findByName(name).orElseThrow(() -> new NotFoundException("Supervisor de nome: "+name+" não encontrado"));
        UserDTO result = UserDTO.builder()
                .email(supervisor.getEmail())
                .name(supervisor.getName())
                .password(supervisor.getPassword())
                .username(supervisor.getUsername())
                .build();
        return result;
    }
}
