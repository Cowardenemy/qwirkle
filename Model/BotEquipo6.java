package Model;

import javax.swing.*;
import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;

public class BotEquipo6 extends Bot {
    private Casilla casillaHeuristica;
    private String estructuraHeuristica;
    private int ciclos = 0;

    public BotEquipo6() {
        super("Bot Equipo 6");
    }

    @Override
    public void analizarEstrategia() throws Exception {
//        System.out.println("impresión de ciclos: " + ciclos);
        ciclos++;

        if (ciclos == 60) {
//            sirve para reasignar la heurísticapara evitar quedarse en ella para siempre
//            JOptionPane.showMessageDialog(null, "EL BOT 6 HA CAMBIADO SU LÍNEA ");
            this.definirLinea();
            ciclos = 0;
        }
        if (casillaHeuristica == null) {
            this.definirLinea();
        } else {
            if (estructuraHeuristica.equals("FILA")) {
                this.insertarEnLineaFila(this.buscarFila());
            } else {
                if (estructuraHeuristica.equals("COLUMNA")) {
                    this.insertarEnLineaColumna(this.buscarColumna());
                }
            }
        }
        if (this.casilla == null) {
//                    DEBE BUSCAR CUALQUIER ESTRUCTURA PARA PONER ALGUNA FICHA
//            JOptionPane.showMessageDialog(null, "entra en nuevo método ");
            this.colocarFichaEnOtraEstructura();
        }
        if (this.cambioFichaDisponible && this.iterador == 5) {
//            System.out.println("VA A CAMBIAR FICHAS PORQUE NO HA ENCONTRADO PARA PONER");
//            this.cambiarFichas();
        }
    }

    public void colocarFichaEnOtraEstructura() throws Exception {
        for (Ficha ficha : this.fichas) {
            for (Estructura fila : this.controladorEstructura.getEstructuraFilas()) {
                if (fila.getCola().getLast().getCasillaDerecha() != null) {
                    try {
                        this.controladorEstructura.agregar(fila.getCola().getLast().getCasillaDerecha(), ficha);
                        this.setFichaSeleccionada(ficha);
                        fila.getCola().getLast().setFicha(null);
                        this.casilla = fila.getCola().getLast();
                        this.cambioFichaDisponible = false;
//                        System.out.println("EL BOT 7 HA AGREGADO EN EL NUEVO MÉTODO");
                        return;
                    } catch (Exception e) {

                    }
                }
                if (fila.getCola().getFirst().getCasillaIzquierda() != null) {
                    try {
                        this.controladorEstructura.agregar(fila.getCola().getFirst().getCasillaIzquierda(), ficha);
                        this.setFichaSeleccionada(ficha);
                        fila.getCola().getFirst().setFicha(null);
                        this.casilla = fila.getCola().getFirst();
                        this.cambioFichaDisponible = false;
//                        System.out.println("EL BOT 7 HA AGREGADO EN EL NUEVO MÉTODO");
                        return;
                    } catch (Exception e) {

                    }
                }
            }
            for (Estructura columna : this.controladorEstructura.getEstructuraColumnas()) {
                if (columna.getCola().getLast().getCasillaInferior() != null) {
                    try {
                        this.controladorEstructura.agregar(columna.getCola().getLast().getCasillaInferior(), ficha);
                        this.setFichaSeleccionada(ficha);
                        columna.getCola().getLast().setFicha(null);
                        this.casilla = columna.getCola().getLast();
                        this.casilla.setFicha(null);
                        this.cambioFichaDisponible = false;
//                        System.out.println("EL BOT 7 HA AGREGADO EN EL NUEVO MÉTODO");
                        return;
                    } catch (Exception e) {

                    }
                }
                if (columna.getCola().getFirst().getCasillaSuperior() != null) {
                    try {
                        this.controladorEstructura.agregar(columna.getCola().getFirst().getCasillaSuperior(), ficha);
                        this.setFichaSeleccionada(ficha);
                        columna.getCola().getFirst().setFicha(null);
                        this.casilla = columna.getCola().getFirst();
                        this.casilla.setFicha(null);
                        this.cambioFichaDisponible = false;
//                        System.out.println("EL BOT 7 HA AGREGADO EN EL NUEVO MÉTODO");
                        return;
                    } catch (Exception e) {

                    }
                }
            }
        }
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

    public boolean insertarEnLineaColumna(Estructura estructura) {
        //BUSCA INSERTAR EN COLUMNAS
        for (Ficha ficha : this.getArregloFichas()) {
            try {
                this.controladorEstructura.agregar(estructura.getCola().getLast().getCasillaInferior(), ficha);
                this.setFichaSeleccionada(ficha);
                estructura.getCola().getLast().setFicha(null);
                this.casilla = estructura.getCola().getLast();
//                System.out.println("UTILIZA EL MÉTODO PROPIO DE INSERTAR");
//                JOptionPane.showMessageDialog(null, "USA EL MÉTODO NORMAL");

                return true;
            } catch (Exception e) {
                //   e.printStackTrace();
            }
            try {
                this.controladorEstructura.agregar(estructura.getCola().getFirst().getCasillaSuperior(), ficha);
                this.setFichaSeleccionada(ficha);
                estructura.getCola().getFirst().setFicha(null);
                this.casilla = estructura.getCola().getFirst();
//                System.out.println("UTILIZA EL MÉTODO PROPIO DE INSERTAR");
//                JOptionPane.showMessageDialog(null, "USA EL MÉTODO NORMAL");


                return true;
            } catch (Exception e) {
                //   e.printStackTrace();
            }
        }
        return false;
    }

    public boolean insertarEnLineaFila(Estructura estructura) {
        for (Ficha ficha : this.getArregloFichas()) {
            try {
                this.controladorEstructura.agregar(estructura.getCola().getLast().getCasillaDerecha(), ficha);
                this.setFichaSeleccionada(ficha);
                estructura.getCola().getLast().setFicha(null);
                this.casilla = estructura.getCola().getLast();
//                System.out.println("UTILIZA EL MÉTODO PROPIO DE INSERTAR");
//                JOptionPane.showMessageDialog(null, "USA EL MÉTODO NORMAL");
                return true;
            } catch (Exception e) {
                //   e.printStackTrace();
            }
            try {
                this.controladorEstructura.agregar(estructura.getCola().getFirst().getCasillaIzquierda(), ficha);
                this.setFichaSeleccionada(ficha);
                estructura.getCola().getFirst().setFicha(null);
                this.casilla = estructura.getCola().getFirst();
//                System.out.println("UTILIZA EL MÉTODO PROPIO DE INSERTAR");
//                JOptionPane.showMessageDialog(null, "USA EL MÉTODO NORMAL");

                return true;
            } catch (Exception e) {
                //   e.printStackTrace();
            }

        }
        return false;
    }

    //Se usa para cuando no su línea original ya ha sido ocupada y necesita buscar una nueva
    public boolean definirLinea() {
        for (Estructura fila : this.controladorEstructura.getEstructuraFilas()) {
            for (Ficha ficha : this.getArregloFichas()) {
                try {
                    this.controladorEstructura.agregar(fila.getCola().getLast().getCasillaDerecha(), ficha);
                    this.setFichaSeleccionada(ficha);
                    fila.getCola().getLast().setFicha(null);
                    this.casilla = fila.getCola().getLast();
                    this.casillaHeuristica = this.casilla;
                    this.estructuraHeuristica = "FILA";
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
                    this.estructuraHeuristica = "FILA";
                    this.casillaHeuristica = this.casilla;
                    this.cambioFichaDisponible = false;
                    return true;
                } catch (Exception e) {
                    //   e.printStackTrace();
                }
            }
        }
        for (Estructura columna : this.controladorEstructura.getEstructuraColumnas()) {
            for (Ficha ficha : this.getArregloFichas()) {
                try {
                    this.controladorEstructura.agregar(columna.getCola().getLast().getCasillaInferior(), ficha);
                    this.setFichaSeleccionada(ficha);
                    columna.getCola().getLast().setFicha(null);
                    this.casilla = columna.getCola().getLast();
                    this.estructuraHeuristica = "COLUMNA";
                    this.casillaHeuristica = this.casilla;
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
                    this.estructuraHeuristica = "COLUMNA";
                    this.casillaHeuristica = this.casilla;
                    this.cambioFichaDisponible = false;
                    return true;
                } catch (Exception e) {
                    //   e.printStackTrace();
                }
            }
        }

        return false;
    }

    //Se define la mejor estructura para cuando se juega en primer turno
    public void detectarUltimaMejorEstructura() {

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
