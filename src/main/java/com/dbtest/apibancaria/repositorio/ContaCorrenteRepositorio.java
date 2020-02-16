package com.dbtest.apibancaria.repositorio;

import com.dbtest.apibancaria.dominio.ContaCorrente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContaCorrenteRepositorio extends CrudRepository<ContaCorrente, Long> {
    List<ContaCorrente> findAll();
    Optional<ContaCorrente> findById(Long id);
}
