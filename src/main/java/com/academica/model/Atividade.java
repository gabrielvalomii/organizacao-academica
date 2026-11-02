package com.academica.model;

import java.time.LocalDate;

public class Atividade extends TarefaAcademica {
    private String categoria;

    public Atividade(String titulo, LocalDate prazo, String descricao, int prioridade) {
        super(titulo, prazo, descricao, prioridade);
        this.categoria = "Atividade acadêmica";
    }

    public Atividade(String titulo, LocalDate prazo, String descricao, int prioridade, String categoria) {
        super(titulo, prazo, descricao, prioridade);
        this.categoria = categoria;
    }

    @Override
    public String getTipo() {
        return "Atividade";
    }

    @Override
    public String mostrarDetalhes() {
        return "[Atividade] " + titulo +
                " | Prazo: " + prazo +
                " | Prioridade: " + prioridade +
                " | Descrição: " + descricao +
                " | Categoria: " + categoria;
    }
}
