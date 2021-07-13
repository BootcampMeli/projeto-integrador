package com.mercadolibre.projetointegrador.service.crud.impl;

import com.mercadolibre.projetointegrador.dtos.UserDTO;
import com.mercadolibre.projetointegrador.exceptions.ApiException;
import com.mercadolibre.projetointegrador.exceptions.NotFoundException;
import com.mercadolibre.projetointegrador.model.Employee;
import com.mercadolibre.projetointegrador.repository.EmployeeRepository;
import com.mercadolibre.projetointegrador.service.crud.ICRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements ICRUD<Employee> {

    private final EmployeeRepository employeeRepository;

    public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("Usuário "+username+" não encontrado"));
    }

    public Employee findByUsernameAndPassword(String username, String password) {
        return employeeRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new ApiException("404", "Usuario y/o contraseña incorrecto", 404));
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee de id: " + id + " não encontrado"));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findByName(String name) {
        return employeeRepository.findByUsername(name).orElseThrow();
    }

    public List<UserDTO> findAllEmployees() {
        List<Employee> list = employeeRepository.findAll();
        List<UserDTO> result = new ArrayList<>();
        for (Employee employee : list){
            UserDTO userDTO = UserDTO.builder()
                    .email(employee.getEmail())
                    .name(employee.getName())
                    .password(employee.getPassword())
                    .username(employee.getUsername())
                    .build();
            result.add(userDTO);
        }
        return result;

    }

    public UserDTO findEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Supervisor de id: "+id+" não encontrado"));
        UserDTO result = UserDTO.builder()
                .email(employee.getEmail())
                .name(employee.getName())
                .password(employee.getPassword())
                .username(employee.getUsername())
                .build();
        return result;
    }

    public UserDTO findEmployeeByName(String name) {
        Employee employee = employeeRepository.findByName(name).orElseThrow(() -> new NotFoundException("Supervisor de nome: "+name+" não encontrado"));
        UserDTO result = UserDTO.builder()
                .email(employee.getEmail())
                .name(employee.getName())
                .password(employee.getPassword())
                .username(employee.getUsername())
                .build();
        return result;
    }
}
