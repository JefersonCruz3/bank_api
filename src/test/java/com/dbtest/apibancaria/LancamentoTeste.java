package com.dbtest.apibancaria;

import com.dbtest.apibancaria.dominio.Lancamento;
import com.dbtest.apibancaria.repositorio.LancamentoRepositorio;
import com.dbtest.apibancaria.servico.LancamentoServico;
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

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LancamentoTeste {
    @Mock
    private LancamentoRepositorio repositorio;

    @InjectMocks
    private LancamentoServico lancamentoServico;

    @Rule
    public ExpectedException
            expectedException = ExpectedException.none();
    public Lancamento lancamentoEsperado;

    @Before
    public void setup(){
        lancamentoEsperado = new Lancamento(1L, 10L, 2L);
    }

    @Test
    public void deveRetornarOkSeAdicionarLancamentoValido(){
        when(repositorio.save(lancamentoEsperado)).thenReturn(lancamentoEsperado);

        Lancamento lancamento = lancamentoServico.save(lancamentoEsperado);

        Assert.assertEquals(lancamentoEsperado.getId(), lancamento.getId());

        Mockito.verify(repositorio, Mockito.times(1)).save(lancamentoEsperado);
    }
}
