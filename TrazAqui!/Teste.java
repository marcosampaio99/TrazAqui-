import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Date;
import java.util.ArrayList;

public class Teste{
    public static void main(String [] args) {
        Localizacao localizacao1= new Localizacao(0.0,0.0);
      
        Date d1 =new Date(12020,04,14);
        Voluntario voluntario1= new Voluntario("Vasquinho","v1@mail.com","123456",localizacao1,5000,50,0);
        Voluntario voluntario2= new Voluntario("Marcelo","v2@mail.com","123456",localizacao1,42000,30,0);
        Cliente cliente1 = new Cliente("Pablito","u1@mail.com","123456",localizacao1);
        Cliente cliente2 = new Cliente("Carol","u2@mail.com","123456",localizacao1);
        Loja l1 =new Loja("MaggieStore","l1@mail.com","123456",localizacao1,0);
        Loja l2 =new Loja("Loja do Marcelo","l2@mail.com","123456",localizacao1,0);

        ServicoVoluntario sv1 =new ServicoVoluntario(0,l1,voluntario1,d1);
        
        /*
        LinhaEncomenda lE1 = new LinhaEncomenda("19289","Pao",23.4,5.2);
        LinhaEncomenda lE2 = new LinhaEncomenda("21388 ","Oculos",10.0,2.12);
        LinhaEncomenda lE3 = new LinhaEncomenda("82672 ","Patins ",13.32,3.3);
        LinhaEncomenda lE4 = new LinhaEncomenda("42346 ","Desinfetante",57.0,7);
        LinhaEncomenda lE5 = new LinhaEncomenda("19289","Nutella",18.3,10.30);
        
        ArrayList <LinhaEncomenda> linha1 =new ArrayList <LinhaEncomenda>();
        linha1.add(lE1);
        linha1.add(lE2);
        linha1.add(lE3);
        linha1.add(lE4);
        linha1.add(lE5);
        
        Encomenda e = new Encomenda("Pedido 420",cliente1,l2,32.2,false,linha1);
        
        */
       

      
      GestaoCliente g1 = new GestaoCliente();
      /*Adding elements to HashMap*/
      g1.addCliente(cliente1);
      g1.addCliente(cliente2);
      
      GestaoVoluntario g2=new GestaoVoluntario();
      /*Adding elements to HashMap*/
      g2.addVoluntario(voluntario1);
      g2.addVoluntario(voluntario2);
      
      GestaoEmpresa g3=new GestaoEmpresa();
      /*Adding elements to HashMap*/
      //g3.addEmpresa(empresa1);
      //g3.addEmpresa(empresa2);
     
      GestaoLojas g4=new GestaoLojas();
      /*Adding elements to HashMap*/
      g4.addLoja(l1);
      g4.addLoja(l2);
  
     String cenas ="Encomenda:e8727,u38,l49,41.09162,p53,Batata,1.4474236,10.431012,p79,Carne seca,9.521179,45.27606,p27,Molho de tomate,8.040819,2.426373,p31,Bolacha,4.0522575,16.42913,p33,Farofa pronta,1.9105971,14.008053,p49,Leite condensado,7.117867,27.154621,p47,Leite em po,3.6804001,23.394846,p37,Sardinha,5.3920026,24.702688,p56,Beterraba,8.950539,34.005764,p24,Feijao 2kg,6.078167,41.797157,p57,Mandioca,1.965017,42.854218,p2,Sabao em po,4.8242617,42.14456,p69,Queijo,1.1860487,14.57901,p64,Mamao,3.2615314,18.684984";

     // System.out.println(voluntario1);
       //System.out.println(empresa1);
       //System.out.println(empresa2);
       // System.out.println(g1);
       
       //System.out.println(s1);
       
      Parser p = new Parser();
      p.parse();
    
}

    }
