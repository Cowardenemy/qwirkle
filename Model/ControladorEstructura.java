package Model;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.scene.control.Alert;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class ControladorEstructura implements Cloneable {
    private ArrayList<Estructura> estructuraFilas;
    private ArrayList<Estructura> estructuraColumnas;
    private HashSet<Estructura> ultimasEstructurasModificadas;
    private Casilla ultimaJugada;
    private String direccion;
    public Tablero tablero;

    public ControladorEstructura(Casilla casilla) {
        this.estructuraColumnas = new ArrayList<>();
        this.estructuraFilas = new ArrayList<>();
        this.estructuraFilas.add(new EstructuraFila(casilla));
        this.estructuraColumnas.add(new EstructuraColumna(casilla));
        ultimasEstructurasModificadas = new HashSet<>();
        this.ultimaJugada = casilla;
    }

    public ControladorEstructura(ControladorEstructura controlador) {
        Tablero tablero = new Tablero();
        this.estructuraColumnas = new ArrayList<>();
        this.estructuraFilas = new ArrayList<>();
        ultimasEstructurasModificadas = new HashSet<>();
        for (Estructura fila : controlador.getEstructuraFilas()) {
            this.estructuraFilas.add(new Estructura(fila, tablero));
        }
        for (Estructura columna : controlador.getEstructuraColumnas()) {
            this.estructuraColumnas.add(new Estructura(columna, tablero));
        }
        this.ultimasEstructurasModificadas = (HashSet) controlador.ultimasEstructurasModificadas.clone();
        if (controlador.ultimaJugada != null) {
            this.ultimaJugada = (Casilla) controlador.ultimaJugada.clone();
        }
        //TODO corregir y decidir qué hacer con cómo conservar la última jugada
        //this.ultimaJugada = new Casilla(controlador.ultimaJugada); EN SU MOVIMIENTO NO TIENE ULTIMA JUGADA
        this.direccion = controlador.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

/*    private void clonarEstructuraFila(ArrayList<Estructura> collection) {
        for (Estructura estructura : collection) {
            this.estructuraFilas.add(new Estructura(estructura));
        }
    }

    private void clonarEstructuraColumna(ArrayList<Estructura> collection) {
        for (Estructura estructura : collection) {
            this.estructuraColumnas.add(new Estructura(estructura));
        }
    }

    private void clonarEstructuraHashSet(HashSet<Estructura> collection) {
        for (Estructura estructura : collection) {
            this.ultimasEstructurasModificadas.add(new Estructura(estructura));
        }
    }*/


    public void limpiarUltimasEstructurasModificadas() {
        this.ultimasEstructurasModificadas.clear();
    }

    public ArrayList<Estructura> getEstructuraFilas() {
        return (ArrayList<Estructura>) estructuraFilas.clone();
    }

    public ArrayList<Estructura> getEstructuraColumnas() {
        return (ArrayList<Estructura>) estructuraColumnas.clone();
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void imprimirCantidadEstructuras() {
        System.out.println("Cantidad de columnas" + this.estructuraColumnas.size());
        System.out.println("Cantidad de filas" + this.estructuraFilas.size());
    }

    public void imprimirEstructuras() {
        System.out.println("IMPRIMIENDO ESTRUCTURA DE FILAS");
        for (Estructura estructuraFila : this.estructuraFilas) {
            System.out.println("IMPRIMIENDO UNA FILA");
            for (Casilla casilla : estructuraFila.getCola()) {
                System.out.println(casilla.toString());
            }
        }
        System.out.println("IMPRIMIENDO ESTRUCTURA DE COLUMNAS");
        for (Estructura estructuraColumna : this.estructuraColumnas) {
            System.out.println("IMPRIMIENDO UNA COLUMNA");
            for (Casilla casilla : estructuraColumna.getCola()) {
                System.out.println(casilla.toString());
            }
        }
    }

    public void crearEstructuraFila(Casilla casilla) {
        if (casilla.getCasillaIzquierda().getFicha() == null && casilla.getCasillaDerecha().getFicha() == null) {
            this.estructuraFilas.add(new Estructura(casilla));
        }
    }

    public void crearEstructuraColumna(Casilla casilla) {
        if (casilla.getCasillaSuperior().getFicha() == null && casilla.getCasillaInferior().getFicha() == null) {
            this.estructuraColumnas.add(new Estructura(casilla));
        }
    }

    public int agregar(Casilla casilla, Ficha ficha) throws Exception {
        if (!casilla.hayFichaAdyacente()) {
           /* Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("NO HAY FICHA ADYACENTE");
            alert.showAndWait();*/
            throw new Exception();
        }
        if (this.ultimaJugada != null) { // concatenar if anidado con &&
            this.ultimaJugada.verificarCasillaAdyacente(casilla);
            if (this.direccion != null) {
                if (!this.ultimaJugada.esMismaLinea(casilla, this.direccion)) {
                    throw new Exception("NO ES EL MISMO VECTOR");
                }
            }
        }
        if (casilla.getCasillaIzquierda().getFicha() != null && casilla.getCasillaDerecha().getFicha() != null) {

            throw new Exception("MEJOR NO ENTRA PORQUE PUEDE ESTALLAR");
           /* if (this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).getRestriccion().equals(this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).getRestriccion())) {
            } else {
                throw new Exception("TIENEN DIFERENTES RESTRICCIONES LAS COLAS, NO ES POSIBLE SU UNIÓN.");
            }*/
        }
        if (casilla.getCasillaSuperior().getFicha() != null && casilla.getCasillaInferior().getFicha() != null) {
            throw new Exception("MEJOR NO ENTRA PORQUE PUEDE ESTALLAR");
         /*   if (this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaIzquierda()).getRestriccion().equals(this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).getRestriccion())) {
            } else {
                throw new Exception("TIENEN DIFERENTES RESTRICCIONES LAS COLAS, NO ES POSIBLE SU UNIÓN.");
            }*/
        }
        if (casilla.getCasillaIzquierda().getFicha() != null) {
            this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).isDuplicated(ficha);
            if (!this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).estaCondicionada()) {
                this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).designarRestriccion(ficha);
            } else {
                this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).cumpleRestriccion(ficha);
            }
            if (this.ultimasEstructurasModificadas.add(this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()))) {
                // System.out.println("ha agregado en caso casilla izquierda = " + this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).getCola().size());
            }
            this.recuperarEstructuraInicial(this.estructuraFilas, casilla.getCasillaIzquierda()).getCola().addLast(casilla);

        }
        if (casilla.getCasillaDerecha().getFicha() != null) {
            this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).isDuplicated(ficha);
            if (!this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).estaCondicionada()) {
                this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).designarRestriccion(ficha);
            } else {
                this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).cumpleRestriccion(ficha);
            }
            //LA RAZÓN POR LA QUE SE AGREGA ANTES QUE SE GUARDE EN LA ORIGINAL ES PORQUE UNA VEZ GUARDADO, AUN NO TIENE FICHA ASIGNADA O LA CASILLA
            //DERECHA DEJA DE SER EL ÚLTIMO O PRIMER ELEMENTO Y POR LO TANTO, NO ENCUENTRA AL ARREGLO Y DEVUELVE NULL
            if (this.ultimasEstructurasModificadas.add(this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()))) {
                //  System.out.println("ha agregado en caso casilla derecha = " + this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).getCola().size());
            }
            this.recuperarEstructuraFinal(this.estructuraFilas, casilla.getCasillaDerecha()).getCola().addFirst(casilla);
        }
        if (casilla.getCasillaSuperior().getFicha() != null) {
            this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).isDuplicated(ficha);
            if (!this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).estaCondicionada()) {
                this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).designarRestriccion(ficha);
            } else {
                this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).cumpleRestriccion(ficha);
            }
            if (this.ultimasEstructurasModificadas.add(this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()))) {
                //  System.out.println("ha agregado en caso casilla superior = " + this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).getCola().size());
            }
            this.recuperarEstructuraInicial(this.estructuraColumnas, casilla.getCasillaSuperior()).getCola().addLast(casilla);

        }
        if (casilla.getCasillaInferior().getFicha() != null) {
            this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).isDuplicated(ficha);
            if (!this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).estaCondicionada()) {
                this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).designarRestriccion(ficha);
            } else {
                this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).cumpleRestriccion(ficha);
            }
            if (this.ultimasEstructurasModificadas.add(this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()))) {
                // System.out.println("ha agregado en caso casilla inferior = " + this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).getCola().size());

            }
            this.recuperarEstructuraFinal(this.estructuraColumnas, casilla.getCasillaInferior()).getCola().addFirst(casilla);

        }
        if (this.direccion == null) {
            if (this.ultimaJugada != null) {
                this.definirDireccion(casilla);
            }
        }
        this.ultimaJugada = casilla;
        this.crearEstructuraFila(casilla);
        this.crearEstructuraColumna(casilla);
        //casilla.setFicha(ficha);

        return this.recuperarLongitudEstructura(casilla);
    }

    public void setUltimaJugada(Casilla ultimaJugada) {
        this.ultimaJugada = ultimaJugada;
    }

    public Casilla getUltimaJugada() {
        return ultimaJugada;
    }

    public void definirDireccion(Casilla casilla) {
        if (this.ultimaJugada.getX() == casilla.getX()) {
            this.direccion = "COLUMNA";
        } else {
            if (this.ultimaJugada.getY() == casilla.getY()) {
                this.direccion = "FILA";
            }
        }
    }

    public int recuperarLongitudEstructura(Casilla casilla) {
        int puntos = 0;
        for (Estructura estructuraFila : this.estructuraFilas) {
            if (estructuraFila.getCola().contains(casilla)) {
                if (estructuraFila.getCola().size() > 1) {
                    puntos = puntos + estructuraFila.getCola().size();
                }
            }
        }
        for (Estructura estructuraColumna : this.estructuraColumnas) {
            if (estructuraColumna.getCola().contains(casilla)) {
                if (estructuraColumna.getCola().size() > 1) {
                    puntos = puntos + estructuraColumna.getCola().size();
                }
            }
        }
        return puntos;
    }

    public HashSet<Estructura> getUltimasEstructurasModificadas() {
        return (HashSet<Estructura>) ultimasEstructurasModificadas.clone();
    }

    public void encontrarEstructura() {

    }

    public Estructura recuperarEstructuraFinal(ArrayList<Estructura> estructuras, Casilla casilla) throws Exception {

        for (Estructura estructura : estructuras) {
            try {
                if (estructura.getCola().getFirst().getFicha().getId() == casilla.getFicha().getId()) {
                    return estructura;
                }
            } catch (Exception e) {
                estructura.getCola().removeFirst();
            }
        }
        //throw new Exception("NO HAY COLA DERECHA O INFERIOR");
        return null;
    }

    public Estructura recuperarEstructuraInicial(ArrayList<Estructura> estructuras, Casilla casilla) {
        for (Estructura estructura : estructuras) {
            try {
                if (estructura.getCola().getLast().getFicha().getId() == casilla.getFicha().getId()) {
                    return estructura;
                }
            } catch (Exception e) {
                estructura.getCola().removeLast();
            }
        }
        return null;
    }
//MODIFICACIÓN DEL MÉTODO ESTRUCTURA QUE PUEDE ESTAR PROVOCANDO ERROR EN
/*    public Estructura recuperarEstructuraFinal(ArrayList<Estructura> estructuras, Casilla casilla) throws Exception {
        try {
            for (Estructura estructura : estructuras) {
                if (estructura.getCola().getFirst().getFicha().getId() == casilla.getFicha().getId()) {
                    return estructura;
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        //throw new Exception("NO HAY COLA DERECHA O INFERIOR");
        return null;
    }*/
/*
    public Estructura recuperarEstructuraInicial(ArrayList<Estructura> estructuras, Casilla casilla) {
        try {
            for (Estructura estructura : estructuras) {
                if (estructura.getCola().getLast().getFicha().getId() == casilla.getFicha().getId()) {

                    return estructura;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/
    //throw new Exception("NO HAY COLA IZQUIERDA O SUPERIOR");


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


