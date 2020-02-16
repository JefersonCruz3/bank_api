package com.dbtest.apibancaria.servico;

import com.dbtest.apibancaria.dominio.ContaCorrente;
import com.dbtest.apibancaria.dominio.Lancamento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        this.validarTransacao(lancamento);
        return lancamentoServico.save(lancamento);
    }

    private void validarTransacao(Lancamento lancamento){
        List<ContaCorrente> listaContaCorrente = contaCorrenteServico.findAll();
        List<Long> listaContaCorrenteNumero = listaContaCorrente.stream()
                                                    .map(ContaCorrente::getNumero)
                                                    .collect(Collectors.toList());

        if (!(listaContaCorrenteNumero.contains(lancamento.getContaOrigem())
                || listaContaCorrenteNumero.contains(lancamento.getContaDestino()))){
            throw new IllegalArgumentException("Conta corrente origem e destino não encontrada");
        }

        if (!listaContaCorrenteNumero.contains(lancamento.getContaOrigem())){
            throw new IllegalArgumentException("Conta corrente origem não encontrada");
        }

        if (!listaContaCorrenteNumero.contains(lancamento.getContaDestino())){
            throw new IllegalArgumentException("Conta corrente destino não encontrada");
        }
    }
}
