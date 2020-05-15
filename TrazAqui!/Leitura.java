   // FICHEIRO QUE LÊ DE UM DOCUMENTO E GUARDA NA GESTAOCLIENTES GESTAOLOJAS GESTAOEMPRESAS 

import java.util.List;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.Object;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.util.Date;
import java.util.*;
import java.io.*;


public class Leitura implements Serializable {
    
    GestaoCliente gc =new GestaoCliente();
    GestaoVoluntario gv = new GestaoVoluntario();
    GestaoEmpresa ge = new GestaoEmpresa();
    GestaoLojas gl = new GestaoLojas();
    GestaoEncomenda ges = new GestaoEncomenda();
    
  public void ler(){
      
      List<String> linhas = lerFicheiro("LogsGerados.txt"); //alterar nome do ficheiro
        String[] linhaPartida;
        for (String linha : linhas) {
                linhaPartida = linha.split(":", 2);
                switch(linhaPartida[0]){
               case "Utilizador": 
                       Cliente  c = lerCliente(linhaPartida[1]); // criar um Utilizador
                        gc.addCliente(c); 
                     //  System.out.println(c.toString()); //enviar para o ecrÃ¡n apenas para teste
                        break;
               case "Loja": 
                     Loja l = lerLoja(linhaPartida[1]);
                      gl.addLoja(l);
                   //  System.out.println(l.toString());
                      break;

               case "Voluntario":
                      Voluntario v=lerVoluntario(linhaPartida[1]);
                       gv.addVoluntario(v);
                 //   System.out.println(v.toString());
                        break;
               case "Transportadora":
                      Empresa e =lerEmpresa(linhaPartida[1]);
                       ge.addEmpresa(e);
                  ///      System.out.println(e.toString());
                        break;
               case "Encomenda":
                    Encomenda en=lerEncomenda(linhaPartida[1]);
                      ges.addEncomenda(en);
                  //   System.out.println(en.toString());
                    break;
               case "Aceite":
                    RealizadaEmpresa enc=lerAceite(linhaPartida[1]);
                    ges.addEncomenda(enc);
               default:
                      System.out.println("Linha inválida.");
                       break;
}
  
}
 System.out.println("done!"); 
}                     
  
  public Cliente lerCliente(String input){
        String[] campos = input.split(",");
        String nome = campos[1]; 
        String email = (campos[0])+"@mail.com";
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        Localizacao l1 =new Localizacao(gpsx,gpsy);
        List<RealizadaEmpresa> re = new ArrayList<RealizadaEmpresa>();
        List<RealizadaVoluntario> rv = new ArrayList<RealizadaVoluntario>();
        
        return new Cliente(email,nome,"passdefault",l1,re,rv);
  }
  
  public Voluntario lerVoluntario(String input){
     String[] campos = input.split(",");
        String nome = campos[1]; 
        String email = (campos[0])+"@mail.com";
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        Localizacao l1 =new Localizacao(gpsx,gpsy);
        double raio = Double.parseDouble(campos[4]);
        List<RealizadaVoluntario> rv = new ArrayList<RealizadaVoluntario>();
        
        return new Voluntario(email,nome,"passdefault",l1,raio,0,0.0,0,0,rv);
    }
    
    public Loja lerLoja(String input){
        String[] campos = input.split(",");
        String email = campos[0]+"@mail.com";
        String nome = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        Localizacao l1 =new Localizacao(gpsx,gpsy);
        return new Loja(email,nome,"passdefault",l1,0.0);
    }
    
    public Encomenda lerEncomenda(String input){  
      String[] campos = input.split(",");
      String id = campos[0];
      String emailC = campos[1]+"@mail.com";
      Cliente c = gc.buscaCliente(emailC);
      String emailL = campos[2]+"@mail.com";
      Loja l = gl.buscaLoja(emailL);
      double peso = Double.parseDouble(campos[3]);
      Date data = new Date();
      //fazer ciclo for para ler uma linha de encomenda de cada vez
      String[] novos=input.split(",",5);
      String[] finalissima=novos[4].split(",");
      ArrayList <LinhaEncomenda> li =new ArrayList <>();
      for(int i = 0; i<finalissima.length;i+=4){
      String referencia=finalissima[i];
      String descricao=finalissima[i+1];
      double preco=Double.parseDouble(finalissima[i+2]);
      double quantidade =Double.parseDouble(finalissima[i+3]);
      LinhaEncomenda len =new LinhaEncomenda(referencia,descricao,preco,quantidade);
      li.add(len);

    }
       return new Encomenda(id,c,l,peso,false,data,false,false,li);
    }
    
  public LinhaEncomenda leproduto(String input){
      String[] campos = input.split(",");
      String referencia=campos[0];
      String descricao=campos[1];
      double preco=Double.parseDouble(campos[2]);
      double quantidade =Double.parseDouble(campos[3]);
      return new LinhaEncomenda(referencia,descricao,preco,quantidade);
    }
    
  public Empresa lerEmpresa(String input){
      String[] campos = input.split(",");
      String nome = campos[1];
      String email = campos[0]+"@mail.com";
      double gpsx = Double.parseDouble(campos[2]);
      double gpsy = Double.parseDouble(campos[3]);
      Localizacao l1 =new Localizacao(gpsx,gpsy);
      int nif = Integer.valueOf(campos[4]);
      double raio = Double.parseDouble(campos[5]);
      double taxa = Double.parseDouble(campos[6]);
      List<RealizadaEmpresa> re = new ArrayList<RealizadaEmpresa>();
      return new Empresa(email,nome,"passdefault",l1,nif,raio,0,0.0,0,taxa,0,0,0,re);
    }
    
  public RealizadaEmpresa lerAceite(String input){
      String id=input;
      Encomenda temp= new Encomenda (this.ges.buscaEncomenda(id));
      temp.setRespostaCliente(true);
      temp.setFlagLojaPronta(true);
      Empresa aux=ge.getEmpresa().get("t31@mail.com");
      Date data= new Date();
      return new RealizadaEmpresa(temp.getId(),temp.getCliente(),temp.getLoja(),temp.getPeso(),temp.getState(),temp.getData(),temp.getRespostaCliente(),temp.getFlagLojaPronta(),temp.getLinhas(),aux,-1,data,-1,false,-1);
      
    }
    
  public List<String> lerFicheiro(String nomeFich) {
        List<String> lines = new ArrayList<>();
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { System.out.println(exc.getMessage()); }
        return lines;
  }
  
 
  public String showGestaoCliente(){
      return gc.toString();
    }
    
  public String showGestaoVoluntario(){
      return gv.toString();
  }
  
  public String showGestaoEmpresa(){
      return ge.toString();
}

public List<Cliente> listagemClientes(){
       ArrayList<Cliente> list = new ArrayList<Cliente>(this.gc.getCliente().values());
       return list;
    }

public List<Empresa> listagemEmpresas(){
       ArrayList<Empresa> list = new ArrayList<Empresa>(this.ge.getEmpresa().values());
       return list;
    }
    
public List<Loja> listagemLojas(){
       ArrayList<Loja> list = new ArrayList<Loja>(this.gl.getLoja().values());
       return list;
    }
    
public List<Voluntario> listagemVoluntarios(){
       ArrayList<Voluntario> list = new ArrayList<Voluntario>(this.gv.getVoluntario().values());
       return list;
    }

public List<Encomenda> listagemEncomendas(){
       ArrayList<Encomenda> list = new ArrayList<Encomenda>(this.ges.getEncomenda().values());
       return list;
    }    
    

    
}
