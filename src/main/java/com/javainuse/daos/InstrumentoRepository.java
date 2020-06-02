package com.javainuse.daos;

import java.util.List;

import com.javainuse.models.Instrumento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface InstrumentoRepository extends JpaRepository<Instrumento, Long>{
  
    @Query(value = "SELECT * FROM instrumento WHERE instrumento LIKE %?1% OR descripcion LIKE %?1% OR marca LIKE %?1% OR modelo LIKE %?1% OR costo_envio LIKE %?1% OR precio LIKE %?1%", nativeQuery = true)
    public Instrumento getByWords(String texto);
}
