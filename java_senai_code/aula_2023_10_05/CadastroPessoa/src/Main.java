import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // sout = snipet para printar algo na tela
        System.out.println("==========================================================================");
        System.out.println("==========================================================================");
        System.out.println(" ");

        ArrayList<PessoaJuridica> listaPj = new ArrayList<>();
        ArrayList<PessoaFisica> listaPf = new ArrayList<>();
        PessoaFisica metodosPf = new PessoaFisica();
        PessoaJuridica metodosPj = new PessoaJuridica();

        // sout = snipet para printar algo na tela
        System.out.println("Bem vindo ao sistema de cadastro de Pessoa Física e Pessoa Jurídica.");

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // sout = snipet para printar algo na tela
            System.out.println(" ");
            System.out.println("Escolha uma opção:\n 1 = Pessoa Física.\n 2 = Pessoa Jurídica.\n 0 = Sair.");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    int opcaoPf;
                    do {
                        System.out.println("Escolha uma opção:\n 1 = Cadastrar Pessoa Física\n 2 = Listar Pessoa Física\n 0 = Voltar ao menu anterior.");
                        opcaoPf = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoPf){
                            case 1:
                                PessoaFisica pessoaFisica1 = new PessoaFisica();
                                Endereco endPessoa1 = new Endereco();

                                System.out.println("Digite o nome da pessoa fisica: ");
                                pessoaFisica1.nome = scanner.nextLine();

                                System.out.println("Digite o CPF (digite somente números): ");
                                pessoaFisica1.cpf = scanner.nextLine();

                                System.out.println("Digite o rendimento mensal (digite somente números): ");
                                pessoaFisica1.rendimento = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
                                LocalDate date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                Period periodo = Period.between(date, LocalDate.now());

                                pessoaFisica1.dataNacimento = date;

                                if (periodo.getYears() >= 18){
                                    System.out.println("A pessoa tem mais de 18 anos.");
                                }else {
                                    System.out.println("A pessoa não tem mais de 18 anos.");
                                    break;
                                }

                                System.out.println("Digite o logradouro: ");
                                endPessoa1.logradouro = scanner.nextLine();

                                System.out.println("Digite o número: ");
                                endPessoa1.numero = scanner.nextLine();

                                System.out.println("Este endereço é comercial ? S/N: ");
                                String endCom;
                                endCom = scanner.nextLine();

                                // equalsIgnoreCase = ignorar letras maiúsculas ou minúsculas
                                if (endCom.equalsIgnoreCase("S")){
                                    endPessoa1.enderecoComercial = true;
                                }else {
                                    endPessoa1.enderecoComercial = false;
                                }

                                pessoaFisica1.endereco = endPessoa1;

                                listaPf.add(pessoaFisica1);

                                System.out.println();
                                System.out.println("Cadastro realizado com sucesso.");
                                System.out.println();

                                break;

                            case 2:
                                if (listaPf.size() > 0){
                                    for (PessoaFisica cadaPf : listaPf){
                                        System.out.println();
                                        System.out.println("Nome: " + cadaPf.nome);
                                        System.out.println("CPF: " + cadaPf.cpf);
                                        System.out.println("Data de Nascimento: " + cadaPf.dataNacimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Endereço: " + cadaPf.endereco.logradouro + ", " + cadaPf.endereco.numero);
                                        System.out.println("Imposto a ser pago: " + metodosPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println();
                                        System.out.println("Digite 0 para continuar.");
                                        scanner.nextLine();
                                        System.out.println();
                                    }

                                    opcaoPf = scanner.nextInt();

                                }else {
                                    System.out.println();
                                    System.out.println("Lista Vazia.");
                                    System.out.println();
                                }
                                break;
                            case 0:
                                System.out.println();
                                System.out.println("Voltando ao menu anterior.");
                                System.out.println();
                                break;
                            default:
                                System.out.println();
                                System.out.println("Você é burro ?!\n Digite uma opção válida.");
                                System.out.println();
                                break;
                        }
                    }while (opcaoPf != 0);
                    System.out.println();
                    break;
                case 2:

                    int opcaoPj;
                    do {
                        System.out.println("Escolha uma opção:\n 1 = Cadastrar Pessoa Jurídica\n 2 = Listar Pessoa Jurídica\n 0 = Voltar ao menu anterior.");
                        opcaoPj = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoPj){
                            case 1:
                                PessoaJuridica pessoaJuridica1 = new PessoaJuridica();
                                Endereco endPj1 = new Endereco();

                                System.out.println("Digite o nome fantasia da pessoa jurídica: ");
                                pessoaJuridica1.nome = scanner.nextLine();

                                System.out.println("Digite a razão social da pessoa jurídica: ");
                                pessoaJuridica1.razaoSocial = scanner.nextLine();

                                System.out.println("Digite o CNPJ (digite somente números): ");
                                pessoaJuridica1.cnpj = scanner.nextLine();

                                System.out.println("Digite o rendimento mensal (digite somente números): ");
                                pessoaJuridica1.rendimento = scanner.nextInt();
                                scanner.nextLine();

                                System.out.println("Digite o logradouro: ");
                                endPj1.logradouro = scanner.nextLine();

                                System.out.println("Digite o número: ");
                                endPj1.numero = scanner.nextLine();

                                System.out.println("Este endereço é comercial ? S/N: ");
                                String endCom;
                                endCom = scanner.nextLine();

                                // equalsIgnoreCase = ignorar letras maiúsculas ou minúsculas
                                if (endCom.equalsIgnoreCase("S")){
                                  endPj1.enderecoComercial = true;
                                }else {
                                    endPj1.enderecoComercial = false;
                                }

                                pessoaJuridica1.endereco = endPj1;

                                listaPj.add(pessoaJuridica1);

                                System.out.println();
                                System.out.println("Cadastro realizado com sucesso.");
                                System.out.println();
                                break;

                            case 2:
                                if (listaPj.size() > 0){
                                    for (PessoaJuridica cadaPj : listaPj){
                                        System.out.println();
                                        System.out.println("Nome: " + cadaPj.nome);
                                        System.out.println("Razão Social: " + cadaPj.razaoSocial);
                                        System.out.println("CNPJ: " + cadaPj.cnpj);
                                        System.out.println("Endereço: " + cadaPj.endereco.logradouro + ", " + cadaPj.endereco.numero);
                                        System.out.println("Imposto a ser pago: " + metodosPj.CalcularImpostoJuridica(cadaPj.rendimento));
                                        System.out.println();
                                        System.out.println("Digite 0 para continuar.");
                                        scanner.nextLine();
                                        System.out.println();
                                    }

                                    opcaoPj = scanner.nextInt();
                                    System.out.println();

                                }else {
                                    System.out.println();
                                    System.out.println("Lista Vazia.");
                                    System.out.println();
                                }
                                break;
                            case 0:
                                System.out.println();
                                System.out.println("Voltando ao menu anterior.");
                                System.out.println();
                                break;
                            default:
                                System.out.println();
                                System.out.println("Você é burro ?!\n Digite uma opção válida.");
                                System.out.println();
                                break;
                        }
                    }while (opcaoPj != 0);
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Obrigado por utilizar o nosso sistema.");
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println("Você é burro ?!\n Digite uma opção válida.");
                    System.out.println();
                    break;
            }
        }while (opcao != 0);
        System.out.println();


        // sout = snipet para printar algo na tela
        System.out.println(" ");
        System.out.println("==========================================================================");
        System.out.println("==========================================================================");
    }
}