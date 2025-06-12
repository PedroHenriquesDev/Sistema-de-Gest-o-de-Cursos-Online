package view;

import controller.CursoController;
import model.*;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static CursoController controller = new CursoController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            try {
                switch (opcao) {
                    case 1:
                        cadastrarCurso();
                        break;
                    case 2:
                        cadastrarAula();
                        break;
                    case 3:
                        listarCursos();
                        break;
                    case 4:
                        buscarCurso();
                        break;
                    case 5:
                        removerCurso();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n=== Sistema de Gestão de Cursos Online ===");
        System.out.println("1. Cadastrar Curso");
        System.out.println("2. Cadastrar Aula em Curso");
        System.out.println("3. Listar Cursos");
        System.out.println("4. Buscar Curso por Nome");
        System.out.println("5. Remover Curso");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarCurso() throws CampoObrigatorioException {
        System.out.println("\n--- Cadastro de Curso ---");
        
        System.out.print("Nome do Curso: ");
        String nome = scanner.nextLine();
        
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        
        System.out.print("Carga Horária (horas): ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        System.out.print("Nome do Instrutor: ");
        String nomeInstrutor = scanner.nextLine();
        
        System.out.print("Especialidade do Instrutor: ");
        String especialidade = scanner.nextLine();
        
        Instrutor instrutor = new Instrutor(nomeInstrutor, especialidade);
        controller.cadastrarCurso(nome, descricao, cargaHoraria, instrutor);
        
        System.out.println("Curso cadastrado com sucesso!");
    }

    private static void cadastrarAula() {
        System.out.println("\n--- Cadastro de Aula ---");
        
        System.out.print("Nome do Curso para adicionar aula: ");
        String nomeCurso = scanner.nextLine();
        
        try {
            System.out.print("Nome da Aula: ");
            String nomeAula = scanner.nextLine();
            
            System.out.print("Descrição da Aula: ");
            String descricaoAula = scanner.nextLine();
            
            System.out.print("Duração da Aula (minutos): ");
            int duracaoAula = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            controller.adicionarAulaAoCurso(nomeCurso, nomeAula, descricaoAula, duracaoAula);
            System.out.println("Aula adicionada com sucesso!");
        } catch (CursoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (CampoObrigatorioException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarCursos() {
        System.out.println("\n--- Lista de Cursos ---");
        List<Curso> cursos = controller.listarCursos();
        
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
        } else {
            for (Curso curso : cursos) {
                curso.exibir();
            }
        }
    }

    private static void buscarCurso() {
        System.out.println("\n--- Buscar Curso ---");
        System.out.print("Digite o nome do curso: ");
        String nome = scanner.nextLine();
        
        try {
            Curso curso = controller.buscarCursoPorNome(nome);
            System.out.println("\nCurso encontrado:");
            curso.exibir();
        } catch (CursoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void removerCurso() {
        System.out.println("\n--- Remover Curso ---");
        System.out.print("Digite o nome do curso a ser removido: ");
        String nome = scanner.nextLine();
        
        try {
            controller.removerCurso(nome);
            System.out.println("Curso removido com sucesso!");
        } catch (CursoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
