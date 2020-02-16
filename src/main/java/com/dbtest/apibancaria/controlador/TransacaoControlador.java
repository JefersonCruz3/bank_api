package com.dbtest.apibancaria.controlador;

import com.dbtest.apibancaria.dominio.Lancamento;
import com.dbtest.apibancaria.servico.TransacaoServico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoControlador {
    private TransacaoServico transacaoServico;

    public TransacaoControlador(TransacaoServico transacaoServico) {
        this.transacaoServico = transacaoServico;
    }

    @PostMapping("/")
    public Lancamento efetuarTranscao(@RequestBody Lancamento lancamento){
        return transacaoServico.efetuarTransacao(lancamento);
    }
}
