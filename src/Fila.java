

public class Fila {
    private int senha;
    private String nome;
    private boolean prioridade;
    
    public Fila(String nome, int senha, boolean prioridade) {
        this.nome = nome;
        this.senha = senha;
        this.prioridade = prioridade;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPrioridade() {
    return prioridade;
    }
    
    @Override
public String toString() {
    return "Nome: " + nome + " | Senha: " + senha + (prioridade ? " (Prioritario)" : "");
}

}

