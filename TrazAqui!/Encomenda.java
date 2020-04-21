import java.util.ArrayList;

public class Encomenda
{
    String id;
    private Cliente cliente;
    private Loja loja;
    public double peso;
    private boolean state; // 0 se n for medico 1 se for
    private ArrayList <LinhaEncomenda> linhas;
    
    public Encomenda(){
        this.id = "";
        this.loja= new Loja();
        this.cliente = new Cliente();
        this.peso=0.0;
        this.state= false;
         this. linhas =new ArrayList<>();
    }

    public Encomenda(String idAux, Cliente clienteAux, Loja lojaAux, double pesoAux, boolean stateAux, ArrayList<LinhaEncomenda> l){
        this.id=idAux;
        this.cliente=new Cliente(clienteAux);
        this.loja=new Loja(lojaAux);
        this.peso=pesoAux;
        this.state=stateAux;
         setLinhas (l);
    }

    public Encomenda(Encomenda e){
        this.id=e.getId();
        this.cliente= new Cliente(e.getCliente());
        this.loja= new Loja(e.getLoja());
        this.peso=e.getPeso();
        this.state=e.getState();
        this.linhas = e.getLinhas();
    }


    //getters


    public String getId() {
        return this.id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Loja getLoja() {
        return this.loja;
    }

    public double getPeso() {
        return this.peso;
    }

    public boolean getState() {
        return this.state;
    }
    
   
public ArrayList <LinhaEncomenda> getLinhas(){
        ArrayList <LinhaEncomenda> li =new ArrayList <>(this.linhas.size());
        for(LinhaEncomenda s :this.linhas){
            li.add(s);
        }
        return li;
    }
  
    //setters


    public void setId(String id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setState(boolean state) {
        this.state = state;
    }


   public void setLinhas(ArrayList<LinhaEncomenda> linhas){
         this.linhas =new ArrayList <>(linhas.size());
        for(LinhaEncomenda s :linhas){
            this.linhas.add(s);
        }
    }
    
    //equals


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomenda aux = (Encomenda) o;
        return  this.id == aux.id &&
                this.peso==aux.peso &&
                this.state==aux.state &&          
                this.getCliente().equals(aux.getCliente()) &&
                this.getLoja().equals(aux.getLoja())&&
                this.getLinhas().equals(aux.getLinhas());

    }

    @Override
    public String toString() {
        return "Encomenda: " +
                "id: " + this.id + "\n" +
                "Cliente: " + this.cliente.getNome() + "\n" +
                "Loja: " + this.loja.getNome() + "\n" +
                "Peso: " + this.peso + "\n" +
                "Produtos " + this.linhas.toString();

    }
    
    
     public Encomenda clone(){
        return new Encomenda(this);
    }
}

