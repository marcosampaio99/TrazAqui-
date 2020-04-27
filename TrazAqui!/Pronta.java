import java.util.Date;
import java.util.ArrayList;

/**
 * Escreva a descrição da classe Pronta aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Pronta extends Encomenda
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private boolean respostaCliente; // se alguma empresa mandou pedido ou nao
    private boolean flagLojaPronta; // 0 se a encomenda ainda nao está pronta, 1 se a loja ja tiver a encomenda pronta
    private double preco;
    
    public Pronta(){
        super();
        this.respostaCliente=false;
        this.flagLojaPronta=false;
        this.preco=-1;
    }
    
    public Pronta(String idAux, Cliente clienteAux, Loja lojaAux, double pesoAux, boolean stateAux,Date dataAux, ArrayList<LinhaEncomenda> l, boolean respostaClienteAux, boolean flagLojaProntaAux,double precoAux){
        super(idAux, clienteAux, lojaAux, pesoAux, stateAux, dataAux,l);
        this.respostaCliente=respostaClienteAux;
        this.flagLojaPronta=flagLojaProntaAux;
        this.preco=precoAux;
    }
    
    public Pronta(Pronta p){
        super(p);
        this.respostaCliente=p.getRespostaCliente();
        this.flagLojaPronta=p.getFlagLojaPronta();
        this.preco=p.getPreco();
    }
    
    //getters
    
    public boolean getRespostaCliente(){
        return this.respostaCliente;
    }
    
    public boolean getFlagLojaPronta(){
        return this.flagLojaPronta;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public void setRespostaCliente(boolean r){
        this.respostaCliente=r;
    }
    
    public void setFlagLojaPronta(boolean r){
        this.flagLojaPronta=r;
    }
    
    public void setPreco(double preco){
        this.preco=preco;
    }
    public boolean equals (Object o){
        if(this==o) return true;
        
        if((o==null) || (this.getClass()!=o.getClass())) return false;
        Pronta p=(Pronta) o;
        return (super.equals(p) && this.respostaCliente==p.getRespostaCliente() 
        && this.flagLojaPronta==p.getFlagLojaPronta() && this.preco==p.getPreco());
    }
    
    public String toString(){
       return "Encomenda com id: " + this.getId() +
              "Cliente: " + this.getCliente() +
              "Loja: " + this.getLoja() +
              "Peso: " + this.getPeso() +
              "Preco: " + this.preco +
              "Loja ja tem a encomenda pronta? (0-Nao 1-Sim) " + this.flagLojaPronta +
              "Ja foi enviado pedido de aceite ao cliente? (0-Nao 1-Sim) " + this.respostaCliente + "\n";
            }
            
            
    public Pronta clone(){
        return new Pronta(this);
    }
    
}
