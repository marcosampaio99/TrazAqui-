import static java.lang.Math.abs;
import java.lang.Math; 


public class Localizacao {

    //VARIÁVEIS DE INSTANCIA
    private double latitude, longitude;

    //CONSTRUTORES USUAIS
    public Localizacao (double cx, double cy) { latitude = cx; longitude = cy; }

    public Localizacao () {
        this(0.0, 0.0); }

    public Localizacao (Localizacao l) { 
        latitude = l.getX();
        longitude = l.getY(); }

    //MÉTODOS DA INSTÂNCIA
    public double getX() { return latitude; } 

    public double getY() { return longitude; }

    //INCREMENTOS DAS COORDENADAS
    public void incCoord (double dx, double dy) {
        latitude += dx;
        longitude += dy;
    } 

    //DECREMENTO DAS COORDENADAS
    public void decCoord (double dx, double dy) {
        latitude -= dx;
        longitude -= dy;
    } 

    //SOMA OS VALORES DE UM PARAMETRO E DEVOLVE UM NOVO PONTO
    public Localizacao somaPonto (double dx, double dy) {
        return new Localizacao (latitude + dx, longitude + dy);
    }


    //VERIFICA SE DOIS PONTOS SÃO IGUAIS
    public boolean equals (Object o) {
       if (this == o) return true;
       
       if ((o == null) || (this.getClass() != o.getClass())) return false;
       
       Localizacao aux = (Localizacao) o;
       return (this.latitude == aux.getX() && this.longitude == aux.getY());
   }

    //CONVERTE PARA REPRESENTAÇÃO TEXTUAL
    public String toString () {
        return new String ("Localizacao = " + latitude + ", " + longitude);
    }

    //CRIA UMA COPIA DO PONTO RECEPTOR (RECEPTOR = this)
    public Localizacao clone () {
        return new Localizacao (this);
    }
    
    //CALCULA A DISTANCIA EM METROS ENTRE DUAS COORDENAS GEOGRAFICAS
    public static double distance(double lat1, double lat2, double lon1,
        double lon2) {

    final int R = 6371; // Radius of the earth

    double latDistance = Math.toRadians(lat2 - lat1);
    double lonDistance = Math.toRadians(lon2 - lon1);
    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double distance = R * c * 1000; // convert to meters


    distance = Math.pow(distance, 2) + Math.pow(0, 2);

    return Math.sqrt(distance);
}
    
}