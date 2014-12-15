package model.entidade;


public class Pessoa
{
    private int id;
    private String senha;

    public Pessoa(String senha) {
        this.id = 0;
        this.senha = senha;
    }

    public Pessoa(int id, String senha) {
        this.id = id;
        this.senha = senha;
    }
    
    public Pessoa() {
        this.id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
