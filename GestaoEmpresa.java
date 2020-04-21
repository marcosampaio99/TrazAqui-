import java.util.*;

public class GestaoEmpresa
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private HashMap<String,Empresa> empresas;


    public GestaoEmpresa()
    {
       this.empresas=new HashMap();
    }

   public GestaoEmpresa(HashMap<String,Empresa> empresas2){
    this.empresas=new HashMap();
    for(Empresa a:empresas2.values())
        this.empresas.put(a.getEmail(),a.clone());
    }
    
    public GestaoEmpresa(GestaoEmpresa gcs){
        this.empresas=gcs.getEmpresa();
    }
    
    //get
    
    public HashMap<String,Empresa> getEmpresa() {
        HashMap<String,Empresa> aux = new HashMap<>();
        for(Empresa a: this.empresas.values())
            aux.put(a.getEmail(),a.clone());
        return aux;
    }

    public void setEmpresa(HashMap<String,Empresa> empresas) {
        this.empresas = new HashMap<>();
        for(Empresa a : empresas.values())
            this.empresas.put(a.getEmail(),a.clone());
    }
    
    
     public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        GestaoEmpresa aux = (GestaoEmpresa) object;
        return aux.getEmpresa().equals(this.getEmpresa());
    }
    
      public GestaoEmpresa clone(){
        return new GestaoEmpresa(this);
    }

    public String toString(){
        return "As empresas são: \n" + this.getEmpresa();
    }
    
    
    //adiciona empresa
    
    public void addEmpresa(Empresa a){
        this.empresas.put(a.getEmail(),a.clone());
    }
    
    // verifica se a empresa com email e existe
    public boolean verifica(String e){
        return(empresas.containsKey(e));
    }
    
    // confirma login
    
     public boolean login(String email, String password){
        if((this.verifica(email)) == false) return false;
        if ((this.getEmpresa().get(email).getPassword().equals(password) == true) && (this.getEmpresa().get(email) instanceof Empresa)) return true;
        else return false;

    }
    
    
}
