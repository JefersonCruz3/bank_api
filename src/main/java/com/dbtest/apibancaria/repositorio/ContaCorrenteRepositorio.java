package com.dbtest.apibancaria.repositorio;

import com.dbtest.apibancaria.dominio.ContaCorrente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaCorrenteRepositorio extends CrudRepository<ContaCorrente, Long> {

    List<ContaCorrente> findAll();

}
