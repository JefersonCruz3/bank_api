package com.dbtest.apibancaria.servico;

import org.springframework.util.StringUtils;
import com.dbtest.apibancaria.dominio.ContaCorrente;
import com.dbtest.apibancaria.repositorio.ContaCorrenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<ContaCorrente> findById(long contaCorrente){
        return contaCorrenteRepositorio.findById(contaCorrente);
    }

    public List<ContaCorrente> findAll(){
        return contaCorrenteRepositorio.findAll();
    }

    public void contaCorrenteValidacao(ContaCorrente contaCorrente){

        if(StringUtils.isEmpty(contaCorrente.getNumero())){
            throw new IllegalArgumentException("Conta corrente deve conter um numero");
        }

        if(StringUtils.isEmpty(contaCorrente.getValor())){
            throw new IllegalArgumentException("Conta corrente não pode salvar um saldo nulo");
        }

        this.findAll().forEach(registro -> {
            if (registro.getNumero().equals(contaCorrente.getNumero())){
                throw new IllegalArgumentException("Conta corrente já existe na base de dados");
            }
        });
    }

}
