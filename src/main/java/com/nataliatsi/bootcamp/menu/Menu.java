package com.nataliatsi.bootcamp.menu;

import com.nataliatsi.bootcamp.domain.Bootcamp;
import com.nataliatsi.bootcamp.domain.Curso;
import com.nataliatsi.bootcamp.domain.Dev;
import com.nataliatsi.bootcamp.domain.Mentoria;
import lombok.var;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Bootcamp bootcamp = new Bootcamp();
    private Dev dev = new Dev();
    private List<Bootcamp> bootcamps = new ArrayList<>();

    public void exibirMenu(){
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Criar Bootcamp");
            System.out.println("2. Adicionar Curso ao Bootcamp");
            System.out.println("3. Adicionar Mentoria ao Bootcamp");
            System.out.println("4. Inscrever Dev no Bootcamp");
            System.out.println("5. Progredir Dev");
            System.out.println("6. Calcular XP Total do Dev");
            System.out.println("7. Listar Bootcamps");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarBootcamp(scanner);
                    break;
                case 2:
                    adicionarCurso(scanner);
                    break;
                case 3:
                    adicionarMentoria(scanner);
                    break;
                case 4:
                    inscreverDev(scanner);
                    break;
                case 5:
                    progredirDev();
                    break;
                case 6:
                    calcularXpTotal();
                    break;
                case 7:
                    listarBootcamps();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    private void criarBootcamp(Scanner scanner) {
        System.out.print("Digite o nome do Bootcamp: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a descrição do Bootcamp: ");
        String descricao = scanner.nextLine();

        bootcamp.setNome(nome);
        bootcamp.setDescricao(descricao);
        bootcamps.add(bootcamp);

        System.out.println("Bootcamp criado com sucesso!");
    }

    private void listarBootcamps(){
        if(bootcamps.isEmpty()){
            System.out.println("Não há Bootcamps cadastrados.");
        }
        bootcamps.forEach(System.out::println);
    }

    private void inscreverDev(Scanner scanner) {
        System.out.print("Digite o nome do Dev: ");
        String nome = scanner.nextLine();

        dev.setNome(nome);
        dev.inscreverBootcamp(bootcamp);

        System.out.println("Dev inscrito com sucesso no Bootcamp!");
    }

    private void adicionarCurso(Scanner scanner) {
        Curso curso = new Curso();

        System.out.print("Digite o título do Curso: ");
        curso.setTitulo(scanner.nextLine());
        System.out.print("Digite a descrição do Curso: ");
        curso.setDescricao(scanner.nextLine());
        System.out.print("Digite a carga horária do Curso: ");
        curso.setCargaHoraria(scanner.nextInt());
        scanner.nextLine();

        bootcamp.getConteudos().add(curso);

        System.out.println("Curso adicionado ao Bootcamp com sucesso!");
    }

    private void adicionarMentoria(Scanner scanner) {
        Mentoria mentoria = new Mentoria();

        System.out.print("Digite o título da Mentoria: ");
        mentoria.setTitulo(scanner.nextLine());
        System.out.print("Digite a descrição da Mentoria: ");
        mentoria.setDescricao(scanner.nextLine());
        System.out.print("Digite a data da Mentoria (YYYY-MM-DD): ");
        mentoria.setData(LocalDate.parse(scanner.nextLine()));

        bootcamp.getConteudos().add(mentoria);

        System.out.println("Mentoria adicionada ao Bootcamp com sucesso!");
    }

    private void progredirDev() {
        dev.progredir();
        System.out.println("Progresso realizado com sucesso!");
    }

    private void calcularXpTotal() {
        double xpTotal = dev.calcularXpTotal();
        System.out.println("XP Total do Dev: " + xpTotal);
    }

}
