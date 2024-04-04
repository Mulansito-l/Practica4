import java.util.ArrayList;
import java.util.Scanner;
public class elCinquillo {
    private int numeroDeJugadores;
    private ArrayList<Player> players;
    private Scanner scanner;
    private Baraja barajaParaJugar;
    private int cartasParaJugador;
    private int turnoActual;
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
        cartasParaJugador = barajaParaJugar.getSizeBaraja() / numeroDeJugadores;

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
        int sizeManoEnTurno;
        int valorCarta;
        String paloCarta;
        Carta carta;

        for (int i=0; i<players.size(); i++) {

            j=0;

            ManoDeCartas mano = players.get(i).getManoDelJugador();
            sizeManoEnTurno = mano.getSizeDeMano();

            while (!bandera && j< sizeManoEnTurno ) {

                carta = players.get(i).getManoDelJugador().getCartaDeMano(j);
                valorCarta = carta.getValor();
                paloCarta = carta.getPalo();

                if ( valorCarta == 5 && (paloCarta.equals("Oros"))) {

                    arrayDeOros.add(carta);
                    players.get(i).getManoDelJugador().removerCartaDeMano(j);
                    bandera = true;
                    turnoActual=i; //el jugador que tenga el 5 de oros, tendra el primer turno
                }
                j++;
            }
        }
    }

    public void buscarOtro5() {
        boolean bandera = false;
        Player jugadorActual = players.get(turnoActual);
        ManoDeCartas mano = jugadorActual.getManoDelJugador();
        int sizeMano = mano.getSizeDeMano();
        int i = 0; //para controlar

        while (!bandera && i < sizeMano) {
            Carta carta = mano.getCartaDeMano(i);

            if (carta.getValor() == 5) {
                switch (carta.getPalo()){
                    case "Copas" -> arrayDeCopas.add(carta);
                    case "Bastos" -> arrayDeBastos.add(carta);
                    case "Espadas" -> arrayDeEspadas.add(carta);
                }

                mano.removerCartaDeMano(i); // Remueve la carta de la mano del jugador actual
                bandera = true;
            }
            i++;
        }

        if (!bandera) {
            System.out.println("No se encontró ninguna carta con valor 5 en la mano del jugador actual");
        }
    }

}