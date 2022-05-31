package Model;

import java.util.ArrayList;

public final class Regla {


    public void metodo1(int valor) throws Exception {

    }

    public static boolean cumpleRestriccion(Estructura estructura, Ficha ficha) throws Exception {
        switch (estructura.getRestriccion()) {
            case "FORMA":
                if (!estructura.getCola().getFirst().getFicha().getForma().equals(ficha.getForma())) {
                    return false;
                    //throw new Exception("NO CUMPLE CON LA FORMA");
                }
                break;
            case "COLOR":
                if (!estructura.getCola().getFirst().getFicha().getColor().equals(ficha.getColor())) {
                    return false;
                    //throw new Exception("NO CUMPLE CON EL COLOR");
                }
                break;
        }
        return true;
    }

}
