

public class Voluntario extends Utilizador
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private double raiogeografico;
    private int velocidade;
    private double rating;
    private int nmrClassificacoes;
    private int verificador;
    //lista das entregas efetuadas
    

    /**
     * COnstrutor para objetos da classe Utilizador
     */
    public Voluntario()
    {
     super();
     this.raiogeografico=0;
     this.velocidade=0;
     this.rating=0.0;
     this.nmrClassificacoes=0;
     this.verificador=0; // 1 se o voluntario estiver ocupado; 0 cc
     //lista de entregas
    }

    
      public Voluntario(Voluntario v) {
        super(v);
        this.raiogeografico=v.getRaiogeografico();
        this.velocidade=v.getVelocidade();
        this.rating=v.getRating();
        this.nmrClassificacoes=v.getnmrClassificacoes();
        this.verificador=v.getVerificador();
        
    }  
    
    
    public Voluntario(String nome,String email,String password,Localizacao localizacao, double raiogeografico, int velocidade, double rating,int nmrClassificacoes,int verificador){
        super(nome,email,password,localizacao);
        this.raiogeografico=raiogeografico;
        this.velocidade=velocidade;
        this.rating=rating;
        this.nmrClassificacoes=nmrClassificacoes;
        this.verificador=verificador;
        

}
 


// getters


    public double getRaiogeografico(){
        return this.raiogeografico;
    }
    
    public int getVelocidade(){
        return this.velocidade;
    }
    
    public double getRating(){
        return this.rating;
    }
    
    public int getnmrClassificacoes() {
        return this.nmrClassificacoes;
    }
    
    public int getVerificador(){
        return this.verificador;
    }
    
    // setters 
    

    public void setRaiogeografico(){
        this.raiogeografico=raiogeografico;
    }
    
    public void setVelocidade(){
        this.velocidade=velocidade;
    }
    
    public void setRating(){
        this.rating=rating;
    }
    
    public void setnmrClassificacoes(int nmrClassificacoes){
        this.nmrClassificacoes=nmrClassificacoes;
    }
    
    public void setVerificador(){
        this.verificador=verificador;
    }
    
    
    
    public boolean equals (Object o){
        if(this==o) return true;
        
        if((o==null) || (this.getClass()!=o.getClass())) return false;
        
        Voluntario u = (Voluntario) o;
        return(super.equals(u)&&this.raiogeografico==u.getRaiogeografico()) && (this.velocidade==u.getVelocidade())
            &&(this.rating==u.getRating())&& (this.nmrClassificacoes==u.getnmrClassificacoes()) && (this.verificador==u.getVerificador());
            
    }
    
    public String toString() {
        String s = new String();
 
        s = ("Voluntário: \n" + 
               "Nome: " + this.getNome() + "\n" + 
              // "Password: " + this.getPassword() + "\n" +
               "Email: " + this.getEmail() + "\n"+
               "Raio Geografico: " + this.getRaiogeografico() + "\n" +
               "Velocidade média (m/s): " + this.velocidade +"\n" +
               "Rating: " + this.rating + "\n" +
               "Nr de Classificações: " + this.nmrClassificacoes + "\n" + 
               "Verificador: " + this.verificador + "\n"+
               "Localizacao: "+ this.getLocalizacao() + "\n") + "\n";
             
 
        return s;
    }
    
    
    public Voluntario clone() {
        return new Voluntario(this);
    }
}

