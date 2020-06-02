package com.javainuse.services;

import java.util.List;

import com.javainuse.daos.InstrumentoRepository;
import com.javainuse.models.ImageModel;
import com.javainuse.models.Instrumento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentoServicio extends ServicioGenerico<Instrumento, InstrumentoRepository> {

    @Autowired
    private ImageModelServicio imgServicio;
    //Relaciona la imagen elegida en el input del formulario con el instrumento a través de un nombre unico de imagen, la relación se podria hacer desde el front y omitir este paso conviertiendo el archivo en bytes para que concuerde con el modelo de la imagen (atributo pycByte)
    public Instrumento save(Instrumento instrumento) throws Exception {

        try {
            ImageModel img= imgServicio.findByName(instrumento.getNombreImagen());
            
            instrumento.setImagen(img);
    
          return  this.repository.save(instrumento);
    
        } catch (Exception e) {
    
            throw new Exception(e.getMessage());
        }
    }
    public Instrumento findByWord(String texto) throws  Exception{
        try {
            return this.repository.getByWords(texto);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}