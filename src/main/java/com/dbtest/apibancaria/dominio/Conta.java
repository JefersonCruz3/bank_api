package com.dbtest.apibancaria.dominio;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Conta {
    @Id
    @Column(name = "numero", updatable = false, nullable = false)
    protected Long numero;

    public Conta(Long numero) {
        this.numero = numero;
    }

    public Conta(){

    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
}
