import java.util.Date;


public class ServicoVoluntario
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int id;
    // encomenda
    //loja
    private Voluntario voluntario;
    private Date data;

    

    /**
     * COnstrutor para objetos da classe ServicoEmpresa
     */
    public ServicoVoluntario()
    {
       this.id=0;
       this.voluntario = new Voluntario();
       this.data=null;
    }

    public ServicoVoluntario(int id, Voluntario e,Date data, int c){
        this.id=id;
        this.voluntario=e;
        this.data=data;
    }
    
    public ServicoVoluntario(ServicoVoluntario s){
        this.id=s.getId();
        this.voluntario=s.getVoluntario();
        this.data=s.getData();

    }
    
    public int getId(){
        return this.id;
    }
    public Voluntario getVoluntario(){
    return this.voluntario;
    }
    public Date getData(){
        return this.data;
    }

    public void setId(int id){
    this.id=id;
    }
    public void setVoluntario(Voluntario e){
    this.voluntario=e;
    }
    public void setData(Date d){
    this.data=d;
    }

    public boolean equals(Object o){
    if(this==o) return true;
    if(o==null||this.getClass()!=o.getClass())return false;
    ServicoVoluntario se=(ServicoVoluntario) o;
    return this.id==se.id &&
           this.getVoluntario().equals(se.getVoluntario()) &&
           this.getData().equals(se.getData());

          }
          
     public ServicoVoluntario clone(){
         return new ServicoVoluntario(this);
        }
        
        
        public String toString(){
            return"Pedido:  \n"+
            "Id: " +this.id + "\n" +
            "Encomenda: " + "\n" +
            "Loja: "+  "\n" +
            "Voluntario: " + this.voluntario.getNome() + "\n" +
            "Data: " + this.data.toString() + "\n" ;

        }
}