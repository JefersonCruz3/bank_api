package com.dbtest.apibancaria.controlador;

import com.dbtest.apibancaria.dominio.ContaCorrente;
import com.dbtest.apibancaria.servico.ContaCorrenteServico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta_corrente")
public class ContaCorrenteControlador {
    private ContaCorrenteServico contaCorrenteServico;

    public ContaCorrenteControlador(ContaCorrenteServico contaCorrenteServico) {
        this.contaCorrenteServico = contaCorrenteServico;
    }

    @PostMapping("/")
    public ContaCorrente save(@RequestBody ContaCorrente contaCorrente){
        return contaCorrenteServico.save(contaCorrente);
    }

}
