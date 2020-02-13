package com.dbtest.apibancaria.dominio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conta_corrente")
public class ContaCorrente extends Conta {

    private Long valor;

    @JsonCreator
    public ContaCorrente(@JsonProperty("numero")Long numero, @JsonProperty("valor")Long valor) {
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
