package com.dbtest.apibancaria.servico;

import com.dbtest.apibancaria.dominio.Lancamento;
import com.dbtest.apibancaria.repositorio.LancamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoServico {
    private LancamentoRepositorio repositorio;

    @Autowired
    public LancamentoServico(LancamentoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Lancamento save (Lancamento lancamento){
        return repositorio.save(lancamento);
    }

}
