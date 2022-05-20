package Model;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jerry
 */
public class Qwirkle2 {

    public static void main(String[] args) {
        Regla regla = new Regla();

        try {
            regla.metodo1(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Juego juego = new Juego(2);
        //  juego.intercambiarFicha();

        LinkedList<String> cola = new LinkedList<>();
        LinkedList<String> cola2 = new LinkedList<>();
        ArrayList<LinkedList<String>> arreglo = new ArrayList<>();
        cola2.add("d");
        cola.add("a");
        cola.add("a");
        arreglo.add(cola2);
        arreglo.add(cola);
        ControladorEstructura controlador = new ControladorEstructura(new Casilla(10, 10));
        Bolsa bolsa = new Bolsa();

        ArrayList<Ficha> fichas = new ArrayList<>();
        fichas.add(bolsa.fichas.get(0));

        fichas.add(bolsa.fichas.get(4));
        fichas.add(bolsa.fichas.get(10));
        fichas.add(bolsa.fichas.get(14));
        fichas.add(bolsa.fichas.get(18));
        fichas.add(bolsa.fichas.get(25));
        Nodo nodoPrueba = new Nodo(controlador, fichas);
        Algoritmo algoritmo = new Algoritmo(nodoPrueba);
    }


}

