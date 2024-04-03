import java.util.ArrayList;
import java.util.Scanner;
public class elCinquillo {
    private int numeroDeJugadores;
    private ArrayList<Player> players;
    private Scanner scanner;
    private Baraja barajaParaJugar;
    private int cartasParaJugador;
    private ArrayList <Carta> arrayDeOros;
    private ArrayList <Carta> arrayDeBastos;
    private ArrayList <Carta> arrayDeEspadas;
    private ArrayList <Carta> arrayDeCopas;
    public elCinquillo() {
        players = new ArrayList<Player>();
        scanner = new Scanner(System.in);
        numeroDeJugadores = 0;
        barajaParaJugar = new Baraja();
        arrayDeOros =new ArrayList<Carta>();
        arrayDeBastos =new ArrayList<Carta>();
        arrayDeEspadas =new ArrayList<Carta>();
        arrayDeCopas =new ArrayList<Carta>();
    }

    public void jugarElCinquillo() {
        generarJugadores();
        barajaParaJugar.remover8sY9s();
        barajaParaJugar.barajear();
        cartasParaJugador = barajaParaJugar.getSizeBaraja() / players.size();

        System.out.println("El numero de cartas para cada jugador sera: " + cartasParaJugador);
        repartirCartas();
        mostrarManosDeJugador();
        agregar5AlCentro();
        System.out.println(arrayDeOros);
    }

    public void generarJugadores() {
        do {
            System.out.println("Cuantos jugadores habra en la partida (2-6)");
            numeroDeJugadores = scanner.nextInt();
            scanner.nextLine();
            if (numeroDeJugadores < 2 || numeroDeJugadores > 6) {
                System.out.println("Ingrese un numero valido de jugadores");
            }
        } while (numeroDeJugadores < 2 || numeroDeJugadores > 6);
        for (int i = 0; i < numeroDeJugadores; i++) {
            players.add(new Player());
        }
    }

    public void repartirCartas() {
        for (Player player : players) {
            for (int j = 0; j < cartasParaJugador; j++) {
                player.AgregarAMano(barajaParaJugar.getCarta(0));
                barajaParaJugar.removerCartaDeLaBaraja(0);
            }
        }
    }

    public void mostrarManosDeJugador() {
        int i = 1;
        for (Player player : players) {
            System.out.println("La mano del jugador " + i + " es");
            player.mostrarMano();
            System.out.println("");
            i++;
        }
    }
    public void agregar5AlCentro() {
        boolean bandera = false;
        int j;
        for (Player player : players) {
            j=0;
            while (!bandera && j<player.getManoDelJugador().getSizeDeMano()) {
                if (player.getManoDelJugador().getCartaDeMano(j).getValor() == 5 && (player.getManoDelJugador().getCartaDeMano(j).getPalo().equals("Oros"))) {
                    arrayDeOros.add(player.getManoDelJugador().getCartaDeMano(j));
                    player.getManoDelJugador().removerCartaDeMano(j);
                    bandera = true;
                    player.setTurno(1);//El jugador que tenga el 5 de oros será el que comience
                }
                j++;
            }
        }
    }
}