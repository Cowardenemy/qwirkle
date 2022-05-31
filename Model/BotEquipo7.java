package Model;

import javax.swing.*;
import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;

public class BotEquipo6 extends Bot {
    private Casilla casillaHeuristica;
    private String estructuraHeuristica;
    private int ciclos = 0;

    public BotEquipo7() {
        super("Bot Equipo 7");
    }

    @Override
    public void analizarEstrategia() throws Exception {
        this.definirLinea();
    }


    public Estructura buscarColumna() throws Exception {
        for (Estructura columna : this.controladorEstructura.getEstructuraColumnas()) {
            if (columna.getCola().contains(this.casillaHeuristica) && columna.getCola().size() < 6) {
                return columna;
            } else {
//                this.definirLinea();
//                JOptionPane.showMessageDialog(null, "YA FINALIZÓ");
                throw new Exception("LA ESTRUCTURA YA TIENE 6 FICHAS");
            }
        }
        throw new Exception("NO ENCONTRÓ LA FICHA AGREGADA EN LAS ESTRUCTURAS");
    }

    public Estructura buscarFila() throws Exception {
        for (Estructura fila : this.controladorEstructura.getEstructuraFilas()) {
            if (fila.getCola().contains(this.casillaHeuristica) && fila.getCola().size() < 6) {
                return fila;
            } else {
                JOptionPane.showMessageDialog(null, "YA FINALIZÓ");
//                this.definirLinea();
                throw new Exception("LA ESTRUCTURA YA TIENE 6 FICHAS");
            }
        }
        throw new Exception("NO ENCONTRÓ LA FICHA AGREGADA EN LAS ESTRUCTURAS");
    }
//Se usa para cuando no su línea original ya ha sido ocupada y necesita buscar una nueva
    public boolean definirLinea() {
        for (Estructura fila : this.controladorEstructura.getEstructuraFilas()) {
            if (fila.getRestriccion().equals("FORMA")) {
                for (Ficha ficha : this.getArregloFichas()) {
                    try {
                        this.controladorEstructura.agregar(fila.getCola().getLast().getCasillaDerecha(), ficha);
                        this.setFichaSeleccionada(ficha);
                        fila.getCola().getLast().setFicha(null);
                        this.casilla = fila.getCola().getLast();
                        this.cambioFichaDisponible = false;
                        return true;
                    } catch (Exception e) {
                        //   e.printStackTrace();
                    }
                    try {
                        this.controladorEstructura.agregar(fila.getCola().getFirst().getCasillaIzquierda(), ficha);
                        this.setFichaSeleccionada(ficha);
                        fila.getCola().getFirst().setFicha(null);
                        this.casilla = fila.getCola().getFirst();
                        this.cambioFichaDisponible = false;
                        return true;
                    } catch (Exception e) {
                        //   e.printStackTrace();
                    }
                }
            }
        }
        for (Estructura columna : this.controladorEstructura.getEstructuraColumnas()) {
            if (columna.getRestriccion().equals("FORMA")) {
                for (Ficha ficha : this.getArregloFichas()) {
                    try {
                        this.controladorEstructura.agregar(columna.getCola().getLast().getCasillaInferior(), ficha);
                        this.setFichaSeleccionada(ficha);
                        columna.getCola().getLast().setFicha(null);
                        this.casilla = columna.getCola().getLast();
                        this.cambioFichaDisponible = false;
                        return true;

                    } catch (Exception e) {
                        //   e.printStackTrace();
                    }
                    try {
                        this.controladorEstructura.agregar(columna.getCola().getFirst().getCasillaSuperior(), ficha);
                        this.setFichaSeleccionada(ficha);
                        columna.getCola().getFirst().setFicha(null);
                        this.casilla = columna.getCola().getFirst();
                        this.cambioFichaDisponible = false;
                        return true;
                    } catch (Exception e) {
                        //   e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void iniciarPartida() {
        this.setFichaSeleccionada(this.fichas.get(2));
        this.casilla = new Casilla(12, 8);
        this.casillaHeuristica = casilla;
    }

    @Override
    public ArrayList<Ficha> cambiarFichas() {
        System.out.println("ENTRA EN MÉTODO DE CAMBIAR FICHAS");
        ArrayList<Ficha> arregloCambioFichas = new ArrayList<>();
        arregloCambioFichas.add(this.fichas.get(1));
        this.removerFicha(this.fichas.get(1));
        arregloCambioFichas.add(this.fichas.get(3));
        this.removerFicha(this.fichas.get(3));
        arregloCambioFichas.add(this.fichas.get(4));
        this.removerFicha(this.fichas.get(4));
        return arregloCambioFichas;
    }
}
