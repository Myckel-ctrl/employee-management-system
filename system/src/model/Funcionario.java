package model;

public abstract class Funcionario {

    private String nome;
    private String cpf;
    private String telefone;
    private String setor;

    public Funcionario(String nome, String cpf, String telefone, String setor) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.setor = setor;
    }

    public abstract double calcularSalario();

    public abstract void aplicarAumento(double percentual);

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome +
                "\nCPF: " + this.cpf +
                "\nTelefone: " + this.telefone +
                "\nSetor: " + this.setor +
                "\nSalário: " + calcularSalario() +
                "\n";
    }
}
