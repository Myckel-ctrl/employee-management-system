package service;

import exception.HoraOuValorInvalidoException;
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


}
