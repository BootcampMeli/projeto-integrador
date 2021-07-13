package com.mercadolibre.projetointegrador.service.crud.impl;

import com.mercadolibre.projetointegrador.dtos.UserDTO;
import com.mercadolibre.projetointegrador.exceptions.NotFoundException;
import com.mercadolibre.projetointegrador.model.Buyer;
import com.mercadolibre.projetointegrador.repository.BuyerRepository;
import com.mercadolibre.projetointegrador.service.crud.ICRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BuyerServiceImpl implements ICRUD<Buyer> {

    private final BuyerRepository repository;

    @Override
    public Buyer create(Buyer buyer) {
        return repository.save(buyer);
    }

    @Override
    public Buyer update(Buyer buyer) {
        repository.findById(buyer.getId());
        return repository.save(buyer);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id);
        repository.deleteById(id);
    }

    @Override
    public Buyer findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Buyer with id " + id + " not found"));
    }

    @Override
    public List<Buyer> findAll() {
        return repository.findAll();
    }

    public Buyer findByName(String name){
        return repository.findByName(name);
    }


    public List<UserDTO> findAllBuyers() {
        List<Buyer> list = repository.findAll();
        List<UserDTO> result = new ArrayList<>();
        for (Buyer buyer : list){
            UserDTO userDTO = UserDTO.builder()
                    .email(buyer.getEmail())
                    .name(buyer.getName())
                    .password(buyer.getPassword())
                    .username(buyer.getUsername())
                    .build();
            result.add(userDTO);
        }
        return result;

    }

    public UserDTO findBuyerById(Long id) {
        Buyer buyer = repository.findById(id).orElseThrow(() -> new NotFoundException("Supervisor de id: "+id+" não encontrado"));
        UserDTO result = UserDTO.builder()
                .email(buyer.getEmail())
                .name(buyer.getName())
                .password(buyer.getPassword())
                .username(buyer.getUsername())
                .build();
        return result;
    }

    public UserDTO findBuyerByName(String name) {
        Buyer buyer = repository.findBuyerByName(name).orElseThrow(() -> new NotFoundException("Supervisor de nome: "+name+" não encontrado"));
        UserDTO result = UserDTO.builder()
                .email(buyer.getEmail())
                .name(buyer.getName())
                .password(buyer.getPassword())
                .username(buyer.getUsername())
                .build();
        return result;
    }
}
