package br.com.myindaia.main;

import br.com.myindaia.model.Aluno;
import br.com.myindaia.model.Turma;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private Scanner l;
    private boolean execute;
    private List<Aluno> aluno;
    private List<Turma> turma;
    private Scanner scannerNota = new Scanner(System.in);
    

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        l = new Scanner(System.in);
        execute = true;
        turma = new ArrayList<Turma>();
        aluno = new ArrayList<Aluno>();
        System.out.println("***************************************BEM VINDO AO CADASTRO DE TURMAS E ALUNOS");
        System.out.println();

        while (execute) {
            String opcao = menu();
            
            if (opcao.equalsIgnoreCase("1")) {
                cadastrarT();
            } else if (opcao.equalsIgnoreCase("2")) {
                cadastrarA();
            } else if (opcao.equalsIgnoreCase("3")) {
                listarCadastrosT();
            } else if (opcao.equalsIgnoreCase("4")) {
                listarCadastrosA();
            } else if (opcao.equalsIgnoreCase("5")) {
                execute = false;
            } else {
                System.out.println("\nOpção Inválida!!! \n");
            }
        }
    }

    private String menu() {
        System.out.println("Selecione a opção:");
        System.out.println();
        System.out.println("1 - Cadastrar Turma");
        System.out.println("2 - Cadastrar Aluno");
        System.out.println("3 - Listar Turmas");
        System.out.println("4 - Listar Alunos");
        System.out.println("5 - Sair");
        return l.nextLine();
    }

    private void cadastrarT() {
        boolean cadastrando = true;

        while (cadastrando) {
            System.out.println("Cadastro de Turma");
            Turma d = new Turma();
            d.setNome(textInput("Nome:"));

            String cadastrar = textInput("Cadastar a turma acima (S/N) ?");
            if (cadastrar.equalsIgnoreCase("s")) {
                System.out.println("Turma adicionada !!!");
                turma.add(d);
            } else if (cadastrar.equalsIgnoreCase("n")){
                System.out.println("Turma ignorada !!!");
            } else {
                System.out.println("\nOpção inválida, cadastro ignorado, favor digitar denovo !!! \n");
            }

            String continua = textInput("Deseja cadastrar outra turma (S/N) ?");
            if (continua.equalsIgnoreCase("N")) {
                cadastrando = false;
            } else if (continua.equalsIgnoreCase("s")){
            } else {
                System.out.println("\nOpção inválida !!! \n");
                cadastrando = false;
            }
        }
    }
    
    private void cadastrarA() {
        boolean cadastrando = true;

        while (cadastrando) {
            System.out.println("Cadastro de Aluno");
            Aluno d = new Aluno();
            d.setNome(textInput("Nome:"));
            System.out.println("Nota Um:");
            d.notas.add(scannerNota.nextInt());
            System.out.println("Nota Dois:");
            d.notas.add(scannerNota.nextInt());
            System.out.println("Nota Três:");
            d.notas.add(scannerNota.nextInt());

            String cadastrar = textInput("Deseja cadastrar o aluno acima (S/N) ?");
            if (cadastrar.equalsIgnoreCase("s")) {
                System.out.println("Aluno adicionado !!!");
                aluno.add(d);
            } else if (cadastrar.equalsIgnoreCase("n")){
                System.out.println("Aluno ignorado !!!");
            } else {
                System.out.println("\nOpção inválida, cadastro ignorado, favor digitar denovo !!! \n");
            }

            String continua = textInput("Adicionar um novo aluno (S/N) ?");
            if (continua.equalsIgnoreCase("N")) {
                cadastrando = false;
            } else if (continua.equalsIgnoreCase("s")){
            } else {
                System.out.println("\nOpção inválida !!! \n");
                cadastrando = false;
            }
        }
    }

    private void listarCadastrosT() {
        if (turma.size() == 0) {
            System.out.println("\nNão existem cadastros !!!\n");
        } else {
            System.out.println("\nLista de Cadastros\n");
            for (int i = 0; i < turma.size(); i++) {
                Turma d = turma.get(i);
                System.out.println("Numero: " + i + " - " + "Nome da Turma: " + d.getNome() );
            }
            System.out.println("\nFim da lista\n");
            
            String continua = textInput("Voltar ao Menu (S/N) ?");
            if (continua.equalsIgnoreCase("N")) {
            	execute = false;
            } else if (continua.equalsIgnoreCase("s")){
            	return;
            } else {
                
            }
        }
       }
 
   
    private void listarCadastrosA() {
        if (aluno.size() == 0) {
            System.out.println("\nNão existem cadastros !!!\n");
        } else {
            System.out.println("\nLista de Cadastros\n");
            for (int i = 0; i < aluno.size(); i++) {
                Aluno d = aluno.get(i);
                System.out.println("Nome do Aluno: " + d.getNome());
                System.out.println("Numero: " + i);
                System.out.println("Média:" + d.mediaDoAluno());
                System.out.println();
                System.out.println("------------------------------------------------------------------------");
            }
            System.out.println("\nFim da lista\n");
            
            String continua = textInput("Voltar ao Menu (S/N) ?");
            if (continua.equalsIgnoreCase("N")) {
            	execute = false;
            } else if (continua.equalsIgnoreCase("s")){
            	return;
            } else {
                
            }
        }
    }
   

    private String textInput(String label) {
        System.out.println(label);
        return l.nextLine();
    }
}