package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public abstract class Bot extends Jugador {
    protected ControladorEstructura controladorEstructura;
    protected Casilla casilla;
    protected int iterador;
    private ArrayList<Ficha> arregloCambioFichas;
    protected boolean cambioFichaDisponible = true;
    //   private ArrayList<Nodo> arregloNodos;
    // Algoritmo algoritmo;

    public Bot(String name) {
        super(name);
        arregloCambioFichas = new ArrayList<>();
        //  arregloNodos = new ArrayList<>();
    }


    public void iniciar(ControladorEstructura controlador, int iterador) throws Exception {
        // this.jugadaLista = false;
        this.casilla = null;
        this.iterador = iterador;

        if (iterador == 0) {
            this.cambioFichaDisponible = true;
        }
        this.controladorEstructura = new ControladorEstructura(controlador);
        this.analizarEstrategia();

    /*    if (casilla == null && this.arregloNodos.isEmpty()) {
            Nodo nodo = new Nodo(this.controladorEstructura, this.getFichas2());
            Algoritmo algoritmo = new Algoritmo(nodo);
            this.arregloNodos.addAll(algoritmo.mejorRuta);
        }
        if (this.arregloNodos.isEmpty()) {
            this.casilla = null;
        } else {
            Thread.sleep(3000);
            this.setFichaSeleccionada(this.arregloNodos.get(0).fichaBot);
            this.casilla = this.arregloNodos.get(0).casillaBot;
            this.arregloNodos.remove(0);
        }*/

    }

    public boolean isCambioFichaDisponible() {
        return cambioFichaDisponible;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public abstract void analizarEstrategia() throws Exception;

    public abstract void iniciarPartida();

    public Casilla getCasilla() {
        return casilla;
    }

    public abstract ArrayList<Ficha>  cambiarFichas();


}
