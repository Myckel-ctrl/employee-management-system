package model;

public class FuncionarioAssalariado extends Funcionario{

    private double salario;

    public FuncionarioAssalariado(String nome, String cpf, String telefone, String setor, double salario) {
        super(nome, cpf, telefone, setor);
        this.salario = salario;
    }

    @Override
    public double calcularSalario() {
        return salario;
    }

    @Override
    public void aplicarAumento(double percentual) {
        salario += salario * (percentual / 100);
    }
}
