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




public class Parser {
	
    GestaoCliente gc =new GestaoCliente();
    GestaoVoluntario gv = new GestaoVoluntario();
    GestaoEmpresa ge = new GestaoEmpresa();
    GestaoLojas gl = new GestaoLojas();
  	
  public void parse(){
      
      List<String> linhas = lerFicheiro("LogsGerados.txt"); //alterar nome do ficheiro
        String[] linhaPartida;
        for (String linha : linhas) {
                linhaPartida = linha.split(":", 2);
                switch(linhaPartida[0]){
               case "Utilizador": 
                        Cliente  c = lerCliente(linhaPartida[1]); // criar um Utilizador
                      //  gc.addCliente(c); 
                       System.out.println(c.toString()); //enviar para o ecrÃ¡n apenas para teste
                        break;
               case "Loja": 
                     Loja l = lerLoja(linhaPartida[1]);
                     // gl.addLoja(l);
                     System.out.println(l.toString());
                      break;

               case "Voluntario":
                      Voluntario v=lerVoluntario(linhaPartida[1]);
                     //   gv.addVoluntario(v);
                    System.out.println(v.toString());
                        break;
               case "Transportadora":
                      Empresa e =lerEmpresa(linhaPartida[1]);
                       //  ge.addEmpresa(e);
                        System.out.println(e.toString());
                        break;
               case "Encomenda":
                    Encomenda en=lerEncomenda(linhaPartida[1]);
                     System.out.println(en.toString());
                    break;
               default:
                      System.out.println("Linha inválida.");
                       break;
            //    }

     //   }
      
  
 

}  


 /*
  String e ="Encomenda:e8727,u38,l49,41.09162,p53,Batata,1.4474236,10.431012,p79,Carne seca,9.521179,45.27606,p27,Molho de tomate,8.040819,2.426373,p31,Bolacha,4.0522575,16.42913,p33,Farofa pronta,1.9105971,14.008053,p49,Leite condensado,7.117867,27.154621,p47,Leite em po,3.6804001,23.394846,p37,Sardinha,5.3920026,24.702688,p56,Beterraba,8.950539,34.005764,p24,Feijao 2kg,6.078167,41.797157,p57,Mandioca,1.965017,42.854218,p2,Sabao em po,4.8242617,42.14456,p69,Queijo,1.1860487,14.57901,p64,Mamao,3.2615314,18.684984";
 String e2 ="Encomenda:e4031,u39,l54,95.36606,p70,Queijo Mussarela,6.373054,38.18086";
String e3 ="Encomenda:e8727,u38,l49,41.09162,p53,Batata,1.4474236,10.431012,p79,Carne seca,9.521179,45.27606,p27,Molho de tomate,8.040819,2.426373,p31,Bolacha,4.0522575,16.42913,p33,Farofa pronta,1.9105971,14.008053,p49,Leite condensado,7.117867,27.154621,p47,Leite em po,3.6804001,23.394846,p37,Sardinha,5.3920026,24.702688,p56,Beterraba,8.950539,34.005764,p24,Feijao 2kg,6.078167,41.797157,p57,Mandioca,1.965017,42.854218,p2,Sabao em po,4.8242617,42.14456,p69,Queijo,1.1860487,14.57901,p64,Mamao,3.2615314,18.684984";
String e4 ="Encomenda:e6375,u84,l49,6.2139273,p32,Cafe,9.132824,13.74054,p59,Espinafre,1.4508064,44.19835,p56,Beterraba,8.661924,14.7127,p34,Farinha de trigo,7.477098,38.92308,p73,Margarina,9.49815,31.71706,p45,Milho de pipoca,3.043678,29.597115,p10,Condicionador,8.163296,15.924403,p16,Saco de lixo 30l,4.0755715,37.102093,p62,Uva,7.802194,15.416623,p43,Doce de leite,5.0925236,45.706432,p44,Goiabada,2.1628513,30.538395,p27,Molho de tomate,3.4071698,39.96605,p12,Lustra moveis,4.7767096,41.5397,p75,Presunto,3.8453581,18.077017,p66,Melao,8.785354,19.04204,p69,Queijo,6.8093457,6.4104314,p1,Agua,1.8578846,34.09583";
String e5 ="Encomenda:e1510,u12,l54,52.279247,p28,Sal,3.0932732,18.464052,p79,Carne seca,9.589715,17.873003,p54,Tomate,7.3940916,16.83705,p80,Salsicha,5.994944,21.504892,p32,Cafe,3.4008625,15.759531,p4,Detergente,1.1478498,42.899445,p61,Ovos,4.2847104,14.161885,p17,Saco de lixo 50l,6.7196665,48.03969,p10,Condicionador,8.229609,44.3586,p65,Melancia,1.7759652,28.99424";
String e6 ="Encomenda:e9546,u46,l54,5.4943743,p29,Acucar,2.6570623,42.963676,p31,Bolacha,3.276977,11.31716,p67,Salsa,4.8994374,39.822384,p27,Molho de tomate,5.6262813,20.278988,p23,Arroz 5kg,4.9826293,38.255226,p7,Sabao em pedra,7.9358134,30.592356,p10,Condicionador,2.4749815,37.741398,p9,Shampoo,4.0954623,6.7352533,p53,Batata,2.492299,18.984205,p73,Margarina,5.2601075,49.029945,p31,Bolacha,2.3124044,34.53629,p5,Agua sanitaria,2.7729263,23.073586,p34,Farinha de trigo,8.850653,23.743692,p78,Carne vermelha,2.6086226,19.323761,p68,Cebola,6.883379,24.846563,p56,Beterraba,6.6608934,4.497865,p40,Molho de pimenta,3.473082,1.9490775,p23,Arroz 5kg,8.343342,45.208355";
String e7 ="Encomenda:e6223,u12,l16,43.893562,p61,Ovos,9.187405,20.200512,p68,Cebola,7.475029,35.141876,p62,Uva,6.720556,46.659805,p76,Peixe,8.105425,12.344593,p8,Sabonete,6.2743807,47.675632,p34,Farinha de trigo,7.84933,30.503246,p40,Molho de pimenta,5.8105783,2.1208773,p68,Cebola,7.9545655,19.825962,p63,Abacate,8.024163,48.229782";
String e8 =" Encomenda:e3737,u18,l57,50.45753,p65,Melancia,4.7864256,17.92104,p49,Leite condensado,9.546062,2.029005,p51,Alface,3.4072714,4.8445816,p63,Abacate,1.4112873,1.8343077,p57,Mandioca,8.151962,45.07783";
String e9 =" Encomenda:e9937,u39,l49,84.17667,p50,Pao de forma,1.1615462,18.368095,p34,Farinha de trigo,8.451757,1.5095477,p29,Acucar,9.001441,30.63678,p49,Leite condensado,3.7452714,28.316444,p74,Iogurte,2.0849004,33.321934,p31,Bolacha,4.237378,37.797134,p57,Mandioca,6.7790265,47.54506,p73,Margarina,7.433182,1.0885165,p55,Cenoura,1.9485772,8.810174,p3,Amaciante,5.276676,42.22043,p30,Achocolatado,6.596149,38.74341,p80,Salsicha,4.75922,47.2231,p53,Batata,7.4025097,21.224596,p37,Sardinha,7.0069814,26.033663,p30,Achocolatado,8.832619,4.0813847";
String e10 ="Encomenda:e5682,u80,l54,58.000095,p6,Esponja de aco,7.318613,14.50411,p28,Sal,8.028675,29.289522,p6,Esponja de aco,2.2360332,49.08008,p67,Salsa,1.3296902,17.71481,p19,Sumo garrafa 1l,9.808869,17.360863,p16,Saco de lixo 30l,8.769161,8.5711155,p71,Queijo outros,7.058446,10.213491,p21,Leite integral litro,4.6279693,14.194703,p46,Oleo de cozinha,8.970718,49.54523,p16,Saco de lixo 30l,3.8400564,19.144802,p42,Milho verde,4.8849597,11.838235,p6,Esponja de aco,5.006879,26.660315,p14,Limpa vidros,6.726256,35.3583,p1,Agua,5.5338016,10.270985,p8,Sabonete,7.2344494,10.053995,p53,Batata,8.52187,42.99839,p15,Alcool,1.1807547,14.400469";
String e11="Encomenda:e389,u23,l57,82.44318,p79,Carne seca,4.722663,34.63523";
  Encomenda encome= lerEncomenda(e11);
 System.out.println(encome);
 */
  
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
    
    public Loja lerLoja(String input){
        String[] campos = input.split(",");
        String email = campos[0]+"@mail.com";
        String nome = campos[1];
        Localizacao l1 =new Localizacao(0.0,0.0);
        return new Loja(nome,email,"passdefault",l1,0.0);
    }
    
    public Encomenda lerEncomenda(String input){  
      String[] campos = input.split(",");
      String id = campos[0];
      String emailC = campos[1]+"@mail.com";
     // Cliente c = gc.buscaCliente(emailC);
     Cliente c =new Cliente ();
     String emailL = campos[2]+"@mail.com";
     Loja l = new Loja();
     //Loja l = gl.buscaLoja(emailL);
      double peso = Double.parseDouble(campos[3]);
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
       return new Encomenda(id,c,l,peso,false,li);
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