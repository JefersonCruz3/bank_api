package com.dbtest.apibancaria.dominio;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "conta_corrente")
public class ContaCorrente extends Conta {

    private Long valor;

    public ContaCorrente(Long numero, Long valor) {
        super(numero);
        this.valor = valor;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }
}
