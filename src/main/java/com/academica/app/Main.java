package com.academica.app;

import com.academica.model.AgendaAcademica;
import com.academica.model.Atividade;
import com.academica.model.Disciplina;
import com.academica.model.Estudante;
import com.academica.model.Prova;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Estudante estudante = new Estudante("Ana Souza", "3º semestre");

        Disciplina poo = new Disciplina("Programação Orientada a Objetos", "POO-101", "Prof. Silva");
        Disciplina bd = new Disciplina("Banco de Dados", "BD-202", "Prof. Rocha");

        estudante.adicionarDisciplina(poo);
        estudante.adicionarDisciplina(bd);

        poo.adicionarTarefa(new Atividade("Trabalho de UML", LocalDate.now().plusDays(2), "Entregar diagrama de classes", 4));
        poo.adicionarTarefa(new Prova("Prova de polimorfismo", LocalDate.now().plusDays(5), "Revisar herança e sobreposição de métodos", 5, "Classes, objetos e sobreposição"));
        bd.adicionarTarefa(new Atividade("Modelo ER", LocalDate.now().plusDays(1), "Organizar entidades e relacionamentos", 3));
        bd.adicionarTarefa(new Prova("Quiz de SQL", LocalDate.now().plusDays(4), "Joins e consultas avançadas", 4, "Consultas SQL"));

        AgendaAcademica agenda = new AgendaAcademica(estudante);
        agenda.adicionarTarefa(new Atividade("Leitura de Java", LocalDate.now().plusDays(3), "Estudar interfaces e coleções", 2));
        agenda.adicionarTarefa(new Prova("Prova de Java básico", LocalDate.now().plusDays(7), "Revisar métodos e encapsulamento", 5, "Sintaxe Java e POO"));
        agenda.adicionarTarefa(new Atividade("Atividade prática", LocalDate.now().plusDays(1), "Implementar projeto do calendário acadêmico", 5));

        System.out.println("=== Organização Acadêmica ===\n");
        System.out.println("Disciplinas matriculadas:");
        for (Disciplina disciplina : estudante.getDisciplinas()) {
            System.out.println("- " + disciplina.getNome() + " (" + disciplina.getCodigo() + ")");
        }

        System.out.println();
        agenda.listarResumo();

        System.out.println();
        System.out.println("Próximas tarefas:");
        agenda.listarProximas(3);

        System.out.println();
        System.out.println(agenda.relatorioResumo());
    }
}
