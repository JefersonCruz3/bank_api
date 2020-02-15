package com.dbtest.apibancaria.controlador;

import com.dbtest.apibancaria.dominio.Lancamento;
import com.dbtest.apibancaria.servico.LancamentoServico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lancamento")
public class LancamentoControlador {
    private LancamentoServico lancamentoServico;

    public LancamentoControlador(LancamentoServico lancamentoServico) {
        this.lancamentoServico = lancamentoServico;
    }

    @PostMapping("/")
    public Lancamento save(@RequestBody Lancamento lancamento){
        return lancamentoServico.save(lancamento);
    }
}
