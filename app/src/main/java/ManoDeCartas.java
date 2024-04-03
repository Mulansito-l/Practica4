import java.util.ArrayList;

public class ManoDeCartas {
    private ArrayList <Carta> mano;
    public ManoDeCartas(){
        mano =new ArrayList<Carta>();
    }
    public void agregarCartaAMano(int Posicion, Carta laCarta){
        mano.add(0,laCarta);
    }

    public String toString() {
        String ManoCadena = "";

        for (Carta carta : mano) {
            ManoCadena = ManoCadena + carta;
        }
        return ManoCadena;
    }
    public int getSizeDeMano(){
        int sizeDeMano= mano.size();
        return sizeDeMano;
    }
    public Carta getCartaDeMano(int posicionDeCarta){
        return mano.get(posicionDeCarta);
    }
    public void removerCartaDeMano(int posicionDeCarta) {
        mano.remove(posicionDeCarta);

    }
}
