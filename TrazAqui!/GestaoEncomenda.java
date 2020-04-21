import java.util.*;
import java.util.HashMap;

public class GestaoEncomenda
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private HashMap<String,Encomenda> encomendas;


    public GestaoEncomenda()
    {
       this.encomendas=new HashMap();
    }

   public GestaoEncomenda(HashMap<String,Encomenda> es){
    this.encomendas=new HashMap();
    for(Encomenda a:es.values())
        this.encomendas.put(a.getId(),a.clone());
    }
    
    public GestaoEncomenda(GestaoEncomenda ges){
        this.encomendas=ges.getEncomenda();
    }
    
    //get
    
    public HashMap<String,Encomenda> getEncomenda() {
        HashMap<String,Encomenda> aux = new HashMap<>();
        for(Encomenda a: this.encomendas.values())
            aux.put(a.getId(),a.clone());
        return aux;
    }

    public void setCliente(HashMap<String,Encomenda> es) {
        this.encomendas = new HashMap<>();
        for(Encomenda a : es.values())
            this.encomendas.put(a.getId(),a.clone());
    }
    
    
     public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        GestaoEncomenda aux = (GestaoEncomenda) object;
        return aux.getEncomenda().equals(this.getEncomenda());
    }
    
      public GestaoEncomenda clone(){
        return new GestaoEncomenda(this);
    }

    public String toString(){
        return "As encomendas são: \n" + this.getEncomenda();
    }
    
    
    //adiciona encomenda
    
    public void addEncomenda(Encomenda a){
        this.encomendas.put(a.getId(),a.clone());
    }
    
    // verifica se o cliente com e email e existe
    public boolean verifica(String e){
        return(encomendas.containsKey(e));
    }
    

    // busca encomenda com respetivo id
     public Encomenda buscaEncomenda(String id){
        return this.encomendas.get(id).clone();
    }
    
}
