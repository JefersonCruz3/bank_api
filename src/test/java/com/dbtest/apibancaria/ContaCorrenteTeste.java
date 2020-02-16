package com.dbtest.apibancaria;

import com.dbtest.apibancaria.dominio.ContaCorrente;
import com.dbtest.apibancaria.repositorio.ContaCorrenteRepositorio;
import com.dbtest.apibancaria.servico.ContaCorrenteServico;
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
public class ContaCorrenteTeste {

    @Mock
    private ContaCorrenteRepositorio repositorio;

    @InjectMocks
    private ContaCorrenteServico contaCorrenteServico;

    @Rule
    public ExpectedException
            expectedException = ExpectedException.none();
    private ContaCorrente contaCorrenteEsperada;

    @Before
    public  void setup(){
        contaCorrenteEsperada = new ContaCorrente(1L, 0L);
    }

    @Test
    public void deveRetornarOkSeAdicionarContaCorrenteValida(){
        when(repositorio.save(contaCorrenteEsperada)).thenReturn(contaCorrenteEsperada);

        ContaCorrente contaCorrente = contaCorrenteServico.save(contaCorrenteEsperada);

        Assert.assertEquals(contaCorrenteEsperada.getNumero(), contaCorrente.getNumero());

        Mockito.verify(repositorio, Mockito.times(1)).save(contaCorrenteEsperada);
    }

    @Test
    public void deveRetornarOkSeBuscarContaCorrenteRequerida(){
        when(repositorio.findById(1L)).thenReturn(Optional.ofNullable(contaCorrenteEsperada));

        Optional<ContaCorrente> contaCorrenteContainer = contaCorrenteServico.findById(1L);

        contaCorrenteContainer.ifPresent(contaCorrente -> Assert.assertEquals(contaCorrenteEsperada.getNumero(), contaCorrente.getNumero()));

        Mockito.verify(repositorio, Mockito.times(1)).findById(1L);
    }
}
