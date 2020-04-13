public class Teste{
    public static void main(String [] args) {
        Localizacao localizacao1= new Localizacao(0.0,0.0);
       
        Voluntario voluntario1= new Voluntario("Vasquinho","v1@mail.com","123456",localizacao1,5000,50,0);
        Cliente cliente1 = new Cliente("Pablito","u1@mail.com","123456",localizacao1);

        System.out.println(cliente1);
        System.out.println(voluntario1);
    }
}
