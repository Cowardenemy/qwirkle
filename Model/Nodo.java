package Model;

import java.util.ArrayList;

public class Nodo {
    private ArrayList<Nodo> nodosApuntados;
    private ControladorEstructura controlador;
    public Casilla casillaBot;
    public Ficha fichaBot;
    public ArrayList<Ficha> fichasJugador;

    public Nodo(ControladorEstructura controlador, ArrayList<Ficha> fichas) {
        this.controlador = new ControladorEstructura(controlador);
        this.nodosApuntados = new ArrayList<Nodo>();
        this.fichasJugador = new ArrayList<Ficha>();
        this.fichasJugador.addAll(fichas);
        this.fichaBot = new Ficha();
        this.casillaBot = new Casilla();
        //  this.getNodos();
    }

    public Nodo(ControladorEstructura controlador, Casilla casilla, Ficha ficha, ArrayList<Ficha> fichas) {
        this.controlador = new ControladorEstructura(controlador);
        this.casillaBot = new Casilla(casilla);
        //TODO Verificar que esta línea no afecte el funcionamiento, debe eliminar la ficha de la casilla que tiene por referencia como objeto
        this.casillaBot.setFicha(null);
        this.nodosApuntados = new ArrayList<Nodo>();
        this.fichasJugador = new ArrayList<Ficha>();
        // fichas.remove(ficha);
//        System.out.println("EN EL CONTROLADOR ESTÁ " + ficha.toString() + " Y " + casilla.toString());
        this.fichasJugador.addAll(fichas);
        this.fichaBot = ficha;
        //   this.getNodos();
    }

    public ArrayList<Nodo> getNodosApuntados() {
        return nodosApuntados;
    }

    public ControladorEstructura getControlador() {
        return controlador;
    }


    public Casilla getCasillaBot() {
        return casillaBot;
    }

    public Ficha getFichaBot() {
        return fichaBot;
    }

    public int cantidadFichasAfectadas() {
        int cantidad = 0;
        for (Estructura estructura : this.controlador.getUltimasEstructurasModificadas()) {
            cantidad = cantidad + estructura.getCola().size();
        }
        return cantidad;
    }


    public ArrayList<Nodo> getNodos() {
        for (Ficha ficha : this.fichasJugador) {
            for (Estructura fila : this.controlador.getEstructuraFilas()) {
                if (fila.getCola().getLast().getCasillaDerecha() != null) {
                    try {
                        ControladorEstructura controladorAuxiliar = new ControladorEstructura(controlador);
                        Casilla casillita = new Casilla(fila.getCola().getLast().getCasillaDerecha());
                            controladorAuxiliar.agregar(casillita, ficha);
                        casillita.setFicha(ficha);
//                        this.fichaBot = ficha;
//                        this.casillaBot = fila.getCola().getLast();
                        this.nodosApuntados.add(new Nodo(controladorAuxiliar, casillita, ficha, fichasJugador));
                    } catch (Exception e) {
                        //   e.printStackTrace();
                    }
                }
                if (fila.getCola().getFirst().getCasillaIzquierda() != null) {

                    try {
                        ControladorEstructura controladorAuxiliar = new ControladorEstructura(controlador);

                        Casilla casillita = new Casilla(fila.getCola().getFirst().getCasillaIzquierda());
                        controladorAuxiliar.agregar(casillita, ficha);
                        casillita.setFicha(ficha);
//                        fichaBot = ficha;
//                        this.casillaBot = fila.getCola().getFirst();
                        this.nodosApuntados.add(new Nodo(controladorAuxiliar, casillita, ficha, fichasJugador));
                    } catch (Exception e) {
                        //    e.printStackTrace();
                    }
                }


            }
            for (Estructura columna : this.controlador.getEstructuraColumnas()) {
                if (columna.getCola().getLast().getCasillaInferior() != null) {
                    try {
                        ControladorEstructura controladorAuxiliar = new ControladorEstructura(controlador);
                        Casilla casillita = new Casilla(columna.getCola().getLast().getCasillaInferior());
                        controladorAuxiliar.agregar(casillita, ficha);
                        casillita.setFicha(ficha);
//                        this.fichaBot = ficha;
//                        this.casillaBot = fila.getCola().getLast();
                        this.nodosApuntados.add(new Nodo(controladorAuxiliar, casillita, ficha, fichasJugador));
                    } catch (Exception e) {
                        //   e.printStackTrace();
                    }
                }
                if (columna.getCola().getFirst().getCasillaSuperior()   != null) {

                    try {
                        ControladorEstructura controladorAuxiliar = new ControladorEstructura(controlador);

                        Casilla casillita = new Casilla(columna.getCola().getFirst().getCasillaSuperior());
                        controladorAuxiliar.agregar(casillita, ficha);
                        casillita.setFicha(ficha);
//                        fichaBot = ficha;
//                        this.casillaBot = fila.getCola().getFirst();
                        this.nodosApuntados.add(new Nodo(controladorAuxiliar, casillita, ficha, fichasJugador));
                    } catch (Exception e) {
                        //    e.printStackTrace();
                    }
                }


            }
        }
        return this.nodosApuntados;
    }
}
