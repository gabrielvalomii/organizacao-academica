package com.academica.model;

import java.time.LocalDate;

public class Prova extends TarefaAcademica {
    private String conteudo;

    public Prova(String titulo, LocalDate prazo, String descricao, int prioridade, String conteudo) {
        super(titulo, prazo, descricao, prioridade);
        this.conteudo = conteudo;
    }

    @Override
    public String getTipo() {
        return "Prova";
    }

    @Override
    public String mostrarDetalhes() {
        return "[Prova] " + titulo +
                " | Prazo: " + prazo +
                " | Prioridade: " + prioridade +
                " | Conteúdo: " + conteudo +
                " | Observação: " + descricao;
    }
}
