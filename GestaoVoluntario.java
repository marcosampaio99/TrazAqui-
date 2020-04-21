import java.util.*;

public class GestaoVoluntario
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private HashMap<String,Voluntario> voluntarios;


    public GestaoVoluntario()
    {
       this.voluntarios=new HashMap();
    }

   public GestaoVoluntario(HashMap<String,Voluntario> voluntarios2){
    this.voluntarios=new HashMap();
    for(Voluntario a:voluntarios2.values())
        this.voluntarios.put(a.getEmail(),a.clone());
    }
    
    public GestaoVoluntario(GestaoVoluntario gcs){
        this.voluntarios=gcs.getVoluntario();
    }
    
    //get
    
    public HashMap<String,Voluntario> getVoluntario() {
        HashMap<String,Voluntario> aux = new HashMap<>();
        for(Voluntario a: this.voluntarios.values())
            aux.put(a.getEmail(),a.clone());
        return aux;
    }

    public void setVoluntario(HashMap<String,Voluntario> voluntarios2) {
        this.voluntarios = new HashMap<>();
        for(Voluntario a : voluntarios2.values())
            this.voluntarios.put(a.getEmail(),a.clone());
    }
    
    
     public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        GestaoVoluntario aux = (GestaoVoluntario) object;
        return aux.getVoluntario().equals(this.getVoluntario());
    }
    
      public GestaoVoluntario clone(){
        return new GestaoVoluntario(this);
    }

    public String toString(){
        return "Os voluntários são: \n" + this.getVoluntario();
    }
    
    
    //adiciona voluntario
    
    public void addVoluntario(Voluntario a){
        this.voluntarios.put(a.getEmail(),a.clone());
    }
    
    // verifica se o voluntario com email e existe
    public boolean verifica(String e){
        return(voluntarios.containsKey(e));
    }
    
    // confirma login
    
     public boolean login(String email, String password){
        if((this.verifica(email)) == false) return false;
        if ((this.getVoluntario().get(email).getPassword().equals(password) == true) && (this.getVoluntario().get(email) instanceof Voluntario)) return true;
        else return false;

    }
    
    
}
