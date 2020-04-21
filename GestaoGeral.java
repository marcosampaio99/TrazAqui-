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
  
  //construtores
  public GestaoGeral(){
      this.clientes= new GestaoCliente();
      this.empresas= new GestaoEmpresa();
      this.voluntarios= new GestaoVoluntario();
      this.lojas= new GestaoLojas();
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
    
  //metodos para registar utilizadores
  public void registaCliente(String emailAux, String nomeAux, String passwordAux,Localizacao localizacaoAux) throws GestaoGeralException{
       if (clientes.verifica(emailAux)) throw new GestaoGeralException(emailAux);
       else {
            Cliente c_aux = new Cliente(emailAux, nomeAux, passwordAux, localizacaoAux);
            this.clientes.addCliente(c_aux);
        }
    }
  
  public void registaEmpresa(String emailAux, String nomeAux, String passwordAux,Localizacao localizacaoAux,int nifAux,double raiogeograficoAux,int velocidadeAux,double ratingAux,int nmrClassificacoesAux,double taxaAux,int multitaskingAux,int indicadorAux,int capacidadeAux) throws GestaoGeralException{
       if (empresas.verifica(emailAux)) throw new GestaoGeralException(emailAux);
       else {
            Empresa e_aux = new Empresa(emailAux, nomeAux, passwordAux, localizacaoAux,nifAux,raiogeograficoAux,velocidadeAux,ratingAux,nmrClassificacoesAux,taxaAux,multitaskingAux,indicadorAux,capacidadeAux);
            this.empresas.addEmpresa(e_aux);
        }
    }
  
  public void registaVoluntario(String emailAux, String nomeAux, String passwordAux,Localizacao localizacaoAux,double raiogeograficoAux,int velocidadeAux,double ratingAux,int nmrClassificacoesAux,int verificadorAux) throws GestaoGeralException{
      if (voluntarios.verifica(emailAux)) throw new GestaoGeralException(emailAux);
       else {
            Voluntario v_aux = new Voluntario(emailAux,nomeAux, passwordAux, localizacaoAux,raiogeograficoAux,velocidadeAux,ratingAux,nmrClassificacoesAux,verificadorAux);
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
}
