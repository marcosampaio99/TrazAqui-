import java.util.*;
import java.io.*;
/**
 * Escreva a descrição da classe GestaoGeral aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class GestaoGeral implements Serializable{
  private GestaoCliente clientes;
  private GestaoEmpresa empresas;
  private GestaoVoluntario voluntarios;
  private GestaoLojas lojas;
  private GestaoEncomenda encomendas;
  
  //construtores
  public GestaoGeral(){
      this.clientes= new GestaoCliente();
      this.empresas= new GestaoEmpresa();
      this.voluntarios= new GestaoVoluntario();
      this.lojas= new GestaoLojas();
      this.encomendas= new GestaoEncomenda();
    }
    
  public HashMap<String,Cliente> getClientes(){
      return this.clientes.getCliente();
    }
    
  public HashMap<String,Empresa> getEmpresas(){
      return this.empresas.getEmpresa();
    }
    
  public HashMap<String,Voluntario> getVoluntarios(){
      return this.voluntarios.getVoluntario();
    }
    
  public HashMap<String,Loja> getLojas(){
      return this.lojas.getLoja();
    }
    
  public HashMap<String,Encomenda> getEncomendas(){
      return this.encomendas.getEncomenda();
    }
    
  //metodos para registar utilizadores
  public void registaCliente(String emailAux, String nomeAux, String passwordAux,Localizacao localizacaoAux, List<RealizadaEmpresa> reAux, List<RealizadaVoluntario> rvAux) throws GestaoGeralException{
       if (clientes.verifica(emailAux)) throw new GestaoGeralException(emailAux);
       else {
            Cliente c_aux = new Cliente(emailAux, nomeAux, passwordAux, localizacaoAux,reAux,rvAux);
            this.clientes.addCliente(c_aux);
        }
    }
  
  public void registaEmpresa(String emailAux, String nomeAux, String passwordAux,Localizacao localizacaoAux,int nifAux,double raiogeograficoAux,int velocidadeAux,double ratingAux,int nmrClassificacoesAux,double taxaAux,int multitaskingAux,int indicadorAux,int capacidadeAux, List<RealizadaEmpresa> reAux) throws GestaoGeralException{
       if (empresas.verifica(emailAux)) throw new GestaoGeralException(emailAux);
       else {
            Empresa e_aux = new Empresa(emailAux, nomeAux, passwordAux, localizacaoAux,nifAux,raiogeograficoAux,velocidadeAux,ratingAux,nmrClassificacoesAux,taxaAux,multitaskingAux,indicadorAux,capacidadeAux,reAux);
            this.empresas.addEmpresa(e_aux);
        }
    }
  
  public void registaVoluntario(String emailAux, String nomeAux, String passwordAux,Localizacao localizacaoAux,double raiogeograficoAux,int velocidadeAux,double ratingAux,int nmrClassificacoesAux,int verificadorAux,List<RealizadaVoluntario> rvAux) throws GestaoGeralException{
      if (voluntarios.verifica(emailAux)) throw new GestaoGeralException(emailAux);
       else {
            Voluntario v_aux = new Voluntario(emailAux,nomeAux, passwordAux, localizacaoAux,raiogeograficoAux,velocidadeAux,ratingAux,nmrClassificacoesAux,verificadorAux,rvAux);
            this.voluntarios.addVoluntario(v_aux);
        }
    }
   
  public void registaLoja(String emailAux, String nomeAux, String passwordAux,Localizacao localizacaoAux, double tempoEsperaAux) throws GestaoGeralException{
      if (lojas.verifica(emailAux)) throw new GestaoGeralException(emailAux);
       else {
            Loja l_aux = new Loja(emailAux,nomeAux, passwordAux, localizacaoAux,tempoEsperaAux);
            this.lojas.addLoja(l_aux);
        }
    }
    
  //metodos para login
  public void loginCliente(String emailAux, String passwordAux) throws GestaoGeralException {
        if (clientes.login(emailAux, passwordAux) == false) throw new GestaoGeralException(emailAux);
    }

  public void loginEmpresa(String emailAux, String passwordAux) throws GestaoGeralException {
        if (empresas.login(emailAux, passwordAux) == false) throw new GestaoGeralException(emailAux);
    }
 
  public void loginVoluntario(String emailAux, String passwordAux) throws GestaoGeralException {
        if (voluntarios.login(emailAux, passwordAux) == false) throw new GestaoGeralException(emailAux);
    }  
    
  public void loginLoja(String emailAux, String passwordAux) throws GestaoGeralException {
        if (lojas.login(emailAux, passwordAux) == false) throw new GestaoGeralException(emailAux);
    }
    
   // metodos para adicioanr listas de entidades lidas dos logs � gestao geral 
  public void addListaClientes(List<Cliente> c){
        for (Cliente temp : c) {
        this.clientes.addCliente(temp);
     }
   }
   
   public void addListaEmpresas(List<Empresa> e){
        for (Empresa temp : e) {
        this.empresas.addEmpresa(temp);
     }
   }
   
    public void addListaLojas(List<Loja> l){
        for (Loja temp : l) {
        this.lojas.addLoja(temp);
     }
   }
   
    public void addListaVoluntarios(List<Voluntario> v){
        for (Voluntario temp : v) {
        this.voluntarios.addVoluntario(temp);
     }
   }
   
    public void addListaEncomendas(List<Encomenda> v){
        for (Encomenda temp : v) {
        this.encomendas.addEncomenda(temp);
     }
   }
   //metodos de listagens de entidades presentes no sistema para o admin ver
   public List<Cliente> listagemClientes(){
       ArrayList<Cliente> list = new ArrayList<Cliente>(this.getClientes().values());
       return list;
    }
    
    public List<Empresa> listagemEmpresas(){
       ArrayList<Empresa> list = new ArrayList<Empresa>(this.getEmpresas().values());
       return list;
    }
    
    public List<Voluntario> listagemVoluntarios(){
       ArrayList<Voluntario> list = new ArrayList<Voluntario>(this.getVoluntarios().values());
       return list;
    }
    
    public List<Loja> listagemLojas(){
       ArrayList<Loja> list = new ArrayList<Loja>(this.getLojas().values());
       return list;
    }
    
    public List<Encomenda> listagemEncomendas(){
       ArrayList<Encomenda> list = new ArrayList<Encomenda>(this.getEncomendas().values());
       return list;
    }
    
    public List<RealizadaEmpresa> listagemEncomendasRealizadasEmpresas(){
        ArrayList<RealizadaEmpresa> list = new ArrayList<RealizadaEmpresa>(this.encomendas.getRealizadaEmpresa());
        return list;
    }
    
    public List<RealizadaVoluntario> listagemEncomendasRealizadasVoluntarios(){
        ArrayList<RealizadaVoluntario> list = new ArrayList<RealizadaVoluntario>(this.encomendas.getRealizadaVoluntario());
        return list;
    }
 
   public List<Pronta> listagemPedidos(){

        ArrayList<Encomenda> list = new ArrayList<Encomenda>(this.getEncomendas().values());
        ArrayList<Pronta> list2 = new ArrayList<Pronta>();

        for(Encomenda a : list) {
            if (a instanceof Pronta) list2.add((Pronta) a);
        }

        return list2;
    }
    
    //metodo para o cliente ver os pedidos que tem para responder
    public List<Encomenda> listagemEncomendasProntas(Cliente c) {   
        List<Encomenda> list = new ArrayList<>(this.getEncomendas().values());
        List<Encomenda> r = new ArrayList<>();

        for (Encomenda a : list)
            if(a.getFlagLojaPronta()==true && a.getRespostaCliente()==true && a.getCliente().getEmail().equals(c.getEmail()) ) r.add(a);
    return r;
}

//metodos para dar a listagem de encomendas que clientes podem classificar
    public List<RealizadaEmpresa> listaClassificarEmpresa(Cliente c){
        return this.encomendas.realizadosClassificarClienteEmpresa(c);
    }
    
    public List<RealizadaVoluntario> listaClassificarVoluntario(Cliente c){
        return this.encomendas.realizadosClassificarClienteVoluntario(c);
    }

//metodos para classificar empresa e voluntarios
public void registaClassEmpresa(String idE,double classificacao,Cliente c,Empresa aux) throws GestaoGeralException{
  
        if (this.getEncomendas().get(idE) == null) throw new GestaoGeralException(String.valueOf(idE));
        if (this.getEncomendas().get(idE).getCliente().getEmail().equals(c.getEmail()) == false) throw new GestaoGeralException(String.valueOf(idE));
        if (((RealizadaEmpresa)(this.getEncomendas().get(idE))).getClassificado()==true )throw new GestaoGeralException(String.valueOf(idE));
        else {
            this.encomendas.classificacaoClienteEmpresa(idE,classificacao);
            this.empresas.atualizaClassificacaoEmpresa(classificacao,aux);
        }
    }
    
public void registaClassVoluntario(String idE,double classificacao,Cliente c,Voluntario v) throws GestaoGeralException{

        if (this.getEncomendas().get(idE) == null) throw new GestaoGeralException(String.valueOf(idE));
        if (this.getEncomendas().get(idE).getCliente().getEmail().equals(c.getEmail()) == false) throw new GestaoGeralException(String.valueOf(idE));
        if (((RealizadaVoluntario)(this.getEncomendas().get(idE))).getClassificado()==true )throw new GestaoGeralException(String.valueOf(idE));
        else {
            this.encomendas.classificacaoClienteVoluntario(idE,classificacao);
            this.voluntarios.atualizaClassificacaoVoluntario(classificacao,v);
        }
    }
    /*
    public void AceitaPedido(int idP,Cliente c) throws GestaoGeralException {
        if ((this.getEncomendas().get(idP)) instanceof RealizadaEmpresa) throw new GestaoGeralException(String.valueOf(idP));
        Pronta pd = (Pronta) this.getEncomendas().get(idP);
        if (pd == null) throw new GestaoGeralException(String.valueOf(idP));
        if (pd.getRespostaCliente() != false || pd.getFlagLojaPronta() != false) throw new GestaoGeralException(String.valueOf(idP));
        if (pd.getCliente().getEmail().equals(c.getEmail())==false) throw new GestaoGeralException(String.valueOf(idP));
        else {
            double distanciaViagem=
            double preco =
            Date data = new Date();
            RealizadaEmpresa r = new RealizadaEmpresa();
            this.encomendas.remove(); 
            atualizar listas nos clientes
            atualizar listas nas empresas
            this.encomendas.addRealizadaEmrpesa(r);
         
            
        }

    }*/
}
   
   
    
        

