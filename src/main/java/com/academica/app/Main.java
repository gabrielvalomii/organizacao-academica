package com.academica.app;

import java.time.LocalDate;
import java.util.Scanner;

import com.academica.model.AgendaAcademica;
import com.academica.model.Atividade;
import com.academica.model.Disciplina;
import com.academica.model.Estudante;
import com.academica.model.Prova;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== Estudante =====
        System.out.println("=== Dados do estudante ===");
        System.out.print("Nome do estudante: ");
        String nomeEstudante = sc.nextLine();
        System.out.print("Período (ex: 3º semestre): ");
        String periodo = sc.nextLine();

        Estudante estudante = new Estudante(nomeEstudante, periodo);
        AgendaAcademica agenda = new AgendaAcademica(estudante);

        // ===== Disciplina 1 =====
        System.out.println("\n=== Disciplina 1 ===");
        System.out.print("Nome: ");
        String nomeD1 = sc.nextLine();
        System.out.print("Código: ");
        String codigoD1 = sc.nextLine();
        System.out.print("Professor: ");
        String professorD1 = sc.nextLine();

        Disciplina poo = new Disciplina(nomeD1, codigoD1, professorD1);
        estudante.adicionarDisciplina(poo);

        // Atividades da disciplina 1 (repete enquanto o usuário quiser)
        boolean maisAtividades = true;
        int numAtividade = 1;
        while (maisAtividades) {
            System.out.println("-- Atividade " + numAtividade + " --");
            System.out.print("Título: ");
            String titulo = sc.nextLine();
            System.out.print("Prazo (AAAA-MM-DD): ");
            LocalDate prazo = LocalDate.parse(sc.nextLine());
            System.out.print("Descrição: ");
            String descricao = sc.nextLine();
            System.out.print("Prioridade (1 a 5): ");
            int prioridade = Integer.parseInt(sc.nextLine());

            Atividade atividade = new Atividade(titulo, prazo, descricao, prioridade);
            poo.adicionarTarefa(atividade);
            agenda.adicionarTarefa(atividade);
            numAtividade++;

            System.out.print("Quer adicionar mais alguma atividade? [s/n]: ");
            String resposta = sc.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                maisAtividades = true;
            } else if (resposta.equalsIgnoreCase("n")) {
                maisAtividades = false;
            } else {
                System.out.println("Resposta inválida, vou considerar 'n'.");
                maisAtividades = false;
            }
        }

        // Prova da disciplina 1 (só uma)
        System.out.println("-- Prova --");
        System.out.print("Título: ");
        String tituloProva = sc.nextLine();
        System.out.print("Prazo (AAAA-MM-DD): ");
        LocalDate prazoProva = LocalDate.parse(sc.nextLine());
        System.out.print("Descrição: ");
        String descricaoProva = sc.nextLine();
        System.out.print("Prioridade (1 a 5): ");
        int prioridadeProva = Integer.parseInt(sc.nextLine());
        System.out.print("Conteúdo: ");
        String conteudoProva = sc.nextLine();

        Prova prova1 = new Prova(tituloProva, prazoProva, descricaoProva, prioridadeProva, conteudoProva);
        poo.adicionarTarefa(prova1);
        agenda.adicionarTarefa(prova1);

        // ===== Disciplina 2 =====
        System.out.println("\n=== Disciplina 2 ===");
        System.out.print("Nome: ");
        String nomeD2 = sc.nextLine();
        System.out.print("Código: ");
        String codigoD2 = sc.nextLine();
        System.out.print("Professor: ");
        String professorD2 = sc.nextLine();

        Disciplina bd = new Disciplina(nomeD2, codigoD2, professorD2);
        estudante.adicionarDisciplina(bd);

        // Atividades da disciplina 2 (repete enquanto o usuário quiser)
        maisAtividades = true;
        numAtividade = 1;
        while (maisAtividades) {
            System.out.println("-- Atividade " + numAtividade + " --");
            System.out.print("Título: ");
            String titulo = sc.nextLine();
            System.out.print("Prazo (AAAA-MM-DD): ");
            LocalDate prazo = LocalDate.parse(sc.nextLine());
            System.out.print("Descrição: ");
            String descricao = sc.nextLine();
            System.out.print("Prioridade (1 a 5): ");
            int prioridade = Integer.parseInt(sc.nextLine());

            Atividade atividade = new Atividade(titulo, prazo, descricao, prioridade);
            bd.adicionarTarefa(atividade);
            agenda.adicionarTarefa(atividade);
            numAtividade++;

            System.out.print("Quer adicionar mais alguma atividade? [s/n]: ");
            String resposta = sc.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                maisAtividades = true;
            } else if (resposta.equalsIgnoreCase("n")) {
                maisAtividades = false;
            } else {
                System.out.println("Resposta inválida, vou considerar 'n'.");
                maisAtividades = false;
            }
        }

        // Prova da disciplina 2 (só uma)
        System.out.println("-- Prova --");
        System.out.print("Título: ");
        tituloProva = sc.nextLine();
        System.out.print("Prazo (AAAA-MM-DD): ");
        prazoProva = LocalDate.parse(sc.nextLine());
        System.out.print("Descrição: ");
        descricaoProva = sc.nextLine();
        System.out.print("Prioridade (1 a 5): ");
        prioridadeProva = Integer.parseInt(sc.nextLine());
        System.out.print("Conteúdo: ");
        conteudoProva = sc.nextLine();

        Prova prova2 = new Prova(tituloProva, prazoProva, descricaoProva, prioridadeProva, conteudoProva);
        bd.adicionarTarefa(prova2);
        agenda.adicionarTarefa(prova2);

        // ===== Relatório =====
        System.out.println("\n=== Organização Acadêmica ===\n");
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

        sc.close();
    }
}
