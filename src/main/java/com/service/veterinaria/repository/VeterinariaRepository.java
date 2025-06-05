package com.service.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.veterinaria.model.Veterinaria;

@Repository
public interface VeterinariaRepository extends JpaRepository<Veterinaria,Long> {

}
