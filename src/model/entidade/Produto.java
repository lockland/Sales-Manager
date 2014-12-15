package model.entidade;

public class Produto {

    private int id;
    private String titulo;
    private String descricao;
    private double precoUnitario;
    private double tarifaEntregaUnidade;
    private int qtdeEstoque;
    
    public Produto(String titulo, String descricao, double preco, double tarifa){
        this.titulo = titulo;
        this.descricao = descricao;
        this.precoUnitario = preco;
        this.tarifaEntregaUnidade = tarifa;
        this.qtdeEstoque = 0;
    }    

    public Produto(String titulo, String descricao, double precoUnitario, 
            double tarifaEntregaUnidade, int qtdeEstoque) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.tarifaEntregaUnidade = tarifaEntregaUnidade;
        this.qtdeEstoque = qtdeEstoque;
    }

    public Produto(int id, String titulo, String descricao, double precoUnitario,
            double tarifaEntregaUnidade, int qtdeEstoque) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.tarifaEntregaUnidade = tarifaEntregaUnidade;
        this.qtdeEstoque = qtdeEstoque;
    }

    public Produto(Produto produto) {
        this.id = produto.getId();
        this.titulo = produto.getTitulo();
        this.descricao = produto.getDescricao();
        this.precoUnitario = produto.getPrecoUnitario();
        this.tarifaEntregaUnidade = produto.getTarifaEntregaUnidade();
        this.qtdeEstoque = produto.getQtdeEstoque();
    }
    
    public Produto() {
        this.id = 0;
        this.titulo = "";
        this.descricao = "";
        this.precoUnitario = 0;
        this.tarifaEntregaUnidade = 0;
        this.qtdeEstoque = 0;
    }
    
    public void adicionaProdutosAoEstoque(int qtdeUnidades){
        setQtdeEstoque(getQtdeEstoque()+qtdeUnidades);
    }
    public int abateProdutosDoEstoque(int qtdeUnidades){
        if (getQtdeEstoque()<0){
            System.out.println("Não há unidades deste produto em estoque");
            return -1;
        } else if((getQtdeEstoque()-qtdeUnidades)<0) {
            System.out.println("Não é possível abater " + qtdeUnidades + " unidades pois há somente " + getQtdeEstoque() + " em estoque.");
            return -2;
        }
        
        setQtdeEstoque(getQtdeEstoque()-qtdeUnidades);
        return 0;   
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public double getPrecoUnitario(){
        return this.precoUnitario;
    }
    
    public void setPrecoUnitario(double precoUnitario){
        this.precoUnitario = precoUnitario;
    }    
    
    public double getTarifaEntregaUnidade(){
        return this.tarifaEntregaUnidade;
    }
    
    public void setTarifaEntregaUnidade(double tarifaEntregaUnidade){
        this.tarifaEntregaUnidade = tarifaEntregaUnidade;
    }
        
    public int getQtdeEstoque(){
        return this.qtdeEstoque;    
    }
    
    public void setQtdeEstoque(int qtdeEstoque){
        this.qtdeEstoque = qtdeEstoque;    
    }

    @Override
    public String toString() {
        return "Produto{" 
                + "id=" + id 
                + ", titulo=" + titulo 
                + ", descricao=" + descricao 
                + ", precoUnitario=" + precoUnitario 
                + ", tarifaEntregaUnidade=" + tarifaEntregaUnidade 
                + ", qtdeEstoque=" + qtdeEstoque + '}';
    }
    
    
}
