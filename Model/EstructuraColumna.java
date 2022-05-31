package Model;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.misc.Queue;

import java.util.*;

//TODO crear clase padre de EstructuraFila y EstructuraColumna
public class EstructuraColumna extends Estructura {
    public EstructuraColumna(Casilla casilla) {
        super(casilla);
    }


    public boolean agregarEnColaSuperior(Casilla casilla, Ficha ficha) throws Exception {
        if (casilla.getCasillaSuperior().getFicha() != null) {
            if (this.colas.getLast().getFicha().getId() == casilla.getCasillaSuperior().getFicha().getId()) {
                if (!this.addToRight(casilla, ficha)) {
                    throw new Exception("problema en agregarEnColaSuperior");
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public boolean agregarEnColaInferior(Casilla casilla, Ficha ficha) throws Exception {
        if (casilla.getCasillaInferior().getFicha() != null) {
            if (this.getCola().getFirst().getFicha().getId() == casilla.getCasillaInferior().getFicha().getId()) {
                if (!this.addToLeft(casilla, ficha)) {
                    throw new Exception("problema en agregarEnColaInferior");
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}
