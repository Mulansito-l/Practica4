import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    private ArrayList<Carta> BarajaConCartas;
    public Baraja(){
        BarajaConCartas=new ArrayList<Carta>();
        llenarBaraja(); //para que se llene en cuanto se crea una baraja
    }
    public void llenarBaraja() {
        String paloTemp="Oros";
        for (int i = 0; i < 3; i++) { //tipo de carta
            paloTemp = switch (i) {
                case 0 -> "Espadas";
                case 1 -> "Copas";
                case 2 -> "Bastos";
                default -> paloTemp;
            };
            for (int j=1;j<13;j++){ //las cartas de la baraja española van del 1 al 12
                BarajaConCartas.add(new Carta(j,paloTemp));
            }
        }
    }
    public Carta getCarta(int posicionDeCarta){
        return BarajaConCartas.get(posicionDeCarta);
    }

    public ArrayList<Carta> getCartasDeLaBaraja(int cantidadASacar) {
        ArrayList<Carta> cartasSacadas = new ArrayList<>();

        //solo saca cartas si existe esa cantidad disponible
        if ( cantidadASacar <= getSizeBaraja() ) {
            //las agrega a un array que voy a regresar con las cartas sacadas
            for (int i=0; i<cantidadASacar; i++) {
                cartasSacadas.add(BarajaConCartas.remove(0));
            }
        } else {
            System.out.println("No hay suficientes cartas en la baraja.");
            return null;
        }

        return cartasSacadas;
    }

    public void sacarCartaDeLaBaraja(){
        BarajaConCartas.remove(0);
    }

    public int getSizeBaraja(){
        return BarajaConCartas.size();
    }

    public void barajear(){
        Collections.shuffle(BarajaConCartas);
    }
}
