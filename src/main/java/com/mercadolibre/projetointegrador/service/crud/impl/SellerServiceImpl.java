package com.mercadolibre.projetointegrador.service.crud.impl;

import com.mercadolibre.projetointegrador.dtos.UserDTO;
import com.mercadolibre.projetointegrador.exceptions.NotFoundException;
import com.mercadolibre.projetointegrador.model.Seller;
import com.mercadolibre.projetointegrador.repository.SellerRepository;
import com.mercadolibre.projetointegrador.service.crud.ICRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SellerServiceImpl implements ICRUD<Seller> {

    private final SellerRepository sellerRepository;

    @Override
    public Seller create(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller update(Seller seller) {
        sellerRepository.findById(seller.getId());
        return sellerRepository.save(seller);
    }

    @Override
    public void delete(Long id) {
        sellerRepository.findById(id);
        sellerRepository.deleteById(id);
    }

    @Override
    public Seller findById(Long id) {
        return sellerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Seller de id: " + id + " não encontrado"));
    }

    @Override
    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }

    public Seller findByName(String name) {
        return sellerRepository.findSellerByName(name);
    }

    public List<UserDTO> findAllSellers() {
        List<Seller> list = sellerRepository.findAll();
        List<UserDTO> result = new ArrayList<>();
        for (Seller seller : list){
            UserDTO userDTO = UserDTO.builder()
                    .email(seller.getEmail())
                    .name(seller.getName())
                    .password(seller.getPassword())
                    .username(seller.getUsername())
                    .build();
            result.add(userDTO);
        }
        return result;

    }

    public UserDTO findSellerById(Long id) {
        Seller seller = sellerRepository.findById(id).orElseThrow(() -> new NotFoundException("Supervisor de id: "+id+" não encontrado"));
        UserDTO result = UserDTO.builder()
                .email(seller.getEmail())
                .name(seller.getName())
                .password(seller.getPassword())
                .username(seller.getUsername())
                .build();
        return result;
    }

    public UserDTO findSellerByName(String name) {
        Seller seller = sellerRepository.findByName(name).orElseThrow(() -> new NotFoundException("Seler de nome: "+name+" não encontrado"));
        UserDTO result = UserDTO.builder()
                .email(seller.getEmail())
                .name(seller.getName())
                .password(seller.getPassword())
                .username(seller.getUsername())
                .build();
        return result;
    }
}
