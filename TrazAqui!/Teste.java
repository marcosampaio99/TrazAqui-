import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Date;

public class Teste{
    public static void main(String [] args) {
        Localizacao localizacao1= new Localizacao(0.0,0.0);
      
        Date d1 =new Date(12020,04,14);
        Voluntario voluntario1= new Voluntario("Vasquinho","v1@mail.com","123456",localizacao1,5000,50,0);
        Voluntario voluntario2= new Voluntario("Marcelo","v2@mail.com","123456",localizacao1,42000,30,0);
        Cliente cliente1 = new Cliente("Pablito","u1@mail.com","123456",localizacao1);
        Cliente cliente2 = new Cliente("Carol","u2@mail.com","123456",localizacao1);
        Loja l1 =new Loja("MaggieStore","l1@mail.com","123456",localizacao1,0);
        Loja l2 =new Loja("Marcels","l2@mail.com","123456",localizacao1,0);

        ServicoVoluntario sv1 =new ServicoVoluntario(0,l1,voluntario1,d1);
        
      
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
      
      
      
       // System.out.println(voluntario1);
       //System.out.println(empresa1);
       //System.out.println(empresa2);
       // System.out.println(g1);
       
       //System.out.println(s1);
       
       Parser p = new Parser();
       p.parse();
       System.out.println(p.showGestaoCliente());
       System.out.println(p.showGestaoVoluntario());
       System.out.println(p.showGestaoEmpresa());
       
    }
}
