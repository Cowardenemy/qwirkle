package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class BotEquipo5 extends Bot {

    public BotEquipo5(){
        super("Bot Equipo 5");
    }

    @Override
    public void analizarEstrategia() throws Exception {
        this.controladorEstructura.getEstructuraColumnas().sort(new Comparator<Estructura>() {
            @Override
            public int compare(Estructura o1, Estructura o2) {
                return o2.getCola().size() - o1.getCola().size();
            }
        });

        if (this.controladorEstructura.getEstructuraFilas().isEmpty() && this.controladorEstructura.getEstructuraFilas().isEmpty()) {
//            System.out.println("NO HAY FICHAS EN EL TABLERO");
            this.iniciarPartida();
        } else {
            //  System.out.println("HAY FICHAS EN EL TABLERO PERO NO SÉ POR QUÉ");
            for (int i = 5; i > 0; i--) {

                if (this.casilla == null) {
                    if (this.isJugadaEncontradaFilas(i)) {
                        // JOptionPane.showMessageDialog(null, "HE ENCONTRADO FICHA Y CASILLA");
                    } else {
                        if (this.isJugadaEncontradaColumnas(i)) {
                            // JOptionPane.showMessageDialog(null, "HE ENCONTRADO FICHA Y CASILLA");
                        }
                    }
                } else {
                    break;
                }
            }
        }
    }

    public void iniciarPartida() {
        this.setFichaSeleccionada(this.fichas.get(0));
        this.casilla = new Casilla(10, 10);
    }

    @Override
    public ArrayList<Ficha> cambiarFichas() {
        ArrayList<Ficha> arregloCambioFichas = new ArrayList<>();
        arregloCambioFichas.add(this.fichas.get(0));
        arregloCambioFichas.add(this.fichas.get(2));
        arregloCambioFichas.add(this.fichas.get(5));
        return arregloCambioFichas;
    }

    public boolean isJugadaEncontradaFilas(int i) throws Exception {
        for (Estructura fila : this.controladorEstructura.getEstructuraFilas()) {
            if (fila.getCola().size() == i) {
                for (Ficha ficha : this.getArregloFichas()) {
                    if (Regla.cumpleRestriccion(fila, ficha)) {
                        if (fila.getCola().getLast().getCasillaDerecha() != null) {
                            try {
                                this.controladorEstructura.agregar(fila.getCola().getLast().getCasillaDerecha(), ficha);
                                this.setFichaSeleccionada(ficha);
                                fila.getCola().getLast().setFicha(null);
                                this.casilla = fila.getCola().getLast();
                                return true;
                            } catch (Exception e) {
                                //   e.printStackTrace();
                            }
                        } else {
                            if (fila.getCola().getFirst().getCasillaIzquierda() != null) {
                                try {
                                    this.controladorEstructura.agregar(fila.getCola().getFirst().getCasillaIzquierda(), ficha);
                                    this.setFichaSeleccionada(ficha);
                                    fila.getCola().getFirst().setFicha(null);
                                    this.casilla = fila.getCola().getFirst();
                                    this.casilla.setFicha(null);
                                    return true;
                                } catch (Exception e) {
                                    //    e.printStackTrace();
                                }
                            }

                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isJugadaEncontradaColumnas(int i) throws Exception {
        for (Estructura columna : this.controladorEstructura.getEstructuraColumnas()) {
            if (columna.getCola().size() == i) {
                for (Ficha ficha : this.getArregloFichas()) {
                    if (Regla.cumpleRestriccion(columna, ficha)) {
                        if (columna.getCola().getLast().getCasillaInferior() != null) {
                            try {
                                this.controladorEstructura.agregar(columna.getCola().getLast().getCasillaInferior(), ficha);
                                this.setFichaSeleccionada(ficha);

                                columna.getCola().getLast().setFicha(null);
                                this.casilla = columna.getCola().getLast();
                                this.casilla.setFicha(null);
                                return true;
                            } catch (Exception e) {
                                // e.printStackTrace();
                            }
                        } else {
                            if (columna.getCola().getFirst().getCasillaSuperior() != null) {
                                try {
                                    this.controladorEstructura.agregar(columna.getCola().getFirst().getCasillaSuperior(), ficha);
                                    this.setFichaSeleccionada(ficha);
                                    columna.getCola().getFirst().setFicha(null);
                                    this.casilla = columna.getCola().getFirst();
                                    this.casilla.setFicha(null);

                                    return true;
                                } catch (Exception e) {
                                    //   e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

}
