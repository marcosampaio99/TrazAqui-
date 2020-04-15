
/**
 * Escreva a descrição da classe Empresa aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Empresa extends Utilizador
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int raiogeografico;
    private int velocidade;
    private int rating;
    private int taxa; // em percentagem
    private int multitasking;//1 se fizer mais do q 1 entrega ao mesmo tempo 0 se nao
    private int indicador; //1 se estiver disposto a recolher 0 se nao
    private int capacidade; // quantas encomendas conseguem tratar ao mm tempo 
    // lista de entregas efetuadas;

    /**
     * COnstrutor para objetos da classe Empresa
     */
    public Empresa()
    {
        // inicializa variáveis de instância
        super();
        this.raiogeografico=0;
        this.velocidade=0;
        this.rating=0;
        this.taxa=0;
        this.multitasking=0;
        this.indicador=1;
        this.capacidade=1;
    }

    public Empresa(Empresa e){
        super(e);
        this.raiogeografico=e.getRaiogeografico();
        this.velocidade=e.getVelocidade();
        this.rating=e.getRating();
        this.taxa=e.getTaxa();
        this.multitasking=e.getMulti();
        this.indicador=e.getIndicador();
        this.capacidade=e.getCapacidade();
    }
    
    public Empresa(String nome,String email,String password,Localizacao localizacao, int raiogeografico, int velocidade, int rating, int taxa,int multitasking, int indicador, int capacidade){
        super(nome,email,password,localizacao);
        this.raiogeografico=raiogeografico;
        this.velocidade=velocidade;
        this.rating=rating;
        this.taxa=taxa;
        this.multitasking=multitasking;
        this.indicador=indicador;
        this.capacidade=capacidade;
    }
    
    
    // getters 
    
    public int getRaiogeografico(){
        return this.raiogeografico;
    }
    
    public int getVelocidade(){
        return this.velocidade;
    }
    
    public int getRating(){
        return this.rating;
    }
    
    public int getTaxa(){
        return this.taxa;
    }
    

    public int getMulti(){
        return this.multitasking;
    }
    
    
    public int getIndicador(){
        return this.indicador;
    }
    
    
    public int getCapacidade(){
        return this.capacidade;
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
    
     public void setTaxa(){
        this.taxa=taxa;
    }
    

     public void setMulti(){
        this.multitasking=multitasking;
    }
    
    public void setIndicador(){
    this.indicador=indicador;
    }
    
     public void setCapacidade(){
        this.capacidade=capacidade;
    }
    
    public boolean equals (Object o){
        if(this==o) return true;
        
        if((o==null) || (this.getClass()!=o.getClass())) return false;
        
        Empresa e = (Empresa) o;
        return(super.equals(e)&&this.raiogeografico==e.getRaiogeografico())
            &&(this.velocidade==e.getVelocidade())
            &&(this.rating==e.getRating())&&(this.taxa==e.getTaxa())
            &&(this.multitasking==e.getMulti()&&(this.indicador==e.getIndicador())
            &&(this.capacidade==e.getCapacidade()));
            
    }
    
    public String toString() {
        String s = new String();
 
        s = ("Empresa: \n" + 
               "Nome: " + this.getNome() + "\n" + 
               "Password: " + this.getPassword() + "\n" +
               "Email: " + this.getEmail() + "\n"+
               "Raio Geografico(m): " + this.getRaiogeografico() + "\n" +
               "Velocidade média (m/s): " + this.velocidade +"\n" +
               "Rating: " + this.rating + "\n" +
               "Multitasking(Sim:1/Não:0): " + this.multitasking + "\n" +
               "Disponível(Sim:1/Não:0): " + this.indicador + "\n" +
               "Pedidos disponíveis ao mesmo tempo: " + this.capacidade +  "\n" +
               "Localizacao: "+ this.getLocalizacao() + "\n") + "\n";
 
        return s;
    }
    
    
    public Empresa clone() {
        return new Empresa(this);
    }
    
}
