import java.util.ArrayList;
import java.util.Scanner;
public class elCinquillo {
    private int NumeroDeJugadores; //aaaaaa
    private ArrayList<Player> Players;
    private Scanner scanner;
    private Baraja barajaParaJugar;
    private int cartasParaJugador;

    public elCinquillo() {
        Players = new ArrayList<Player>();
        scanner = new Scanner(System.in);
        NumeroDeJugadores = 0;
        barajaParaJugar = new Baraja();
        barajaParaJugar.llenarBaraja();
    }

    public void jugarElCinquillo() {
        generarJugadores();
        barajaParaJugar.barajear();
        System.out.println("Cuantas cartas tendra cada jugador: 10-15");
        do {
            cartasParaJugador = scanner.nextInt();
            scanner.nextLine();
            if (cartasParaJugador < 9 || cartasParaJugador > 16) {
                System.out.println("Elija un numero valido de cartas 10-15");
            }
            else {
                System.out.println("El numero de cartas para cada jugador sera: "+cartasParaJugador);
                repartirCartas();
                mostrarBarajas();

            }
        } while (cartasParaJugador<9 || cartasParaJugador >16);
    }

    public void generarJugadores() {
        do {
            System.out.println("Cuantos jugadores habra en la partida (2-6)");
            NumeroDeJugadores = scanner.nextInt();
            scanner.nextLine();
            if (NumeroDeJugadores < 2 || NumeroDeJugadores > 6) {
                System.out.println("Ingrese un numero valido de jugadores");
            }
        } while (NumeroDeJugadores < 2 || NumeroDeJugadores > 6);
        for (int i = 0; i < NumeroDeJugadores; i++) {
            Players.add(new Player());
        }
    }
    public void repartirCartas() {
        for (Player player : Players) {
            for (int j=0;j<cartasParaJugador;j++){
                player.AgregarAMano(barajaParaJugar.getCarta(0));
                barajaParaJugar.sacarCartaDeLaBaraja();
            }
        }
    }
    public void mostrarBarajas() {
        int i=1;
        for (Player player : Players) {
            System.out.println("La mano del jugador "+i+" es");
            player.mostrarMano();
            System.out.println("");
            i++;
        }
    }
}
