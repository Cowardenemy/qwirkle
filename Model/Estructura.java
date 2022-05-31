package Model;

import java.util.Comparator;
import java.util.LinkedList;

public class Estructura {
    protected LinkedList<Casilla> colas;
    protected String restriccion;
    protected int id;
    protected static int ID = 0;

    public Estructura(Casilla casilla) {
        Estructura.ID += 1;
        this.id = Estructura.ID;
        this.colas = new LinkedList<>();
        this.colas.add(casilla);
        this.restriccion = "LIBRE";

    }


    public Estructura(Estructura estructura, Tablero tablero) {
        this.id = estructura.id;
        this.colas = new LinkedList<>();
        for (Casilla casilla : estructura.getCola()) {
            if (casilla.getFicha() != null) {
                tablero.casilla[casilla.getX()][casilla.getY()].setFicha(casilla.getFicha());
            }
            this.colas.add(tablero.casilla[casilla.getX()][casilla.getY()]);
        }
        this.restriccion = estructura.restriccion;
    }

    public int getId() {
        return this.id;
    }

    public int getID() {
        return this.ID;
    }

    public boolean addToRight(Casilla casilla, Ficha ficha) throws Exception {
        if (!this.isDuplicated(ficha)) {
            if (this.cumpleRestriccion(ficha)) {
                this.colas.addLast(casilla);
                return true;
            } else {
                return false;
            }
        } else {
            throw new Exception("LA FICHA YA HA SIDO AGREGADA EN ESTA COLA");
        }
    }

    public boolean addToLeft(Casilla casilla, Ficha ficha) throws Exception {
        if (!this.isDuplicated(ficha)) {
            if (this.cumpleRestriccion(ficha)) {
                this.colas.addFirst(casilla);
                return true;
            } else {
                return false;
            }
        } else {
            throw new Exception("LA FICHA YA HA SIDO AGREGADA EN ESTA COLA");
        }
    }

    public boolean isDuplicated(Ficha ficha) throws Exception {
        for (Casilla casilla : this.colas) {
            if (casilla.getFicha().equals(ficha)) {
                throw new Exception("LA FICHA YA HA SIDO AGREGADA EN ESTA COLA");
            }
        }
        return false;
    }

    public boolean cumpleRestriccion(Ficha ficha) throws Exception {
        switch (this.restriccion) {
            case "FORMA":
                if (!this.colas.getFirst().getFicha().getForma().equals(ficha.getForma())) {
                    throw new Exception("NO CUMPLE CON LA FORMA");
                }
                break;
            case "COLOR":
                if (!this.colas.getFirst().getFicha().getColor().equals(ficha.getColor())) {
                    throw new Exception("NO CUMPLE CON EL COLOR");
                }
                break;
        }
        return true;
    }

    public void designarRestriccion(Ficha ficha) throws Exception {
        if (this.colas.getFirst().getFicha().getColor().equals(ficha.getColor())) {
            this.restriccion = "COLOR";
        } else {
            if (this.colas.getFirst().getFicha().getForma().equals(ficha.getForma())) {
                this.restriccion = "FORMA";
            } else {
                throw new Exception("NO SE PUEDE ASIGNAR RESTRICCIÓN. NO ES NI EN COLOR O EN FORMA");
            }
        }
    }

    public void encontrarColaIzquierda() {

    }

    public void encontrarColaDerecha() {

    }

    public String getRestriccion() {
        return restriccion;
    }

    public boolean estaCondicionada() {
        if (this.restriccion.equals("LIBRE")) {
            return false;
        }
        return true;
    }

    public LinkedList<Casilla> getCola() {
        return colas;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Estructura) {
            return this.id == ((Estructura) obj).id;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Estructura{" +
                "colas=" + colas +
                ", restriccion='" + restriccion + '\'' +
                ", id=" + id +
                '}';
    }
}
