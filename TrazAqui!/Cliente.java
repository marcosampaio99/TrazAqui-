
/**
 * Escreva a descrição da classe Cliente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Cliente extends Utilizador
{
   public Cliente(){
       super();
    }
    
    public  Cliente(Cliente c){
        super(c);
    }
    
    public Cliente(String nome,String email,String password,Localizacao localizacao){
    super(nome,email,password,localizacao);
}
    
public boolean equals (Object o){
        if(this==o) return true;
        
        if((o==null) || (this.getClass()!=o.getClass())) return false;
        
        Cliente c = (Cliente) o;
        return(super.equals(c));
    }
   
    
    public String toString() {
        String s = new String();
 
        s = ("Cliente: \n" + 
               "Nome: " + this.getNome() + "\n" + 
               "Password: " + this.getPassword() + "\n" +
               "Email: " + this.getEmail() + "\n");
               System.out.println(this.getLocalizacao());
 
        return s;
    }
    
    
    public Cliente clone() {
        return new Cliente(this);
    }
    
}
