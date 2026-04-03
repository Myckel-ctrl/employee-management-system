package repository;

public class FuncionarioRepository {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public void salvar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listar() {
        return funcionarios;
    }

    public Funcionario buscar(String nome) {
        for (Funcionario f: funcionarios) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                return f;
            }
        }
        return null;
    }

    public boolean remover(String nome) {
        return funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
    }
}
