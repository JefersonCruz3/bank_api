package com.dbtest.apibancaria.repositorio;

import com.dbtest.apibancaria.dominio.Lancamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LancamentoRepositorio extends CrudRepository<Lancamento, Long> {
    List<Lancamento> findAll();
}
