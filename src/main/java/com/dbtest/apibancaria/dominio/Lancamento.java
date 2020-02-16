package com.dbtest.apibancaria.dominio;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name ="lancamento")
@SequenceGenerator(name="lancamento_seq", initialValue=1, allocationSize=1)
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lancamento_seq")

    @Column(name = "data_lancamento")
    private LocalDateTime data;

    private long id;
    private long contaOrigem;
    private long valor;
    private long contaDestino;

    @JsonCreator
    public Lancamento(@JsonProperty("contaOrigem") long contaOrigem,
                      @JsonProperty("valor") long valor,
                      @JsonProperty("contaDestino") long contaDestino) {
        this.contaOrigem = contaOrigem;
        this.valor = valor;
        this.contaDestino = contaDestino;
    }

    @JsonCreator
    public Lancamento(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(long contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public long getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(long contaDestino) {
        this.contaDestino = contaDestino;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
