
package Model;

import java.util.ArrayList;
import java.util.Stack;

public class Algoritmo {
    private Nodo nodoInicial;


    private Stack<Nodo> nodosVisitados = new Stack();
    public ArrayList<Nodo> mejorRuta = new ArrayList();
    private Stack<Nodo> rutaActual = new Stack();
    int mejorPuntaje = 0;

    public Algoritmo(Nodo nodo) {
        this.nodoInicial = nodo;
        this.ejecutar(this.nodoInicial);
    }

    public void ejecutar(Nodo nodoActual) {
        if (!nodosVisitados.contains(nodoActual)) {
            this.nodosVisitados.add(nodoActual);
            this.rutaActual.add(nodoActual);
            for (Nodo nodoHijo : nodoActual.getNodos()) {
//                        rutaActual.add(nodoHijo);
                // this.nodosVisitados.add(nodoHijo);
                // this.detectarRutaCorta(rutaActual);
                this.ejecutar(nodoHijo);
            }
//                this.nodosVisitados.add(nodoActual);
//                this.detectarRutaCorta(rutaActual);
            if (!this.rutaActual.isEmpty()) {
                this.detectarRutaCorta(rutaActual);

                for (int i = 1; i < nodosVisitados.size(); i++) {
                    System.out.println(nodosVisitados.get(i).casillaBot.toString());
                }
                System.out.println("RETROCEDE");
                this.rutaActual.pop();
                this.nodosVisitados.pop();
            }
            return;
        }
    }

    public void detectarRutaCorta(Stack<Nodo> rutaActual) {
        System.out.println("ENTRA EN MÉTODO DETECTAR RUTA");
        if (mejorRuta.isEmpty()) {
            for (Nodo nodo : rutaActual) {
                this.mejorRuta.add(new Nodo(nodo.getControlador(), nodo.casillaBot, nodo.fichaBot, nodo.fichasJugador));
            }
            this.mejorPuntaje = rutaActual.get(rutaActual.size() - 1).cantidadFichasAfectadas();
        } else if (this.mejorPuntaje < rutaActual.get(rutaActual.size() - 1).cantidadFichasAfectadas()) {
            System.out.println("PUNTOS DE MEJOR RUTA: " + this.mejorPuntaje + " PUNTOS DE RUTA ACTUAL: " + rutaActual.get(rutaActual.size() - 1).cantidadFichasAfectadas());
            mejorRuta.clear();
            for (Nodo nodo : rutaActual) {
                this.mejorRuta.add(new Nodo(nodo.getControlador(), nodo.casillaBot, nodo.fichaBot, nodo.fichasJugador));
            }
            this.mejorPuntaje = rutaActual.get(rutaActual.size() - 1).cantidadFichasAfectadas();
        }
        System.out.println("PUNTOS DE MEJOR RUTA: " + this.mejorPuntaje + " PUNTOS DE RUTA ACTUAL: " + rutaActual.get(rutaActual.size() - 1).cantidadFichasAfectadas());
    }

    public void imprimirMejorRuta() {
        System.out.println("IMPRIMIENDO MEJOR RUTA");
        System.out.println("PUNTOS ALCANZADOS SON: " + this.mejorPuntaje);
        if (mejorRuta.isEmpty()) {
            System.out.println("OBJETIVO ALCANZADO");

        } else {
            System.out.println("LONGITUD DE LA RUTA ES:" + this.mejorRuta.size());
            for (Nodo nodo : mejorRuta) {
                if (nodo == null) {
                    System.out.println("es nulo");
                } else {
                    System.out.println(nodo.fichaBot.toString() + " Y " + nodo.casillaBot.toString());
                }
            }
            System.out.println("--------------");
        }
    }

  /*  public void imprimirPila() {
        for (Jugador nodosVisitado : nodosVisitados) {
            System.out.println(nodosVisitado.toString());
        }
        System.out.println("--------------");
    }*/
}

