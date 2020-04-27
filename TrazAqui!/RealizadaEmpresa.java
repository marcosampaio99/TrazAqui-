import java.util.Date;
import java.util.ArrayList;

public class RealizadaEmpresa extends Encomenda 
{
  private Empresa empresa;
  private double preco;
  private Date dataR;
  private double distanciaViagem;
  private boolean classificado; // se ja foi classificado ou nao
  private double classificacao; // guarda-se a classificacao atribuida
  
  public RealizadaEmpresa(){
      super();
      this.empresa= new Empresa();
      this.preco=-1;
      this.distanciaViagem=-1;
      this.classificado=false;
      this.classificacao=-1;
    }
    
  public RealizadaEmpresa(String idAux, Cliente clienteAux, Loja lojaAux, double pesoAux, boolean stateAux,Date dataAux, ArrayList<LinhaEncomenda> l, Empresa empresaAux, double precoAux, Date dataRAux,double distanciaViagemAux, boolean classificadoAux, double classificacaoAux){
      super(idAux, clienteAux, lojaAux, pesoAux, stateAux, dataAux,l);
      this.empresa= empresaAux;
      this.preco= precoAux;
      this.distanciaViagem= distanciaViagemAux;
      this.classificado=classificadoAux;
      this.classificacao=classificacaoAux;
    }
    
  public RealizadaEmpresa(RealizadaEmpresa e){
      super(e);
      this.empresa= e.getEmpresa();
      this.preco= e.getPreco();
      this.distanciaViagem= e.getDistanciaViagem();
      this.classificado=e.getClassificado();
      this.classificacao=e.getClassificacao();
    }
    
   //getters
   
   public Empresa getEmpresa(){
       return this.empresa;
    }
    
   public double getPreco(){
       return this.preco;
    }
    
   public Date getDataR(){
       return this.dataR;
    }
    
   public double getDistanciaViagem(){
       return this.distanciaViagem;
    }
    
   public boolean getClassificado(){
       return this.classificado;
    }
    
   public double getClassificacao(){
        return this.classificacao;
    }
    
    // setters
    
    
   public void setEmpresa(Empresa e){
       this.empresa=e;
    }
    
   public void setPreco(double p){
       this.preco=p;
    }
    
   public void setData(Date d) {
        this.dataR = d;
    } 
     
   public void setDistanciaViagem(double d){
       this.distanciaViagem=d;
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
        
        RealizadaEmpresa re= (RealizadaEmpresa) o;
        return(super.equals(re) && this.getEmpresa().equals(re.getEmpresa()) &&
               this.preco==re.getPreco() && this.getData().equals(re.getData()) &&
               this.distanciaViagem==re.getDistanciaViagem() && this.classificado==re.getClassificado() &&
               this.classificado==re.getClassificado());
            }
            
            
   public String toString(){
       return "Encomenda com id: " + this.getId() +
              "Cliente: " + this.getCliente() +
              "Loja: " + this.getLoja() +
              "Peso: " + this.getPeso() +
              "Entregue por Empresa: " + this.empresa.getEmail() +
              "Distancia da viagem de entrega: " + this.distanciaViagem +
              "Preco: " + this.preco + 
              "Data de entrega: " + this.dataR +
              "Classficada? "+ this.classificado +
              "Classificacao atribuida: " + this.classificacao +"\n";
            }
          
            
   public RealizadaEmpresa clone(){
        return new RealizadaEmpresa(this);
    }
    
    //metodos
    public void clienteClassifica(double c){
        this.setClassificacao(c);
        this.setClassificado(true);
    }
}
