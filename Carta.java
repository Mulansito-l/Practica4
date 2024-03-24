public class Carta {
    private int valor;
    private String palo;
    private boolean esVisible;

    public Carta(int valor, String palo){
        esVisible=true;
        this.valor=valor;
        this.palo=palo;
    }
    public String toString() {
        if (!esVisible) {
            return "[     ]";
        }
        return valor + " de " + palo;

    }
}
