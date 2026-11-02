package com.academica.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AgendaAcademica {
    private Estudante estudante;
    private List<TarefaAcademica> tarefas;

    public AgendaAcademica(Estudante estudante) {
        this.estudante = estudante;
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(TarefaAcademica tarefa) {
        tarefas.add(tarefa);
    }

    public void listarResumo() {
        System.out.println("Agenda de " + estudante.getNome() + "\n");

        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        for (TarefaAcademica tarefa : tarefas) {
            System.out.println(tarefa.mostrarDetalhes());
        }
    }

    public void listarProximas(int quantidade) {
        List<TarefaAcademica> ordenadas = new ArrayList<>(tarefas);
        ordenadas.sort(Comparator.comparing(TarefaAcademica::getPrazo));

        int limite = Math.min(quantidade, ordenadas.size());

        for (int i = 0; i < limite; i++) {
            TarefaAcademica tarefa = ordenadas.get(i);
            System.out.println((i + 1) + ". " + tarefa.getTipo() + " - " + tarefa.getTitulo() + " | Prazo: " + tarefa.getPrazo());
        }
    }

    public String relatorioResumo() {
        long provas = tarefas.stream().filter(t -> t.getTipo().equals("Prova")).count();
        long atividades = tarefas.stream().filter(t -> t.getTipo().equals("Atividade")).count();
        long urgentes = tarefas.stream().filter(t -> t.diasRestantes() <= 3).count();

        return "Resumo da agenda: " +
                "\n- Estudante: " + estudante.getNome() +
                "\n- Período: " + estudante.getPeriodo() +
                "\n- Total de tarefas: " + tarefas.size() +
                "\n- Atividades: " + atividades +
                "\n- Provas: " + provas +
                "\n- Tarefas urgentes (até 3 dias): " + urgentes;
    }
}
