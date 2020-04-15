


public class Loja extends Utilizador {
    //variaveis de instancia
    private double tempoEspera;
    // private qqlmerda filaEspera;

    //construtores

    public Loja(){
        super();
        this.tempoEspera=0;
    }

    public Loja(String nomeAux,String emailAux, String passwordAux, Localizacao localizacaoAux, double tempoEsperaAux){
        super(nomeAux,emailAux,passwordAux,localizacaoAux);
        this.tempoEspera=tempoEsperaAux;
    }

    public Loja(Loja c){
        this(c.getNome(),c.getEmail(),c.getPassword(),c.getLocalizacao(),c.getTempoEspera());
    }

    //getters

    public double getTempoEspera(){
        return this.tempoEspera;
    }

    //setters

    public void setTempoEspera(double tempoEsperaAux){
        this.tempoEspera=tempoEsperaAux;
    }

    //equals
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        if (super.equals(object) == false) return false;
        Loja aux = (Loja) object;
        return (this.getTempoEspera()==aux.getTempoEspera());
    }

    //clone

    public Loja clone(){
        return new Loja(this);
    }

    //toString
    public String toString(){
        return  "Loja: " + "\n" +
                "Nome: " + this.getNome() + "\n" +
                "Email: " + this.getEmail() + "\n" +
                "Password: " + this.getPassword() + "\n" +
                "Localização: " + this.getLocalizacao() + "\n" +
                "Tempo médio de espera: " + this.getTempoEspera() + "\n" ;
    }
}
