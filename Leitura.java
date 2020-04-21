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


public class Leitura {
	
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
        
        return new Cliente(nome,email,"passdefault",l1);
  }
  
  public Voluntario lerVoluntario(String input){
     String[] campos = input.split(",");
        String nome = campos[1]; 
        String email = (campos[0])+"@mail.com";
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        Localizacao l1 =new Localizacao(gpsx,gpsy);
        double raio = Double.parseDouble(campos[4]);
        
        
        return new Voluntario(nome,email,"passdefault",l1,raio,0,0.0,0,0);
    }
    
    public Loja lerLoja(String input){
        String[] campos = input.split(",");
        String email = campos[0]+"@mail.com";
        String nome = campos[1];
        double gpsx = Double.parseDouble(campos[2]);
        double gpsy = Double.parseDouble(campos[3]);
        Localizacao l1 =new Localizacao(gpsx,gpsy);
        return new Loja(nome,email,"passdefault",l1,0.0);
    }
    
    public Encomenda lerEncomenda(String input){  
      String[] campos = input.split(",");
      String id = campos[0];
      String emailC = campos[1]+"@mail.com";
      Cliente c = gc.buscaCliente(emailC);
      //Cliente c =new Cliente ();
     String emailL = campos[2]+"@mail.com";
     //Loja l = new Loja();
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
       return new Encomenda(id,c,l,peso,false,data,li);
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
       
      return new Empresa(nome,email,"passdefault",l1,nif,raio,0,0.0,0,taxa,0,0,0);
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
}