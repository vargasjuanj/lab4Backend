package com.javainuse.controllers;

import com.javainuse.models.Instrumento;
import com.javainuse.services.InstrumentoServicio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/instrumentos")
public class InstrumentoController extends ControllerGenerico<Instrumento, InstrumentoServicio> {
 
    @GetMapping("/buscar")
    public ResponseEntity<?> search(@RequestParam("termino") String texto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.service.findByWord(texto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\" : \"" + e.getMessage() + "\"}");
        }

    }
 }


