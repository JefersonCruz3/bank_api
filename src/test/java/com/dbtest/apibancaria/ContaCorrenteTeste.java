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

import java.util.Collections;
import java.util.List;
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

    @Test
    public void deveLancarExceptionSeTentarSalvarContaCorrenteSemNumero(){
        ContaCorrente contaCorrente = new ContaCorrente(null, 0L);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Conta corrente deve conter um numero");

        contaCorrenteServico.save(contaCorrente);

        Mockito.verifyNoInteractions(repositorio);
    }

    @Test
    public void deveLancarExceptionSeTentarSalvarContaCorrenteComSaldoNulo(){
        ContaCorrente contaCorrente = new ContaCorrente(0L, null);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Conta corrente não pode salvar um saldo nulo");

        contaCorrenteServico.save(contaCorrente);

        Mockito.verifyNoInteractions(repositorio);
    }

    @Test
    public void deveLancarExceptionSeTentarSalvarContaCorrenteComNumeroJaExistente(){
        when(repositorio.findAll()).thenReturn(Collections.singletonList(contaCorrenteEsperada));

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Conta corrente já existe na base de dados");

        contaCorrenteServico.save(contaCorrenteEsperada);

        Mockito.verifyNoInteractions(repositorio);
    }

    @Test
    public void deveRetornarOkSeBuscarTodasContasCorrentes(){
        when(repositorio.findAll()).thenReturn(Collections.singletonList(contaCorrenteEsperada));

        List<ContaCorrente> contaCorrenteContainer = contaCorrenteServico.findAll();

        Mockito.verify(repositorio, Mockito.times(1)).findAll();
    }
}
