import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Baraja {
    private ArrayList<Carta> BarajaConCartas;
    public Baraja(){
        BarajaConCartas=new ArrayList<Carta>();

    }
    public void llenarBaraja() {
        String paloTemp="Oros";
        for (int i = 0; i < 4; i++) {
            switch (i){
                case 1:
                    paloTemp="Espadas";
                    break;
                case 2:
                    paloTemp="Copas";
                    break;
                case 3:
                    paloTemp="Bastos";
                    break;
                default:
            }
            for (int j=0;j<10;j++){
                BarajaConCartas.add(new Carta(j,paloTemp));
            }
        }
    }
    public Carta getCarta(int posicionDeCarta){
        return BarajaConCartas.get(posicionDeCarta);
    }
    public void sacarCartaDeLaBaraja(){
        BarajaConCartas.remove(0);
    }
    public void barajear(){
        Collections.shuffle(BarajaConCartas);
    }
}
