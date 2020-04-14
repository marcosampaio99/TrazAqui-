public class Teste{
    public static void main(String [] args) {
        Localizacao localizacao1= new Localizacao(0.0,0.0);
       
        Voluntario voluntario1= new Voluntario("Vasquinho","v1@mail.com","123456",localizacao1,5000,50,0);
        Cliente cliente1 = new Cliente("Pablito","u1@mail.com","123456",localizacao1);
        Empresa empresa1 = new Empresa("Ideia Fixe","e1@mail.com","1234",localizacao1,5000,60,0,3,0,1,1);
        Empresa empresa2 = new Empresa("Ideia Má","e2@mail.com","12345",localizacao1,15000,55,0,4,1,1,30);
        System.out.println(cliente1);
        System.out.println(voluntario1);
        System.out.println(empresa1);
        System.out.println(empresa2);
    }
}
