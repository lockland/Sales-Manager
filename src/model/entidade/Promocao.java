package model.entidade;

import java.sql.Date;

/**
 *
 * @author Lockland
 */
public class Promocao {
    private int id;
    private double precoPromocional;
    private Produto produto;
    private Date dataInicio;
    private Date dataFim;

    public Promocao(int id, double precoPromocional, Produto produto, Date dataInicio, Date dataFim) {
        this.id = id;
        this.precoPromocional = precoPromocional;
        this.produto = produto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Promocao(double precoPromocional, Produto produto, Date dataInicio, Date dataFim) {
        this.id = 0;
        this.precoPromocional = precoPromocional;
        this.produto = produto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Promocao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecoPromocional() {
        return precoPromocional;
    }

    public void setPrecoPromocional(double precoPromocional) {
        this.precoPromocional = precoPromocional;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "Promocao{" + "id=" + id 
                + ", precoPromocional=" + precoPromocional 
                + ", produto=" + produto 
                + ", dataInicio=" + dataInicio 
                + ", dataFim=" + dataFim 
                + '}';
    }

    
    
    
}
