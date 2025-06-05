package com.service.veterinaria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="veterinaria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veterinaria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veterinaria_seq")
    @SequenceGenerator(name = "veterinaria_seq",sequenceName = "VETERINARIA_SEQ",allocationSize = 1)
    @Column(name = "id_veterinaria")
    private Integer id;

    @Column(name = "calle",length = 50)
    private String calle;

    @Column(name = "especialidad",length = 15)
    private String especialidad;

    @Column(name = "restricciones",length = 200)
    private String restricciones;
}
