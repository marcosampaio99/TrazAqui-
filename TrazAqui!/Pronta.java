import java.util.Date;
import java.util.ArrayList;

/**
 * Escreva a descri��o da classe Pronta aqui.
 * 
 * @author (seu nome) 
 * @version (n�mero de vers�o ou data)
 */
public class Pronta extends Encomenda
{
    // vari�veis de inst�ncia - substitua o exemplo abaixo pelo seu pr�prio
    private Empresa empresa;
    private double preco;
    
    public Pronta(){
        super();
        this.empresa= new Empresa();
        this.preco=-1;
    }
    
    public Pronta(String idAux, Cliente clienteAux, Loja lojaAux, double pesoAux, boolean stateAux,Date dataAux, boolean respostaClienteAux, boolean flagLojaProntaAux,ArrayList<LinhaEncomenda> l,Empresa empresaAux, double precoAux){
        super(idAux, clienteAux, lojaAux, pesoAux, stateAux, dataAux,respostaClienteAux,flagLojaProntaAux,l);
        this.empresa= empresaAux;
        this.preco=precoAux;
    }
    
    public Pronta(Pronta p){
        super(p);
        this.empresa= p.getEmpresa();
        this.preco=p.getPreco();
    }
    
    //getters
    
    public Empresa getEmpresa(){
       return this.empresa;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
  public void setEmpresa(Empresa e){
       this.empresa=e;
    }
    
    public void setPreco(double preco){
        this.preco=preco;
    }
    public boolean equals (Object o){
        if(this==o) return true;
        
        if((o==null) || (this.getClass()!=o.getClass())) return false;
        Pronta p=(Pronta) o;
        return (super.equals(p) && this.getEmpresa().equals(p.getEmpresa()) && this.preco==p.getPreco());
    }
    
    public String toString(){
       return "Encomenda com id: " + this.getId() +
              "Cliente: " + this.getCliente().getNome() +
              "Loja: " + this.getLoja().getNome() +
              "Peso: " + this.getPeso() +
              "Empresa que prentende transportar: "+ this.empresa.getEmail() + 
              "Com preco: " + this.preco + "\n";
              
            }
            
            
    public Pronta clone(){
        return new Pronta(this);
    }
    
}
