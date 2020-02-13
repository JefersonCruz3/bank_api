package com.dbtest.apibancaria.servico;

import com.dbtest.apibancaria.dominio.ContaCorrente;
import com.dbtest.apibancaria.repositorio.ContaCorrenteRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ContaCorrenteServico {
    private ContaCorrenteRepositorio repositorio;

    public ContaCorrenteServico(ContaCorrenteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public ContaCorrente save (ContaCorrente contaCorrente){
        return repositorio.save(contaCorrente);
    }

}
