package com.dbtest.apibancaria.dominio;

public abstract class Conta {
  protected Long numero;

    public Conta(Long numero) {
        this.numero = numero;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
}
