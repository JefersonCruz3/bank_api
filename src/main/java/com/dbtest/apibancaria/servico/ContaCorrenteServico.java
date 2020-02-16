package com.dbtest.apibancaria.servico;

import com.dbtest.apibancaria.dominio.ContaCorrente;
import com.dbtest.apibancaria.repositorio.ContaCorrenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaCorrenteServico {
    private ContaCorrenteRepositorio contaCorrenteRepositorio;

    @Autowired
    public ContaCorrenteServico(ContaCorrenteRepositorio contaCorrenteRepositorio) {
        this.contaCorrenteRepositorio = contaCorrenteRepositorio;
    }

    public ContaCorrente save (ContaCorrente contaCorrente){
        contaCorrenteValidacao(contaCorrente);
        return contaCorrenteRepositorio.save(contaCorrente);
    }

    public ContaCorrente atualizar (ContaCorrente contaCorrente){
        return contaCorrenteRepositorio.save(contaCorrente);
    }

    public Optional<ContaCorrente> findById(long contaCorrente){
        return contaCorrenteRepositorio.findById(contaCorrente);
    }

    public List<ContaCorrente> findAll(){
        return contaCorrenteRepositorio.findAll();
    }

    public void contaCorrenteValidacao(ContaCorrente contaCorrente){
        List<Long> listaContaCorrentesNumero = this.findAll().stream()
                                                            .map(ContaCorrente::getNumero)
                                                            .collect(Collectors.toList());

        if(StringUtils.isEmpty(contaCorrente.getNumero())){
            throw new IllegalArgumentException("Conta corrente deve conter um numero");
        }

        if(StringUtils.isEmpty(contaCorrente.getValor())){
            throw new IllegalArgumentException("Conta corrente não pode salvar um saldo nulo");
        }

        if (listaContaCorrentesNumero.contains(contaCorrente.getNumero())) {
                throw new IllegalArgumentException("Conta corrente já existe na base de dados");
        }

    }

}
