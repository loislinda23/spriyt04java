
import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livro> listalivro = new ArrayList<>();
        Livro metodosL1ivro = new Livro ();

        JOptionPane.showMessageDialog(null,"Bem vindo ao Sistema de cadastro de Livros!!");

        //System.out.println("Bem vindo ao Sistema de cadastro de Livros!!");
        Scanner scanner = new Scanner(System.in);
        int opcao;


        do {
            System.out.println(" Escolha uma opção: 1 - Cadastrar livro / 2 - Listagem de Livros / 0 - Sair ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    Livro novaLivro = new Livro();
                    Autor novoAutor = new Autor();

                    System.out.println("Digite o Titulo do Livro: ");
                    novaLivro.titulo = scanner.next();

                    System.out.println("Digite o Preço do Livro: ");
                    novaLivro.preco = scanner.nextFloat();

                    System.out.println("Digite a data de Lançamento do Livro(dd/MM/aaaa): ");
                    LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Period periodo = Period.between(date, LocalDate.now());

                    novaLivro.dataLancamento = date;

                    if (periodo.getYears() >= 5){
                        System.out.println("Esse Livro tem mais de 5 anos");
                    }else{
                        System.out.println("Esse Livro tem menos de 5 anos. Retornando menu...");
                        break; // para voltar ao menu anterior
                    }


                    System.out.println("Digite o nome do Autor: ");
                    novoAutor.nome = scanner.next();

                    System.out.println("Digite o local de nascimento do Autor: ");
                    novoAutor.localNasc = scanner.next();



                    novaLivro.autor = novoAutor;

                    listalivro.add(novaLivro);

                    System.out.println("Cadastro realizado com sucesso!!");

                    break;


                case 2:
                    if (listalivro.size() > 0){
                        for (Livro cadaLivro: listalivro){
                            System.out.println();
                            System.out.println("Titulo:"+ cadaLivro.titulo);
                            System.out.println("Preço:" + cadaLivro.preco);
                            System.out.println("Autor:" + cadaLivro.autor.nome + " , " + cadaLivro.autor.localNasc);
                            System.out.println("Data de Lançamento:" + cadaLivro.dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println();
                            System.out.println("Digite 0 para continuar:");
                            System.out.println();
                        }

                        opcao = scanner.nextInt();

                    }else{
                        System.out.println("Lista vazia!");
                    }

                    break;

                case 0:
                    System.out.println("Voltando ao menu anterior !!");
                    break;

                default:
                    System.out.println("Opção invalida, digite uma Opção valida");
                    break;
            }

        }while (opcao != 0);

    }
}