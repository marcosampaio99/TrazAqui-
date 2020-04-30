import java.util.*;
import java.util.HashMap;
/**
 * Escreva a descrição da classe GestaoCliente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class GestaoCliente
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private HashMap<String,Cliente> clientes;


    public GestaoCliente()
    {
       this.clientes=new HashMap();
    }

   public GestaoCliente(HashMap<String,Cliente> clientes2){
    this.clientes=new HashMap();
    for(Cliente a:clientes2.values())
        this.clientes.put(a.getEmail(),a.clone());
    }
    
    public GestaoCliente(GestaoCliente gcs){
        this.clientes=gcs.getCliente();
    }
    
    //get
    
    public HashMap<String,Cliente> getCliente() {
        HashMap<String,Cliente> aux = new HashMap<>();
        for(Cliente a: this.clientes.values())
            aux.put(a.getEmail(),a.clone());
        return aux;
    }

    public void setCliente(HashMap<String,Cliente> clientes) {
        this.clientes = new HashMap<>();
        for(Cliente a : clientes.values())
            this.clientes.put(a.getEmail(),a.clone());
    }
    
    
     public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        GestaoCliente aux = (GestaoCliente) object;
        return aux.getCliente().equals(this.getCliente());
    }
    
      public GestaoCliente clone(){
        return new GestaoCliente(this);
    }

    public String toString(){
        return "Os Clientes são: \n" + this.getCliente();
    }
    
    
    //adiciona cliente
    
    public void addCliente(Cliente a){
        this.clientes.put(a.getEmail(),a.clone());
    }
    
    // verifica se o cliente com e email e existe
    public boolean verifica(String e){
        return(clientes.containsKey(e));
    }
    
    // confirma login
    
     public boolean login(String email, String password){
        if((this.verifica(email)) == false) return false;

        if ((this.getCliente().get(email).getPassword().equals(password) == true) && (this.getCliente().get(email) instanceof Cliente)) return true;

        else return false;
    }
    
    
    // busca cliente com respetivo mail
     public Cliente buscaCliente(String mail){
        return this.clientes.get(mail).clone();
    }
    
    //metodos para atualizar listas de encomendas entregues
     public void atualizaCLE(RealizadaEmpresa r, String mail) {((this.clientes.get(mail))).atualizaLE(r);}
     
     public void atualizaCLV(RealizadaVoluntario r, String mail) {((this.clientes.get(mail))).atualizaLV(r);}
     
    
     
   
}
