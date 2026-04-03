package model;

public class FuncionarioHorista extends Funcionario{

    private int hora;
    private double valorHora;

    public FuncionarioHorista(String nome, String cpf, String telefone, String setor, int hora, double valorHora) {
        super(nome, cpf, telefone, setor);
        this.hora = hora;
        this.valorHora = valorHora;
    }
}
