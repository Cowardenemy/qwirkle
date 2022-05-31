/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Tablero implements Iterable<Casilla>{

    public final Casilla[][] casilla;

    public Tablero() {
        this.casilla = new Casilla[24][24];
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 24; j++) {
                this.casilla[i][j] = new Casilla(i, j);
            }
        }
    this.configurarCasillasAdyacentes();
    }

    public void configurarCasillasAdyacentes(){

        for (Casilla[] casilla: this.casilla) {
            for (Casilla casilla2:casilla) {
                casilla2.setCasillaDerecha(this.getCasillaDerecha(casilla2));
                casilla2.setCasillaIzquierda(this.getCasillaIzquierda(casilla2));
                casilla2.setCasillaSuperior(this.getCasillaArriba(casilla2));
                casilla2.setCasillaInferior(this.getCasillaAbajo(casilla2));
            }
        }
    }

    public Casilla getCasillaArriba(Casilla casilla) {
        return this.getCasilla(casilla.getX(), casilla.getY() - 1);
    }

    public Casilla getCasillaAbajo(Casilla casilla) {
        return this.getCasilla(casilla.getX(), casilla.getY() + 1);
    }

    public Casilla getCasillaIzquierda(Casilla casilla) {
        return this.getCasilla(casilla.getX() - 1, casilla.getY());
    }

    public Casilla getCasillaDerecha(Casilla casilla) {
        return this.getCasilla(casilla.getX() + 1, casilla.getY());
    }

    private Casilla getCasilla(int x, int y) {
        try {
            return this.casilla[x][y];
        } catch (Exception e) {
            return new Casilla();
        }
    }

    public ArrayList<Ficha> getFichaLateral(Casilla casilla) {
        ArrayList<Ficha> fichasLaterales = new ArrayList<>();
        if (this.getCasillaIzquierda(casilla) != null) {
            if (this.getCasillaIzquierda(casilla).getFicha() != null) {
                fichasLaterales.add(this.getCasillaIzquierda(casilla).getFicha());
            }
        }
        if (this.getCasillaDerecha(casilla) != null ) {
            if (this.getCasillaDerecha(casilla).getFicha() != null) {
                fichasLaterales.add(this.getCasillaDerecha(casilla).getFicha());
            }
        }
        return (ArrayList) fichasLaterales.clone();
    }

    public ArrayList<Ficha> getFichaSuperior(Casilla casilla) {
        ArrayList<Ficha> fichasSuperiores = new ArrayList<>();
        if (this.getCasillaArriba(casilla) != null) {
            if (this.getCasillaArriba(casilla).getFicha() != null) {
                fichasSuperiores.add(this.getCasillaArriba(casilla).getFicha());
            }
        }
        if (this.getCasillaAbajo(casilla) != null) {
            if (this.getCasillaAbajo(casilla).getFicha() != null) {
                fichasSuperiores.add(this.getCasillaAbajo(casilla).getFicha());
            }
        }
        return (ArrayList) fichasSuperiores.clone();
    }

    public Casilla ponerFicha(Ficha fichaSeleccionada, int x, int y) {
        if (fichaSeleccionada != null) {
            this.casilla[x][y].setFicha(fichaSeleccionada);
            System.out.println("casilla = " + casilla[x][y].getFicha().getColor() + " " + casilla[x][y].getFicha().getForma() + " " + casilla[x][y].getFicha().getId() + "  X Y: " + x + " " + y);
        }
        return this.casilla[x][y];
    }

    @Override
    public Iterator<Casilla> iterator() {
        return null;
    }
}
