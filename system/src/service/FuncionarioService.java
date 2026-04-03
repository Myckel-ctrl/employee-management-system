package service;

import repository.FuncionarioRepository;

public class FuncionarioService {

    private FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }
}
