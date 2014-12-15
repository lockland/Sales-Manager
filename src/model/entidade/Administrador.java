package model.entidade;

public class Administrador extends Pessoa
{
    private String dataAdmissao;
	
    public Administrador(String senha, String data){
        super();
        setSenha(senha);
        setDataAdmissao(data);
    }
	
    public String getDataAdmissao(){
        return this.dataAdmissao;
    }
    
    public void setDataAdmissao(String data){
        this.dataAdmissao = data;
    }
   
}
