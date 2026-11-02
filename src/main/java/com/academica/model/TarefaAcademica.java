package com.academica.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class TarefaAcademica {
    protected String titulo;
    protected LocalDate prazo;
    protected String descricao;
    protected int prioridade;

    public TarefaAcademica(String titulo, LocalDate prazo, String descricao, int prioridade) {
        this.titulo = titulo;
        this.prazo = prazo;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public abstract String getTipo();

    public abstract String mostrarDetalhes();

    public long diasRestantes() {
        return ChronoUnit.DAYS.between(LocalDate.now(), prazo);
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public String getDescricao() {
        return descricao;
    }
}
