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




public class Parser {
	
    GestaoCliente gc =new GestaoCliente();
    GestaoVoluntario gv = new GestaoVoluntario();
    GestaoEmpresa ge = new GestaoEmpresa();
  	
  public void parse(){
      
      List<String> linhas = lerFicheiro("LogsGerados.txt"); //alterar nome do ficheiro
        String[] linhaPartida;
        for (String linha : linhas) {
                linhaPartida = linha.split(":", 2);
                switch(linhaPartida[0]){
               case "Utilizador": 
                        Cliente  c = lerCliente(linhaPartida[1]); // criar um Utilizador
                        gc.addCliente(c); 
                        //System.out.println(c.toString()); //enviar para o ecrÃ¡n apenas para teste
                        break;
              //  case "Loja": 
                 //       Loja l = parseLoja(linhaPartida[1]);
                  //      System.out.println(l.toString());
                 //       break;                                   
                //...
               case "Voluntario":
                        Voluntario v=lerVoluntario(linhaPartida[1]);
                        gv.addVoluntario(v);
                        break;
               case "Transportadora":
                        Empresa e =lerEmpresa(linhaPartida[1]);
                        ge.addEmpresa(e);
               default: 
                     //  System.out.println("Linha inválida.");
                       break;
            //    }

     //   }
      
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
        
        
        return new Voluntario(nome,email,"passdefault",l1,raio,0,0);
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
       
      return new Empresa(nome,email,"passdefault",l1,nif,raio,0,0,taxa,0,0,0);
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