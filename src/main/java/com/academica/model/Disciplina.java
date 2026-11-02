package com.academica.model;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private String codigo;
    private String professor;
    private List<TarefaAcademica> tarefas;

    public Disciplina(String nome, String codigo, String professor) {
        this.nome = nome;
        this.codigo = codigo;
        this.professor = professor;
        this.tarefas = new ArrayList<>();
    }

    public Disciplina(String nome, String codigo) {
        this(nome, codigo, "Professor não informado");
    }

    public void adicionarTarefa(TarefaAcademica tarefa) {
        tarefas.add(tarefa);
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getProfessor() {
        return professor;
    }

    public List<TarefaAcademica> getTarefas() {
        return tarefas;
    }
}
