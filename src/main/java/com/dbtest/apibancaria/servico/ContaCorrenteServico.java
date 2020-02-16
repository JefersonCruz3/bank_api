package com.dbtest.apibancaria.servico;

import com.dbtest.apibancaria.dominio.ContaCorrente;
import com.dbtest.apibancaria.repositorio.ContaCorrenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaCorrenteServico {
    private ContaCorrenteRepositorio contaCorrenteRepositorio;

    @Autowired
    public ContaCorrenteServico(ContaCorrenteRepositorio contaCorrenteRepositorio) {
        this.contaCorrenteRepositorio = contaCorrenteRepositorio;
    }

    public ContaCorrente save (ContaCorrente contaCorrente){
        return contaCorrenteRepositorio.save(contaCorrente);
    }

    public Optional<ContaCorrente> findById(long contaCorrente){
        return contaCorrenteRepositorio.findById(contaCorrente);
    }

}
