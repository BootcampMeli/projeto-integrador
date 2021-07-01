package com.mercadolibre.dambetan01.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Seller extends User{

    @OneToMany(mappedBy = "seller")
    private List<Product> products = new ArrayList<>();
}
