package service;

import exception.FuncionarioNaoEncontradoException;
import exception.HoraOuValorInvalidoException;
import exception.PercentualInvalidoException;
import exception.SalarioInvalidoException;
import model.Funcionario;
import model.FuncionarioAssalariado;
import model.FuncionarioHorista;
import repository.FuncionarioRepository;

import java.util.List;

public class FuncionarioService {

    private FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void cadastrarHorista(String nome, String cpf, String telefone, String setor, int hora, double valorHora){
        if (hora <= 0 || valorHora <= 0) {
            throw new HoraOuValorInvalidoException("Hora ou valor inválido.");
        }

        Funcionario funcionario = new FuncionarioHorista(nome, cpf, telefone, setor, hora, valorHora);
        repository.salvar(funcionario);
    }

    public void cadastrarAssalariado(String nome, String cpf, String telefone, String setor, double salario){
        if (salario <= 0) {
            throw new SalarioInvalidoException("Salário inválido.");
        }

        Funcionario funcionario = new FuncionarioAssalariado(nome, cpf, telefone, setor, salario);
        repository.salvar(funcionario);
    }

    public List<Funcionario> listar() {
        return repository.listar();
    }

    public Funcionario buscar(String nome) {
        Funcionario funcionario = repository.buscar(nome);

        if (funcionario == null) {
            throw new FuncionarioNaoEncontradoException("Funcionário não encontrado.");
        }
        return funcionario;
    }

    public void remover(String nome) {
        boolean removido = repository.remover(nome);

        if (!removido) {
            throw new FuncionarioNaoEncontradoException("Funcionário não encontrado.");
        }
    }

    public void aplicarAumentoGeral(double percentual) {
        if (percentual <= 0) {
            throw new PercentualInvalidoException("Percentual inválido.");
        }

        List<Funcionario> lista = listar();

        for (Funcionario f: lista) {
            f.aplicarAumento(percentual);
        }
    }
}
