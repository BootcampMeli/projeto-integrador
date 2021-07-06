package com.mercadolibre.projetointegrador.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sectionCode;

    @OneToMany(mappedBy = "section")
    private List<InboundOrder> inboundOrders;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    private double minTemperature;
    private double maxTemperature;

}