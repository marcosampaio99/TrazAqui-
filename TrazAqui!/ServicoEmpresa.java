import java.util.Date;


public class ServicoEmpresa
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int id;
    // encomenda
    //loja
    private Empresa empresa;
    private Date data;
    private int custo;
    

    /**
     * COnstrutor para objetos da classe ServicoEmpresa
     */
    public ServicoEmpresa()
    {
       this.id=0;
       this.empresa = new Empresa();
       this.data=null;
       this.custo=0;
    }

    public ServicoEmpresa(int id, Empresa e,Date data, int c){
        this.id=id;
        this.empresa=e;
        this.data=data;
        this.custo=c;

    }
    
    public ServicoEmpresa(ServicoEmpresa s){
        this.id=s.getId();
        this.empresa=s.getEmpresa();
        this.data=s.getData();
        this.custo=s.getCusto();
    }
    
    public int getId(){
        return this.id;
    }
    public Empresa getEmpresa(){
    return this.empresa;
    }
    public Date getData(){
        return this.data;
    }
    public int getCusto(){
        return this.custo;
    }
    
    public void setId(int id){
    this.id=id;
    }
    public void setEmpresa(Empresa e){
    this.empresa=e;
    }
    public void setData(Date d){
    this.data=d;
    }
    public void setCusto(int c){
        this.custo=c;
    }
    
    public boolean equals(Object o){
    if(this==o) return true;
    if(o==null||this.getClass()!=o.getClass())return false;
    ServicoEmpresa se=(ServicoEmpresa) o;
    return this.id==se.id &&
           this.getEmpresa().equals(se.getEmpresa()) &&
           this.getData().equals(se.getData()) &&
           this.custo==se.custo;
          }
          
     public ServicoEmpresa clone(){
         return new ServicoEmpresa(this);
        }
        
        
        public String toString(){
            return"Pedido:  \n"+
            "Id: " +this.id + "\n" +
            "Encomenda: " + "\n" +
            "Loja: "+  "\n" +
            "Empresa: " + this.empresa.getNome() + "\n" +
            "Data: " + this.data.toString() + "\n" +
            "Custo: " + this.custo;
        }
}
