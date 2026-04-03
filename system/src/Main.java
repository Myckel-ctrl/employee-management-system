
import exception.FuncionarioNaoEncontradoException;
import exception.HoraOuValorInvalidoException;
import exception.PercentualInvalidoException;
import exception.SalarioInvalidoException;
import model.Funcionario;
import repository.FuncionarioRepository;
import service.FuncionarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        FuncionarioRepository repository = new FuncionarioRepository();
        FuncionarioService service = new FuncionarioService(repository);

        int opcao1 = 0;
        do {
            try {
                System.out.println("1-Cadastrar");
                System.out.println("2-Remover");
                System.out.println("3-Listar");
                System.out.println("4-Buscar");
                System.out.println("5-Aplicar aumento");
                System.out.println("6-Encerrar sistema");
                System.out.print("Escolha uma opção:");
                opcao1 = read.nextInt();

                switch (opcao1) {
                    case 1:
                        linha();
                        System.out.println("-- Tipo de Funcionário --");
                        System.out.println("1-Funcionario Assalariado");
                        System.out.println("2-Funcionario Horista");
                        System.out.print("Escolha:");
                        int opcao2 = read.nextInt();
                        read.nextLine();

                        switch (opcao2) {
                            case 1:
                                linha();
                                System.out.print("Nome:");
                                String nome1 = read.nextLine();

                                System.out.print("CPF:");
                                String cpf1 = read.nextLine();

                                System.out.print("Telefone:");
                                String telefone1 = read.nextLine();

                                System.out.print("Setor:");
                                String setor1 = read.nextLine();

                                System.out.print("Salário:");
                                double salario1 = read.nextDouble();
                                read.nextLine();

                                service.cadastrarAssalariado(nome1, cpf1, telefone1, setor1, salario1);
                                System.out.println("Funcionário cadastrado com sucesso.");
                                linha();
                                break;


                            case 2:
                                linha();
                                System.out.print("Nome:");
                                String nome2 = read.nextLine();

                                System.out.print("CPF:");
                                String cpf2 = read.nextLine();

                                System.out.print("Telefone:");
                                String telefone2 = read.nextLine();

                                System.out.print("Setor:");
                                String setor2 = read.nextLine();

                                System.out.print("Horas trabalhadas:");
                                int hora = read.nextInt();

                                System.out.print("Valor da hora:");
                                double valor = read.nextDouble();

                                service.cadastrarHorista(nome2, cpf2, telefone2, setor2, hora, valor);
                                System.out.println("Funcionário cadastrado com sucesso.");
                                linha();
                                break;

                            default:
                                System.out.println("Tipo inválido.");
                                linha();
                                break;
                        }
                        break;

                    case 2:
                        linha();
                        System.out.println("-- Remover Funcionário --");
                        read.nextLine();

                        System.out.print("Nome:");
                        String nome3 = read.nextLine();

                        service.remover(nome3);
                        System.out.println("Funcionário removido com sucesso.");
                        linha();
                        break;

                    case 3:
                        linha();
                        System.out.println("-- Lista de Funcionários --");

                        if (service.listar().isEmpty()) {
                            System.out.println("Nenhum funcionário cadastrado.");
                        } else {
                            service.listar().forEach(System.out::println);
                        }
                        linha();
                        break;

                    case 4:
                        linha();
                        System.out.println("-- Buscar Funcionário --");
                        read.nextLine();

                        System.out.print("Nome:");
                        String nome4 = read.nextLine();

                        Funcionario f = service.buscar(nome4);
                        System.out.println(f);
                        linha();
                        break;

                    case 5:
                        linha();
                        System.out.println("-- Aumento geral para funcionários --");

                        System.out.print("Porcentual de aumento:");
                        double percentual = read.nextDouble();
                        read.nextLine();

                        service.aplicarAumentoGeral(percentual);
                        System.out.println("Aumento aplicado com sucesso.");
                        linha();
                        break;

                    case 6:
                        System.out.println("Sistema encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        linha();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                read.nextLine();
                linha();
            } catch (SalarioInvalidoException | PercentualInvalidoException | HoraOuValorInvalidoException | FuncionarioNaoEncontradoException e) {
                System.out.println(e.getMessage());
                linha();
            }
        } while (opcao1 != 6);
    }

    private static void linha() {
        System.out.println("----------------------------------------------");
    }
}

