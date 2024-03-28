import java.util.ArrayList;
import java.util.Scanner;
public class elCinquillo {
    private int NumeroDeJugadores;
    private ArrayList<Player> Players;
    private Scanner scanner;
    private Baraja barajaParaJugar;
    private int cartasParaJugador;

    public elCinquillo() {
        Players = new ArrayList<Player>();
        scanner = new Scanner(System.in);
        NumeroDeJugadores = 0;
        barajaParaJugar = new Baraja();
    }

    public void jugarElCinquillo() {
        generarJugadores();
        barajaParaJugar.remover8sY9s();
        barajaParaJugar.barajear();
        cartasParaJugador=barajaParaJugar.getSizeBaraja()/Players.size();

        System.out.println("El numero de cartas para cada jugador sera: "+cartasParaJugador);
        repartirCartas();
        mostrarManosDeJugador();

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
                barajaParaJugar.removerCartaDeLaBaraja(0);
            }
        }
    }
    public void mostrarManosDeJugador() {
        int i=1;
        for (Player player : Players) {
            System.out.println("La mano del jugador "+i+" es");
            player.mostrarMano();
            System.out.println("");
            i++;
        }
    }
}