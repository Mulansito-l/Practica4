public class Carta {
    private int valor;
    private String palo;
    private boolean esVisible;

    public Carta(int valor, String palo){
        esVisible=true;
        this.valor=valor;
        this.palo=palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public boolean getEsVisible() {
        return esVisible;
    }

    public void setEsVisible(boolean esVisible) {
        this.esVisible = esVisible;
    }

    public String toString() {
        if (!esVisible) {
            return "[     ]";
        }
        return valor + " de " + palo;

    }
}
