package com.dbtest.apibancaria.dominio;

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
