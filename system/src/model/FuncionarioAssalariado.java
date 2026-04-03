package model;

public class FuncionarioAssalariado extends Funcionario{

    private double salario;

    public FuncionarioAssalariado(String nome, String cpf, String telefone, String setor, double salario) {
        super(nome, cpf, telefone, setor);
        this.salario = salario;
    }
}
