public class Teste{
    public static void main(String [] args) {
        Localizacao localizacao1= new Localizacao(0.0,0.0);
        Utilizador utilizador1= new Utilizador("Marco","u1@mail.com","123456",localizacao1);

        System.out.println(utilizador1);
    }
}
