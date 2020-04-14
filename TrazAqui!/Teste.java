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
        Cliente cliente1 = new Cliente("Pablito","u1@mail.com","123456",localizacao1);
        Cliente cliente2 = new Cliente("Carol","u2@mail.com","123456",localizacao1);
        Empresa empresa1 = new Empresa("Entregas ao Domicilio","e1@mail.com","1234",localizacao1,5000,60,0,3,0,1,1);
        Empresa empresa2 = new Empresa("NósLevamos","e2@mail.com","12345",localizacao1,15000,55,0,4,1,1,30);
        ServicoEmpresa s1 = new ServicoEmpresa(0,empresa1,d1,100);
      
      GestaoCliente g1 = new GestaoCliente();
      /*Adding elements to HashMap*/
      g1.addCliente(cliente1);
      g1.addCliente(cliente2);
      
      
       // System.out.println(voluntario1);
        //System.out.println(empresa1);
        //System.out.println(empresa2);
       // System.out.println(g1);
       
       System.out.println(s1);
    }
}
