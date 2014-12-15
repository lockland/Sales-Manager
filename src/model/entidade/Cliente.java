package model.entidade;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Cliente extends Pessoa {

    private String cpf;
    private String nome;
    private String email;
    private String dataCadastro;
    private double limitecredito;

    public Cliente(int id, String nome, String email, String cpf,
            double limitecredito, String senha) {
        super(id, senha);
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.dataCadastro = getDatePtBr();
        this.limitecredito = limitecredito;
    }

    public Cliente(String nome, String email, String cpf, String senha, 
                double limitecredito) {
        super(senha);
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.limitecredito = limitecredito;
        this.dataCadastro = getDatePtBr();
    }

    public Cliente(int id, String nome, String email, String cpf, 
                   String senha, String dataCadastro, double limitecredito) {
        super(id, senha);
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        this.limitecredito = limitecredito;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public double getLimitecredito() {
        return limitecredito;
    }

    public void setLimitecredito(double limitecredito) {
        this.limitecredito = limitecredito;
    }
    
    private Date getCorrentDate(){
        return new Date(System.currentTimeMillis());   
    }
    
    public String getDateEnUs(){
        return new SimpleDateFormat("yyyy-MM-dd").format(getCorrentDate());
    }
    
    public String getDatePtBr(){
        return new SimpleDateFormat("dd/MM/yyyy").format(getCorrentDate());
    }

    @Override
    public String toString() {
        return "Cliente{ " 
                + "id=" + super.getId()
                + ", nome=" + nome
                + ", email=" + email
                + ", senha=" + super.getSenha()
                + ", cpf=" + cpf
                + ", dataCadastro=" + dataCadastro
                + ", limitecredito=" + limitecredito + '}';
    }


    
}
