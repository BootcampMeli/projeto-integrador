package com.mercadolibre.projetointegrador.service.crud.impl;

import com.mercadolibre.projetointegrador.exceptions.NotFoundException;
import com.mercadolibre.projetointegrador.model.Supervisor;
import com.mercadolibre.projetointegrador.repository.SupervisorRepository;
import com.mercadolibre.projetointegrador.service.crud.ICRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SupervisorServiceImpl implements ICRUD<Supervisor> {

    private final SupervisorRepository supervisorRepository;

    @Override
    public Supervisor create(Supervisor supervisor) {
        return null;
    }

    @Override
    public Supervisor update(Supervisor supervisor) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Supervisor findById(Long id) {
        return supervisorRepository.findById(id).orElseThrow(() -> new NotFoundException("Supervisor de id: "+id+" não encontrado"));
    }

    @Override
    public List<Supervisor> findAll() {
        return null;
    }
}
