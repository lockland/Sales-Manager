package model.entidade;

public class Venda {
    
    private int id;
    private int qtdParcelas;
    private double valorParcelas;
    private double valorTotal;

    public Venda(int id, int qtdParcelas, double valorParcelas) {
        this.id = id;
        this.qtdParcelas = qtdParcelas;
        this.valorParcelas = valorParcelas;
        this.valorTotal = getValorTotal();
    }

    public Venda(int qtdParcelas, double valorParcelas) {
        this.qtdParcelas = qtdParcelas;
        this.valorParcelas = valorParcelas;
        this.valorTotal = getValorTotal();
    }

    public Venda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public double getValorParcelas() {
        return valorParcelas;
    }

    public double getValorTotal() {
        return this.qtdParcelas * this.valorParcelas;
    }

    @Override
    public String toString() {
        return "Compra{"
                + "id=" + id 
                + ", qtdParcelas=" + qtdParcelas 
                + ", valorParcelas=" + valorParcelas 
                + ", valorTotal=" + valorTotal + '}';
    }
}