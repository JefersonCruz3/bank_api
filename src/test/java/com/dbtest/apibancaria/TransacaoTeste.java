package com.dbtest.apibancaria;

import com.dbtest.apibancaria.dominio.ContaCorrente;
import com.dbtest.apibancaria.dominio.Lancamento;
import com.dbtest.apibancaria.servico.ContaCorrenteServico;
import com.dbtest.apibancaria.servico.LancamentoServico;
import com.dbtest.apibancaria.servico.TransacaoServico;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransacaoTeste {

    @Mock
    private ContaCorrenteServico contaCorrenteServico;

    @Mock
    private LancamentoServico lancamentoServico;

    @InjectMocks
    private TransacaoServico transacao;

    @Rule
    public ExpectedException
            expectedException = ExpectedException.none();
    private Lancamento lancamento;
    private ContaCorrente contaCorrenteOrigem;
    private ContaCorrente contaCorrenteDestino;

    @Before
    public void setup(){
        contaCorrenteOrigem = new ContaCorrente(1L, 10L);
        contaCorrenteDestino  =new ContaCorrente(2L, 0L);
        lancamento = new Lancamento(contaCorrenteOrigem.getNumero(), 10L, contaCorrenteDestino.getNumero());
    }

    @Test
    public void deveRetornarOkSeSubitrairSaldoNaContaOrigem(){
        when(contaCorrenteServico.findById(lancamento.getContaOrigem())).thenReturn(Optional.ofNullable(contaCorrenteOrigem));
        when(contaCorrenteServico.findById(lancamento.getContaDestino())).thenReturn(Optional.ofNullable(contaCorrenteDestino));
        when(contaCorrenteServico.save(contaCorrenteOrigem)).thenReturn(contaCorrenteOrigem);
        when(contaCorrenteServico.save(contaCorrenteDestino)).thenReturn(contaCorrenteDestino);
        when(lancamentoServico.save(lancamento)).thenReturn(lancamento);


        ContaCorrente contaCorrenteEsperada = contaCorrenteOrigem;
        long valor = 10;
        contaCorrenteEsperada.setValor(contaCorrenteEsperada.getValor() - valor);

        transacao.efetuarTransacao(lancamento);

        Assert.assertEquals(contaCorrenteEsperada.getValor(), contaCorrenteOrigem.getValor());

        Mockito.verify(contaCorrenteServico, Mockito.times(1)).findById(1L);
        Mockito.verify(contaCorrenteServico, Mockito.times(1)).findById(2L);
        Mockito.verify(contaCorrenteServico, Mockito.times(1)).save(contaCorrenteOrigem);
        Mockito.verify(contaCorrenteServico, Mockito.times(1)).save(contaCorrenteDestino);
    }
}
