package model.entidade;

public class HomeShopping
{
    private Produto[] p;
    private int qtdeProduto;
    
    public HomeShopping(int qtdeProduto){
        setQtdeProduto(qtdeProduto);
        this.p = new Produto[getQtdeProduto()];
    }
  
    public void registraProduto(String titulo, String descricao, double preco, double tarifa){
        Produto novoProduto = new Produto(titulo, descricao, preco, tarifa);
        
        int i;
        for(i = 0;i<getQtdeProduto();i++){
            if(this.p[i]==null) 
                break;
        }
        
       
        if(i<getQtdeProduto())
            this.p[i] = novoProduto;
        else
            System.out.println("Não é possível registrar um novo produto pois não há posições livres");
    }
   
    public Produto pesquisaProduto(int codigo){
      
        for(int i = 0;i<getQtdeProduto();i++){
		
            if(this.p[i]!=null && this.p[i].getId()==codigo)
                return this.p[i];
        }
        
        return null;
    }
    
    public void compraProduto(int codigo, int qtdeComprada){

        Produto produtoComprado = pesquisaProduto(codigo);
        if(produtoComprado!=null){
            produtoComprado.adicionaProdutosAoEstoque(qtdeComprada); 
        } else {
            System.out.println("Este produto não foi registrado: " + codigo);
        }
    }
  
    public boolean verificaEstoqueProduto(int codigo, int qtdeVendida){
       
        Produto produtoVendido = pesquisaProduto(codigo);
        if(produtoVendido!=null){
            if(produtoVendido.getQtdeEstoque()>qtdeVendida)
                return true; 
        } else {
            System.out.println("Este produto n�o foi registrado: " + codigo);
            
        }
        
        return false; 
    }
    
    public void vendeProduto(int codigo, int qtdeVendida){
        
        if(verificaEstoqueProduto(codigo, qtdeVendida)){
           Produto produtoVendido = pesquisaProduto(codigo);
           produtoVendido.abateProdutosDoEstoque(qtdeVendida);
           System.out.println(qtdeVendida + " unidade(s) do produto vendido.");
        }
        else
            System.out.println("N�o h� saldo suficiente em estoque do produto.");
        
    }
    
    private int getQtdeProduto(){
        return this.qtdeProduto;
    }
    
    private void setQtdeProduto(int qtdeProduto){
        this.qtdeProduto = qtdeProduto;
    }
    
}
