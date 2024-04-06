package src;
import java.util.ArrayList;

public class Juego{
    public static void main(String[] args){
        // Test para observar todas las cartas
        Baraja baraja = new Baraja();
        //baraja.mostrarBarajaEnCanvas();
        Cinquillo game=new Cinquillo();
        game.jugarElCinquillo();
    }
}