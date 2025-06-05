package com.service.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.veterinaria.model.Veterinaria;
import com.service.veterinaria.repository.VeterinariaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VeterinariaService {
    @Autowired
    private VeterinariaRepository veterinariaRepository;

    //Listar animales
    public List<Veterinaria> findAll(){
        return veterinariaRepository.findAll();
    }

    //Listar animal por id
    public Veterinaria findById(long id){
        return veterinariaRepository.findById(id).get();
    }

    //Guardar Animal
    public Veterinaria save(Veterinaria ubicacion){
        return veterinariaRepository.save(ubicacion);
    }

    //Eliminar animal (por id)
    public void delete(long id){
        veterinariaRepository.deleteById(id);
    }
}
