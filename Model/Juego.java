package Model;

import Debug.DebugExt;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Juego extends Thread {

    private Bolsa bolsa;
    private Tablero tablero;
    private ControladorEstructura controladorEstructura;
    private Casilla ultimaJugada;
    private String direccion;
    private ArrayList<Ficha> fichasTramitadas;
    private boolean fichaEncambio;
    private int numeroJugadorEnTurno = 0; //apunta un jugador adelante. Posible cambio a proximoNumeroJugadorEnTurno
    public Jugador jugadores[];
    DebugExt debug = null;
    boolean primerMovimiento = true;
    Thread run = null;

    public Juego(ArrayList<String> listaJugadores) throws Exception {//agregar como parámetro la cantidad de jugadores, esándar es de dos, a lo mejor se agregan otros
        this.bolsa = new Bolsa();
        this.tablero = new Tablero();
        Ficha.setID(1);
        Jugador.setID(0);
        // this.estructura = new Estructura();
        this.jugadores = new Jugador[listaJugadores.size()];
        this.fichaEncambio = false;
        this.fichasTramitadas = new ArrayList<Ficha>();

        Runnable ventana = new Runnable() {
            @Override
            public void run() {
                debugger();
            }
        };

        this.run = new Thread(ventana);
        this.run.start();

        // this.regla = new Regla(this.bolsa, this.tablero);

//creador de jugadores. TODO para crear métodos instanciadores como crearJugadores

        this.crearJugadores(listaJugadores);
        /*for (int i = 0; i < jugadores.length - 1; i++) {
            jugadores[i] = new Jugador();
        }*/
        // this.jugadores[this.jugadores.length - 1] = new Bot();

        this.asignarFichas();
       /* for (Ficha ficha : this.jugadores[this.jugadores.length - 1].getArregloFichas()) {
            System.out.println(ficha.toString());
        }*/
    }

    private void debugger() {
        this.debug = new DebugExt(null, false);
        this.debug.jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    actualizarDatos(evt);
                } catch (Exception err) {
                    System.out.println("Datos no existentes");
                }
            }
        });
        this.debug.setVisible(true);
    }

    private void actualizarDatos(java.awt.event.ActionEvent evt) {
        this.debug.updateDebug(this.controladorEstructura.getEstructuraFilas(), this.controladorEstructura.getEstructuraColumnas(),
                this.controladorEstructura.getUltimasEstructurasModificadas(), this.controladorEstructura.getUltimaJugada(), this.controladorEstructura.getDireccion());
        System.out.println("Actualizado");
    }

    private void crearJugadores(ArrayList<String> listaJugadores) {
        for (int i = 0; i < listaJugadores.size(); i++) {
            System.out.println(listaJugadores.get(i));
            switch (listaJugadores.get(i)) {
                case "Jugador Humano":
                    System.out.println("ENTRA A  CREAR JUGADOR");
                    this.jugadores[i] = new Jugador("Jugador Humano");
                    break;
                case "Bot Equipo 5":
                    System.out.println("ENTRA A  CREAR JUGADOR");
                    this.jugadores[i] = new BotEquipo5();
                    break;
                case "Bot Equipo 6":
                    this.jugadores[i] = new BotEquipo6();
                    break;
                case "Bot Equipo 7":
                    break;
                case "Bot Equipo 5 Avanzado":
                    this.jugadores[i] = new BotAvanzado5();
                    break;
            }
        }
    }

    public void setUltimaJugada(Casilla ultimaJugada) {
        this.ultimaJugada = ultimaJugada;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void agregarFichaCambio(Ficha ficha) {
        this.fichasTramitadas.add(ficha);
    }

    public void agregarFichaCambio(ArrayList<Ficha> arreglo) {
        System.out.println("SE AGREGAN FICAHS DE CAMBIO");
        this.fichasTramitadas.addAll(arreglo);
    }

    public boolean isFichaEncambio() {
        return fichaEncambio;
    }

    public void setFichaEncambio(boolean fichaEncambio) {
        this.fichaEncambio = fichaEncambio;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public ControladorEstructura getControladorEstructura() {
        return controladorEstructura;
    }
    //Posible creación del método iniciar para evitar mucho código en el constructor

    public void iniciarJuego() {
    }


    public void asignarFichas() throws Exception {
        for (int i = 0; i < jugadores.length; i++) {
            for (int j = 0; j < 6; j++) {
                jugadores[i].setFicha(this.bolsa.darFicha());
            }
        }
    }

    public Jugador getJugadorEnTurno() {
        return this.jugadores[this.numeroJugadorEnTurno];
    }

    public Tablero getTablero() {
        return this.tablero;
    }


    public Ficha sacarFichaBolsa() throws Exception {
        return this.bolsa.darFicha();
    }

    public boolean isMovimientoValido(Casilla casilla) throws Exception {

        if (this.primerMovimiento) {
            this.realizarPrimerMovimiento(casilla);
        } else {
            if (casilla.getFicha() != null) {
                throw new Exception("ESTA CASILLA YA TIENE FICHA");
            }
       /*     if (!casilla.hayFichaAdyacente()) {
                throw new Exception("NO HAY FICHA ADYACENTE");
            }
            if (this.ultimaJugada != null) { // concatenar if anidado con &&
                this.ultimaJugada.verificarCasillaAdyacente(casilla);
                if (this.direccion != null) {
                    if (!this.ultimaJugada.esMismaLinea(casilla, this.direccion)) {
                        throw new Exception("NO ES EL MISMO VECTOR");
                    }
                }
            }*/
//            System.out.println(casilla.toString());
//            System.out.println(this.jugadores[numeroJugadorEnTurno].getFichaSeleccionada().toString());
            this.controladorEstructura.agregar(casilla, this.jugadores[numeroJugadorEnTurno].getFichaSeleccionada());
            this.realizarMovimiento(casilla);
            // ESTO ESTÁ IGUAL EN EL CONTROLLER, SE DEBE ESTAR DUPLICANDO PERO NO DEBERÍA AFECTAR LA INTERACIÓN DEL JUEGO
            //SE DUPLICA AQUÍ PARA PROBAR CON LA FUNCIONALIDAD DEL BOT
            if (this.getJugadorEnTurno() instanceof Bot) {
                this.getJugadorEnTurno().removerFicha(this.getJugadorEnTurno().getFichaSeleccionada());
                this.getJugadorEnTurno().setFichaSeleccionada(null);
            }

        }
        //se ha quitado de estructura controlador para probar si realmente funciona o afecta
//        casilla.setFicha(this.getJugadorEnTurno().getFichaSeleccionada());

        return true;
    }

    /*public void definirDireccion(Casilla casilla) {
        if (!this.ultimaJugada.equals(casilla)) {
            if (this.ultimaJugada.getX() == casilla.getX()) {
                this.direccion = "COLUMNA";
            } else {
                if (this.ultimaJugada.getY() == casilla.getY()) {
                    this.direccion = "FILA";
                }
            }
        }
    }*/

    public void realizarPrimerMovimiento(Casilla casilla) {
        this.controladorEstructura = new ControladorEstructura(casilla);
        this.realizarMovimiento(casilla);
        this.primerMovimiento = false;
    }

    private void realizarMovimiento(Casilla casilla) {
        /*if (this.direccion == null) {
            if (this.ultimaJugada != null) {
                this.definirDireccion(casilla);
            }
        }*/
        this.ultimaJugada = casilla;
        this.tablero.casilla[casilla.getX()][casilla.getY()].setFicha(this.jugadores[numeroJugadorEnTurno].getFichaSeleccionada());
        //   this.controladorEstructura.imprimirEstructuras();
    }

    public int calcularPuntos(HashSet<Estructura> estructuras) {
        int puntos = 0;
        for (Estructura estructura : estructuras) {
            puntos = puntos + estructura.getCola().size();
            if (estructura.getCola().size() == 6) {
                puntos += 6;
            }
        }
        return puntos;
    }

    public void terminarTurno() throws Exception {
        this.getJugadorEnTurno().removerFichaSeleccionada();
        this.getJugadorEnTurno().quitarFichasJugadas();
        if (this.getJugadorEnTurno() instanceof Bot && ((Bot) this.getJugadorEnTurno()).isCambioFichaDisponible()){
            System.out.println("EL BOT QUIERE CAMBIAR FICHAS");
        }
        if (this.fichaEncambio == true) {
            if (!this.fichasTramitadas.isEmpty()) {
                for (Ficha ficha : this.fichasTramitadas) {
                    this.bolsa.recibirFicha(ficha);
                }
            }
        } else {
            this.jugadores[this.numeroJugadorEnTurno].sumarPuntos(this.calcularPuntos(this.controladorEstructura.getUltimasEstructurasModificadas()));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("PUNTOS GANADOS: " + this.calcularPuntos(this.controladorEstructura.getUltimasEstructurasModificadas()));
            alert.showAndWait();
        }
        this.limpiarControladorEstructura();
        while ((this.getJugadorEnTurno().getArregloFichas().length < 6) && (!this.bolsa.fichas.isEmpty())) {
            this.getJugadorEnTurno().setFicha(this.sacarFichaBolsa());
        }
        if (this.getJugadorEnTurno().getArregloFichas().length < 6 && this.bolsa.fichas.isEmpty()) {
            Collections.sort(this.getJugadorEnTurno().fichas, new Comparator<Ficha>() {
                @Override
                public int compare(Ficha o1, Ficha o2) {
                    return o1.getId() - o2.getId();
                }
            });
        }
        this.cambiarJugador();
        this.fichaEncambio = false;
        this.fichasTramitadas.clear();
    }

    public void limpiarControladorEstructura() {
        this.controladorEstructura.limpiarUltimasEstructurasModificadas();
        this.controladorEstructura.setUltimaJugada(null);
        this.controladorEstructura.setDireccion(null);
    }

    public void cambiarJugador() {
        if (this.numeroJugadorEnTurno == this.jugadores.length - 1) {
            this.numeroJugadorEnTurno = 0;
        } else {
            this.numeroJugadorEnTurno++;
        }
    }

    public void moverBot(int iterador) throws Exception {
        this.jugadores[numeroJugadorEnTurno].setFichaSeleccionada(null);
        //System.out.println("LA ULTIMA JUGADA ES: " + this.controladorEstructura.getUltimaJugada().toString());
        if (this.controladorEstructura == null) {
            ((Bot) this.jugadores[numeroJugadorEnTurno]).iniciarPartida();
            ((Bot) this.jugadores[numeroJugadorEnTurno]).setCasilla(this.tablero.casilla[10][10]);
        } else {
            ((Bot) this.jugadores[numeroJugadorEnTurno]).iniciar((ControladorEstructura) this.controladorEstructura.clone(), iterador);
        }
        if (((Bot) this.jugadores[numeroJugadorEnTurno]).getCasilla() != null) {
            // this.controladorEstructura.imprimirEstructuras();

//            this.isMovimientoValido(((Bot) this.jugadores[numeroJugadorEnTurno]).getCasilla());
            this.isMovimientoValido(this.tablero.casilla[((Bot) this.jugadores[numeroJugadorEnTurno]).getCasilla().getX()][((Bot) this.jugadores[numeroJugadorEnTurno]).getCasilla().getY()]);

        }
    }

    public int getNumeroJugadorEnTurno() {
        return numeroJugadorEnTurno;
    }

    @Override
    public void run() {

    }
}