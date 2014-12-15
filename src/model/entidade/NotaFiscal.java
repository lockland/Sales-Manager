package model.entidade;

/**
 *
 * @author Lockland
 */
public class NotaFiscal {
    private String nome;
    private String cpf; 
    private String email;
    private String titulo;
    private double precounitario;
    private double tarifaentrega;
    private double valortotal;
    private int parcelas;
    private double valorparcela;
    private int qtdProduto;

    public NotaFiscal(String nome, String cpf, String email, String titulo, 
            double precounitario, double tarifaentrega, double valortotal, 
            int parcelas, double valorparcela, int qtdProduto) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.titulo = titulo;
        this.precounitario = precounitario;
        this.tarifaentrega = tarifaentrega;
        this.valortotal = valortotal;
        this.parcelas = parcelas;
        this.valorparcela = valorparcela;
        this.qtdProduto = qtdProduto;
    }

    public NotaFiscal() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(double precounitario) {
        this.precounitario = precounitario;
    }

    public double getTarifaentrega() {
        return tarifaentrega;
    }

    public void setTarifaentrega(double tarifaentrega) {
        this.tarifaentrega = tarifaentrega;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getValorparcela() {
        return valorparcela;
    }

    public void setValorparcela(double valorparcela) {
        this.valorparcela = valorparcela;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    @Override
    public String toString() {
        return "NotaFiscal{" 
                + "nome=" + nome 
                + ", cpf=" + cpf 
                + ", email=" + email 
                + ", titulo=" + titulo 
                + ", precounitario=" + precounitario 
                + ", tarifaentrega=" + tarifaentrega 
                + ", valortotal=" + valortotal 
                + ", parcelas=" + parcelas 
                + ", valorparcela=" + valorparcela
                + ", qtdProduto=" + qtdProduto 
                + '}';
    }
    
    
}
