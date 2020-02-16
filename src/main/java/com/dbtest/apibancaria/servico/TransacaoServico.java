package com.dbtest.apibancaria.servico;

import com.dbtest.apibancaria.dominio.ContaCorrente;
import com.dbtest.apibancaria.dominio.Lancamento;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransacaoServico {
    private ContaCorrenteServico contaCorrenteServico;
    private LancamentoServico lancamentoServico;

    public TransacaoServico(ContaCorrenteServico contaCorrenteServico, LancamentoServico lancamentoServico) {
        this.contaCorrenteServico = contaCorrenteServico;
        this.lancamentoServico = lancamentoServico;
    }

    public Lancamento efetuarTransacao(Lancamento lancamento){
        Optional<ContaCorrente> contaOrigemContainer = contaCorrenteServico.findById(lancamento.getContaOrigem());
        Optional<ContaCorrente> contaDestinoContainer = contaCorrenteServico.findById(lancamento.getContaDestino());

        if(contaOrigemContainer.isPresent() && contaDestinoContainer.isPresent()){
            ContaCorrente contaOrigem = contaOrigemContainer.get();
            ContaCorrente contaDestino = contaDestinoContainer.get();

            contaOrigem.setValor(contaOrigem.getValor() - lancamento.getValor());
            contaDestino.setValor(contaDestino.getValor() + lancamento.getValor());

            contaCorrenteServico.save(contaOrigem);
            contaCorrenteServico.save(contaDestino);
        }

        return lancamentoServico.save(lancamento);
    }
}
