/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.scene.control.Alert;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Objects;

public class Casilla implements Comparable<Casilla>, Cloneable {

    private int x;
    private int y;
    private Ficha ficha;
    private Casilla casillaSuperior;
    private Casilla casillaInferior;
    private Casilla casillaIzquierda;
    private Casilla casillaDerecha;

    public Casilla(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public Object clone()
    {
        Object clone = null;
        try
        {
            clone = super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            // No debería ocurrir
        }
        // Aqui viene la implementacion de la clonación "profunda" ('deep clone')
        ((Casilla)clone).x = this.x;
        ((Casilla)clone).y = this.y;
        ((Casilla)clone).ficha = this.ficha;
        ((Casilla)clone).casillaSuperior = this.casillaSuperior;
        ((Casilla)clone).casillaInferior = this.casillaInferior;
        ((Casilla)clone).casillaIzquierda = this.casillaIzquierda;
        ((Casilla)clone).casillaDerecha = this.casillaDerecha;
        return clone;
    }

    public Casilla(Casilla casilla){
        this.x = casilla.getX();
        this.y = casilla.getY();
        this.ficha = casilla.ficha;
        this.casillaSuperior = casilla.casillaSuperior;
        this.casillaInferior = casilla.casillaInferior;
        this.casillaIzquierda = casilla.casillaIzquierda;
        this.casillaDerecha = casilla.casillaDerecha;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public void setCasillaSuperior(Casilla casillaSuperior) {
        this.casillaSuperior = casillaSuperior;
    }

    public void setCasillaInferior(Casilla casillaInferior) {
        this.casillaInferior = casillaInferior;
    }

    public void setCasillaIzquierda(Casilla casillaIzquierda) {
        this.casillaIzquierda = casillaIzquierda;
    }

    public void setCasillaDerecha(Casilla casillaDerecha) {
        this.casillaDerecha = casillaDerecha;
    }

    public Casilla getCasillaSuperior() {
        return casillaSuperior;
    }

    public Casilla getCasillaInferior() {
        return casillaInferior;
    }

    public Casilla getCasillaDerecha() {
        return casillaDerecha;
    }

    public Casilla getCasillaIzquierda() {
        return casillaIzquierda;
    }

    public Casilla(int x, int y, Ficha ficha) {
        this.x = x;
        this.y = y;
        this.ficha = ficha;
    }

    public boolean verificarCasillaAdyacente(Casilla casilla) throws Exception {
        if (this.casillaSuperior.equals(casilla)) {
            return true;
        }
        if (this.casillaInferior.equals(casilla)) {
            return true;
        }
        if (this.casillaIzquierda.equals(casilla)) {
            return true;
        }
        if (this.casillaDerecha.equals(casilla)) {
            return true;
        }
        throw new Exception("NO COINCIDE CON LA ÚLTIMA JUGADA");
    }

    public boolean esMismaLinea(Casilla casilla, String direccion) {
        if (direccion.equals("COLUMNA")) {
            if (this.x == casilla.x) {
                return true;
            }
        }
        if (direccion.equals("FILA")) {
            if (this.y == casilla.y) {
                return true;
            }
        }
        return false;
    }

    public boolean hayFichaAdyacente() {
        if (this.casillaSuperior.getFicha() != null) {
            return true;
        }
        if (this.casillaInferior.getFicha() != null) {
            return true;
        }
        if (this.casillaIzquierda.getFicha() != null) {
            return true;
        }
        if (this.casillaDerecha.getFicha() != null) {
            return true;
        }
        return false;
    }



    public boolean findCasilla(Casilla casilla) {
        if (this.casillaSuperior.getFicha() != null && this.casillaSuperior.getFicha().getId() == casilla.getFicha().getId()) {
            return true;
        } else {
            if (this.casillaInferior.getFicha() != null && this.casillaInferior.getFicha().getId() == casilla.getFicha().getId()) {
                return true;
            } else {
                if (this.casillaIzquierda.getFicha() != null && this.casillaIzquierda.getFicha().getId() == casilla.getFicha().getId()) {
                    return true;
                } else {
                    if (this.casillaDerecha.getFicha() != null && this.casillaDerecha.getFicha().getId() == casilla.getFicha().getId()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    public Casilla() {
        this.x = 0;
        this.y = 0;
        this.ficha = null;
    }


    @Override
    public String toString() {
        return "Casilla{" +
                "x=" + x +
                ", y=" + y +
                ", ficha=" + ficha +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Casilla casilla = (Casilla) o;

        if (x != casilla.x) return false;
        return y == casilla.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, ficha);
    }

    @Override
    public int compareTo(Casilla o) {
        if (this.x > o.x) {
            return 1;
        } else {
            if (this.x == o.x) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
