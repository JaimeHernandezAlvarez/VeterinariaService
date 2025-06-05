package com.service.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.veterinaria.model.Veterinaria;
import com.service.veterinaria.service.VeterinariaService;

@RestController
@RequestMapping("/api/v1/veterinarias")
public class VeterinariaController {
    @Autowired
    private VeterinariaService veterinariaService;

    @GetMapping
    public ResponseEntity<List<Veterinaria>> listar(){
        List<Veterinaria> veterinarias = veterinariaService.findAll();
        if(veterinarias.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(veterinarias);
    }

    @PostMapping
    public ResponseEntity<Veterinaria> guardar(@RequestBody Veterinaria veterinaria){
        Veterinaria nuevo = veterinariaService.save(veterinaria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Veterinaria> buscar(@PathVariable Integer id){
        try{
            Veterinaria veterinaria = veterinariaService.findById(id);
            return ResponseEntity.ok(veterinaria);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Veterinaria> actualizar(@PathVariable Integer id, @RequestBody Veterinaria veterinaria){
        try{
            Veterinaria vet = veterinariaService.findById(id);
            vet.setId(id);
            vet.setCalle(veterinaria.getCalle());
            vet.setEspecialidad(veterinaria.getEspecialidad());
            vet.setRestricciones(veterinaria.getRestricciones());
            

            veterinariaService.save(vet);
            return ResponseEntity.ok(veterinaria);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try{
            veterinariaService.delete(id);
            return ResponseEntity.noContent().build();
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
