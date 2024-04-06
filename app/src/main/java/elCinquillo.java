import java.util.ArrayList;
import java.util.Scanner;
public class elCinquillo {
    private int NumeroDeJugadores;
    private ArrayList<Player> Players;
    private Scanner scanner;
    private Baraja barajaParaJugar;
    private int cartasParaJugador;
    private ArrayList <Carta>ArrayDeOros;
    private ArrayList <Carta>ArrayDeBastos;
    private ArrayList <Carta>ArrayDeEspadas;
    private ArrayList <Carta>ArrayDeCopas;
    public elCinquillo() {
        Players = new ArrayList<Player>();
        scanner = new Scanner(System.in);
        NumeroDeJugadores = 0;
        barajaParaJugar = new Baraja();
        ArrayDeOros=new ArrayList<Carta>();
        ArrayDeBastos=new ArrayList<Carta>();
        ArrayDeEspadas=new ArrayList<Carta>();
        ArrayDeCopas=new ArrayList<Carta>();
    }

    public void jugarElCinquillo() {
        generarJugadores();
        barajaParaJugar.remover8sY9s();
        barajaParaJugar.barajear();
        cartasParaJugador = barajaParaJugar.getSizeBaraja() / Players.size();

        System.out.println("El numero de cartas para cada jugador sera: " + cartasParaJugador);
        repartirCartas();
        mostrarManosDeJugador();
        agregar5AlCentro();
        System.out.println(ArrayDeOros);
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
            for (int j = 0; j < cartasParaJugador; j++) {
                player.AgregarAMano(barajaParaJugar.getCarta(0));
                barajaParaJugar.removerCartaDeLaBaraja(0);
            }
        }
    }

    public void mostrarManosDeJugador() {
        int i = 1;
        for (Player player : Players) {
            System.out.println("La mano del jugador " + i + " es");
            player.mostrarMano();
            System.out.println("");
            i++;
        }
    }
    public void agregar5AlCentro() {
        boolean bandera = false;
        int j;
        for (Player player : Players) {
            j=0;
            while (!bandera && j<player.getManoDelJugador().getSizeDeMano()) {
                if (player.getManoDelJugador().getCartaDeMano(j).getValor() == 5 && (player.getManoDelJugador().getCartaDeMano(j).getPalo().equals("Oros"))) {
                    ArrayDeOros.add(player.getManoDelJugador().getCartaDeMano(j));
                    player.getManoDelJugador().removerCartaDeMano(j);
                    bandera = true;
                    player.setTurno(1);//El jugador que tenga el 5 de oros será el que comience
                }
                j++;
            }
        }
    }
    public boolean buscarOtro5() {
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

        return bandera;

    }

    public boolean ponerCartaAlPrincipio(){
        boolean bandera = false;
        Player jugadorActual = players.get(turnoActual);
        ManoDeCartas mano = jugadorActual.getManoDelJugador();
        int sizeMano = mano.getSizeDeMano();
        int i = 0; //para controlar

        while (!bandera && i < sizeMano) {
            Carta carta = mano.getCartaDeMano(i);
            String paloCarta = carta.getPalo();
            int valorCarta = carta.getValor();
            Carta cartaAux;
            int valorCartaAux;

            switch (paloCarta){
                case "Oros":

                    if (!arrayDeOros.isEmpty()){

                        cartaAux = arrayDeOros.get(0);
                        valorCartaAux = cartaAux.getValor();

                        if ( valorCarta == (valorCartaAux-1) ){
                            arrayDeOros.add(0,carta);
                            mano.removerCartaDeMano(i);
                            bandera = true;
                        }

                    } else {
                        System.out.println("No se pueden colocar cartas al principio de la escalera de oros");
                    }

                    break;

                case "Bastos":

                    if (!arrayDeBastos.isEmpty()){

                        cartaAux = arrayDeBastos.get(0);
                        valorCartaAux = cartaAux.getValor();

                        if ( valorCarta == (valorCartaAux-1) ){
                            arrayDeBastos.add(0,carta);
                            mano.removerCartaDeMano(i);
                            bandera = true;
                        }

                    } else {
                        System.out.println("No se pueden colocar cartas al principio de la escalera de bastos");
                    }

                    break;

                case "Espadas":

                    if (!arrayDeEspadas.isEmpty()){

                        cartaAux = arrayDeEspadas.get(0);
                        valorCartaAux = cartaAux.getValor();

                        if ( valorCarta == (valorCartaAux-1) ){
                            arrayDeEspadas.add(0,carta);
                            mano.removerCartaDeMano(i);
                            bandera = true;
                        }

                    } else {
                        System.out.println("No se pueden colocar cartas al principio de la escalera de espadas");
                    }

                    break;

                case "Copas":

                    if (!arrayDeCopas.isEmpty()) {

                        cartaAux = arrayDeCopas.get(0);
                        valorCartaAux = cartaAux.getValor();

                        if ( valorCarta == (valorCartaAux-1) ){
                            arrayDeCopas.add(0,carta);
                            mano.removerCartaDeMano(i);
                            bandera = true;
                        }

                    } else {
                        System.out.println("No se pueden colocar cartas al principio de la escalera de copas");
                    }

                    break;

            }

            i++;

        }

        if (!bandera) {
            System.out.println("No se encontró ninguna carta para colocar al principio de cualquier escalera");
        }

        return bandera;

    }

    public boolean ponerCartaAlFinal(){
        boolean bandera = false;
        Player jugadorActual = players.get(turnoActual);
        ManoDeCartas mano = jugadorActual.getManoDelJugador();
        int sizeMano = mano.getSizeDeMano();
        int i = 0; //para controlar

        while (!bandera && i < sizeMano) {
            Carta carta = mano.getCartaDeMano(i);
            String paloCarta = carta.getPalo();
            int valorCarta = carta.getValor();
            Carta cartaAux;
            int valorCartaAux;
            int cantidaDeCartasEn;


            switch (paloCarta){
                case "Oros":

                    if (!arrayDeOros.isEmpty()){

                        cantidaDeCartasEn = arrayDeOros.size();
                        cartaAux = arrayDeOros.get( cantidaDeCartasEn - 1 );
                        valorCartaAux = cartaAux.getValor();

                        if ( valorCarta == (valorCartaAux+1) ){
                            arrayDeOros.add(cantidaDeCartasEn,carta);
                            mano.removerCartaDeMano(i);
                            bandera = true;
                        }

                    } else {
                        System.out.println("No se pueden colocar cartas al final de la escalera de oros");
                    }

                    break;

                case "Bastos":

                    if (!arrayDeBastos.isEmpty()) {

                        cantidaDeCartasEn = arrayDeBastos.size();
                        cartaAux = arrayDeBastos.get( cantidaDeCartasEn -1 );
                        valorCartaAux = cartaAux.getValor();

                        if ( valorCarta == (valorCartaAux+1) ){
                            arrayDeBastos.add(cantidaDeCartasEn,carta);
                            mano.removerCartaDeMano(i);
                            bandera = true;
                        }

                    } else {
                        System.out.println("No se pueden colocar cartas al final de la escalera de bastos");
                    }

                    break;

                case "Espadas":

                    if (!arrayDeEspadas.isEmpty()) {
                        cantidaDeCartasEn = arrayDeEspadas.size();
                        cartaAux = arrayDeEspadas.get( cantidaDeCartasEn -1 );
                        valorCartaAux = cartaAux.getValor();

                        if ( valorCarta == (valorCartaAux+1) ){
                            arrayDeEspadas.add(cantidaDeCartasEn,carta);
                            mano.removerCartaDeMano(i);
                            bandera = true;
                        }
                    } else {
                        System.out.println("No se pueden colocar cartas al final de la escalera de espadas");
                    }

                    break;

                case "Copas":

                    if (!arrayDeCopas.isEmpty()){

                        cantidaDeCartasEn = arrayDeCopas.size();
                        cartaAux = arrayDeCopas.get( cantidaDeCartasEn -1 );
                        valorCartaAux = cartaAux.getValor();

                        if ( valorCarta == (valorCartaAux+1) ){
                            arrayDeCopas.add(cantidaDeCartasEn,carta);
                            mano.removerCartaDeMano(i);
                            bandera = true;
                        }

                    } else {
                        System.out.println("No se pueden colocar cartas al final de la escalera de copas");
                    }

                    break;

            }

            i++;

        }

        if (!bandera) {
            System.out.println("No se encontró ninguna carta para colocar al final de cualquier escalera");
        }

        return bandera; //regresa true cuando se coloca
    }

    //método para poder buscar si el jugador en turno tiene un 5,
    //sino va a colocar al prinpicio o al final de una escalera
    public void colocarCarta(){
        boolean resultado=false;
        resultado = buscarOtro5();

        if (resultado){
            System.out.println("Se pudo colocar la carta");
        } else {
            System.out.println("No pudiste colocar la carta en ningun lado");
        }

        resultado = ponerCartaAlPrincipio();

        if (resultado){
            System.out.println("Se pudo colocar la carta");
        } else {
            System.out.println("No pudiste colocar la carta en ningun lado");
        }

        resultado = ponerCartaAlFinal();

        if (resultado){
            System.out.println("Se pudo colocar la carta");
        } else {
            System.out.println("No pudiste colocar la carta en ningun lado");
        }

    }
}