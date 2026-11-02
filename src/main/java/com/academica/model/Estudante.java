package com.academica.model;

import java.util.ArrayList;
import java.util.List;

public class Estudante {
    private String nome;
    private String periodo;
    private List<Disciplina> disciplinas;

    public Estudante(String nome, String periodo) {
        this.nome = nome;
        this.periodo = periodo;
        this.disciplinas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
