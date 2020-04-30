import java.util.Date;
import java.util.ArrayList;
/**
 * Escreva a descrição da classe RealizadaVoluntario aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class RealizadaVoluntario extends Encomenda
{
    private Voluntario voluntario;
    private Date dataR;
    private boolean classificado; // se ja foi classificado ou nao
    private double classificacao; // guarda-se a classificacao atribuida
    
    
    public RealizadaVoluntario(){
      super();
      this.voluntario= new Voluntario();
      this.classificado=false;
      this.classificacao=-1;
    }
    
    public RealizadaVoluntario(String idAux, Cliente clienteAux, Loja lojaAux, double pesoAux, boolean stateAux,Date dataAux,boolean respostaClienteAux, boolean flagLojaProntaAux, ArrayList<LinhaEncomenda> l,Voluntario voluntarioAux, Date dataRAux,boolean classificadoAux, double classificacaoAux){
        super(idAux, clienteAux, lojaAux, pesoAux, stateAux, dataAux,respostaClienteAux,flagLojaProntaAux,l);
        this.voluntario=voluntarioAux;
        this.classificado=classificadoAux;
        this.classificacao=classificacaoAux;
    }
    
    public RealizadaVoluntario(RealizadaVoluntario v){
        super(v);
        this.voluntario=v.getVoluntario();
        this.classificado=v.getClassificado();
        this.classificacao=v.getClassificacao();
    }
    
    //getters
    
    public Voluntario getVoluntario(){
        return this.voluntario;
    }
    
   public boolean getClassificado(){
       return this.classificado;
    }
    
   public double getClassificacao(){
        return this.classificacao;
    }
    
   //setters
   
   public void setVoluntario(Voluntario v){
       this.voluntario=v;
    }
    
   public void setClassificado(boolean c){
       this.classificado=c;
    }
    
   public void setClassificacao(double c){
       this.classificacao=c;
    }
    
   public boolean equals (Object o){
        if(this==o) return true;
        
        if((o==null) || (this.getClass()!=o.getClass())) return false;
        
        RealizadaVoluntario rv= (RealizadaVoluntario) o;
        return(super.equals(rv) && this.getVoluntario().equals(rv.getVoluntario()) &&
               this.classificado==rv.getClassificado() &&
               this.classificado==rv.getClassificado());
            }
            
   public String toString(){
       return "Encomenda com id: " + this.getId() +
              "Cliente: " + this.getCliente() +
              "Loja: " + this.getLoja() +
              "Peso: " + this.getPeso() +
              "Entregue por Voluntario: " + this.voluntario.getEmail() +
              "Data de entrega: " + this.dataR +
              "Classficada? "+ this.classificado +
              "Classificacao atribuida: " + this.classificacao +"\n";
            }
            
    public RealizadaVoluntario clone(){
        return new RealizadaVoluntario(this);
    }
    
    //metodos
    public void clienteClassifica(double c){
        this.setClassificacao(c);
        this.setClassificado(true);
    }
}
