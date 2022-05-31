
package Model;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author jerry
 */
public class Bolsa {

    public ArrayList<Ficha> fichas;
    private static String formas[] = {"cuadrado", "circulo", "rombo", "trebol", "tacha", "estrella"};
    private static String colores[] = {"verde", "rojo", "morado", "amarillo", "azul", "naranja"};

    public Bolsa() {
        this.fichas = new ArrayList<>();

        for (String forma : formas) {
            for (String color : colores) {
                for (int i = 0; i < 3; i++) {
                    this.fichas.add(new Ficha(forma, color));
                }
            }
        }
        System.out.println("CANTIDAD DE FICHAS CREADAS: " + fichas.size());
    }

    public Ficha darFicha() throws Exception {
        if (!this.fichas.isEmpty()) {
            Random rand = new Random();//método que devuelve una ficha y la elimina del arreglo
            int i;
            i = rand.nextInt(this.fichas.size());
            return this.fichas.remove(i);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No hay más fichas");
            alert.setHeaderText(null);
            alert.setContentText("Ya no hay más fichas en la bolsa");
            alert.showAndWait();
            throw new Exception("NO HAY MÁS FICHAS EN LA BOLSA");
        }
    }
//MÉTODO DE INTERCAMBIO DE FICHAS. POSIBLE MODIFICACIÓN

    public Ficha recibirFicha(Ficha fichaDeCambio) throws Exception {

        Ficha fichaDeCambio2 = this.darFicha();
        this.fichas.add(fichaDeCambio);
        return fichaDeCambio2;

    }
}
