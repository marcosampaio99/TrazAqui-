import static java.lang.Math.abs;


public class Localizacao {

    //VARIÁVEIS DE INSTANCIA
    private double x, y;

    //CONSTRUTORES USUAIS
    public Localizacao (double cx, double cy) { x = cx; y = cy; }

    public Localizacao () {
        this(0.0, 0.0); }

    public Localizacao (Localizacao l) { 
        x = l.getX();
        y = l.getY(); }

    //MÉTODOS DA INSTÂNCIA
    public double getX() { return x; } 

    public double getY() { return y; }

    //INCREMENTOS DAS COORDENADAS
    public void incCoord (double dx, double dy) {
        x += dx;
        y += dy;
    } 

    //DECREMENTO DAS COORDENADAS
    public void decCoord (double dx, double dy) {
        x -= dx;
        y -= dy;
    } 

    //SOMA OS VALORES DE UM PARAMETRO E DEVOLVE UM NOVO PONTO
    public Localizacao somaPonto (double dx, double dy) {
        return new Localizacao (x + dx, y + dy);
    }

    //VERIFICA SE OS DOIS PONTOS SÃO SIMÉTRICOS (SE OS EIXOS XX DISTAM O MESMO DOS EIXOS YY)
    public boolean simetrico () {
        return abs(x) == abs(y);
    }

    //VERIFICA SE AS COORDENADAS SÃO POSITIVAS
    public boolean coordPos () {
        return x > 0 && y > 0;
    }
    
    //VERIFICA SE DOIS PONTOS SÃO IGUAIS
    public boolean equals (Object o) {
       if (this == o) return true;
       
       if ((o == null) || (this.getClass() != o.getClass())) return false;
       
       Localizacao aux = (Localizacao) o;
       return (this.x == aux.getX() && this.y == aux.getY());
   }

    //CONVERTE PARA REPRESENTAÇÃO TEXTUAL
    public String toString () {
        return new String ("Localizacao = " + x + ", " + y);
    }

    //CRIA UMA COPIA DO PONTO RECEPTOR (RECEPTOR = this)
    public Localizacao clone () {
        return new Localizacao (this);
    }
}