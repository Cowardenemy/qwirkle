package Model;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.LinkedList;

public class EstructuraFila extends Estructura {
    public EstructuraFila(Casilla casilla) {
        super(casilla);
    }

    public boolean agregarEnColaIzquierda(Casilla casilla, Ficha ficha) throws Exception {
        if (casilla.getCasillaIzquierda().getFicha() != null) {
            if (this.colas.getLast().getFicha().getId() == casilla.getCasillaIzquierda().getFicha().getId()) {
                if (!this.addToRight(casilla, ficha)) {
                    throw new Exception("problema en agregarEnColaIzquierda");
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public boolean agregarEnColaDerecha(Casilla casilla, Ficha ficha) throws Exception {
            if (casilla.getCasillaDerecha().getFicha() != null) {
                if (this.getCola().getFirst().getFicha().getId() == casilla.getCasillaDerecha().getFicha().getId()) {
                    if (!this.addToLeft(casilla, ficha)) {
                        throw new Exception("problema en agregarEnColaDerecha");
                    }else{
                        return true;
                    }
                }
            }
            return false;
    }
}
