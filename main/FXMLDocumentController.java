package main;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;

public class FXMLDocumentController {
    @FXML
    public ListView<String> listaPuntajesJugador;
    @FXML
    public Label labelJugadorEnTurno;
    @FXML
    public Button botonTerminar;
    @FXML
    private Label label;

    @FXML
    private Button cambio;

    @FXML
    private ImageView casilla_0_0;

    @FXML
    private ImageView casilla_1_0;

    @FXML
    private ImageView casilla_2_0;

    @FXML
    private ImageView casilla_3_0;

    @FXML
    private ImageView casilla_4_0;

    @FXML
    private ImageView casilla_5_0;

    @FXML
    private ImageView casilla_6_0;

    @FXML
    private ImageView casilla_7_0;

    @FXML
    private ImageView casilla_8_0;

    @FXML
    private ImageView casilla_9_0;

    @FXML
    private ImageView casilla_10_0;

    @FXML
    private ImageView casilla_11_0;

    @FXML
    private ImageView casilla_12_0;

    @FXML
    private ImageView casilla_13_0;

    @FXML
    private ImageView casilla_14_0;

    @FXML
    private ImageView casilla_15_0;

    @FXML
    private ImageView casilla_16_0;

    @FXML
    private ImageView casilla_17_0;

    @FXML
    private ImageView casilla_0_1;

    @FXML
    private ImageView casilla_1_1;

    @FXML
    private ImageView casilla_2_1;

    @FXML
    private ImageView casilla_3_1;

    @FXML
    private ImageView casilla_4_1;

    @FXML
    private ImageView casilla_5_1;

    @FXML
    private ImageView casilla_6_1;

    @FXML
    private ImageView casilla_7_1;

    @FXML
    private ImageView casilla_8_1;

    @FXML
    private ImageView casilla_9_1;

    @FXML
    private ImageView casilla_10_1;

    @FXML
    private ImageView casilla_11_1;

    @FXML
    private ImageView casilla_12_1;

    @FXML
    private ImageView casilla_13_1;

    @FXML
    private ImageView casilla_14_1;

    @FXML
    private ImageView casilla_15_1;

    @FXML
    private ImageView casilla_16_1;

    @FXML
    private ImageView casilla_17_1;

    @FXML
    private ImageView casilla_0_2;

    @FXML
    private ImageView casilla_1_2;

    @FXML
    private ImageView casilla_2_2;

    @FXML
    private ImageView casilla_3_2;

    @FXML
    private ImageView casilla_4_2;

    @FXML
    private ImageView casilla_5_2;

    @FXML
    private ImageView casilla_6_2;

    @FXML
    private ImageView casilla_7_2;

    @FXML
    private ImageView casilla_8_2;

    @FXML
    private ImageView casilla_9_2;

    @FXML
    private ImageView casilla_10_2;

    @FXML
    private ImageView casilla_11_2;

    @FXML
    private ImageView casilla_12_2;

    @FXML
    private ImageView casilla_13_2;

    @FXML
    private ImageView casilla_14_2;

    @FXML
    private ImageView casilla_15_2;

    @FXML
    private ImageView casilla_16_2;

    @FXML
    private ImageView casilla_17_2;

    @FXML
    private ImageView casilla_0_3;

    @FXML
    private ImageView casilla_1_3;

    @FXML
    private ImageView casilla_2_3;

    @FXML
    private ImageView casilla_3_3;

    @FXML
    private ImageView casilla_4_3;

    @FXML
    private ImageView casilla_5_3;

    @FXML
    private ImageView casilla_6_3;

    @FXML
    private ImageView casilla_7_3;

    @FXML
    private ImageView casilla_8_3;

    @FXML
    private ImageView casilla_9_3;

    @FXML
    private ImageView casilla_10_3;

    @FXML
    private ImageView casilla_11_3;

    @FXML
    private ImageView casilla_12_3;

    @FXML
    private ImageView casilla_13_3;

    @FXML
    private ImageView casilla_14_3;

    @FXML
    private ImageView casilla_15_3;

    @FXML
    private ImageView casilla_16_3;

    @FXML
    private ImageView casilla_17_3;

    @FXML
    private ImageView casilla_0_4;

    @FXML
    private ImageView casilla_1_4;

    @FXML
    private ImageView casilla_2_4;

    @FXML
    private ImageView casilla_3_4;

    @FXML
    private ImageView casilla_4_4;

    @FXML
    private ImageView casilla_5_4;

    @FXML
    private ImageView casilla_6_4;

    @FXML
    private ImageView casilla_7_4;

    @FXML
    private ImageView casilla_8_4;

    @FXML
    private ImageView casilla_9_4;

    @FXML
    private ImageView casilla_10_4;

    @FXML
    private ImageView casilla_11_4;

    @FXML
    private ImageView casilla_12_4;

    @FXML
    private ImageView casilla_13_4;

    @FXML
    private ImageView casilla_14_4;

    @FXML
    private ImageView casilla_15_4;

    @FXML
    private ImageView casilla_16_4;

    @FXML
    private ImageView casilla_17_4;

    @FXML
    private ImageView casilla_0_5;

    @FXML
    private ImageView casilla_1_5;

    @FXML
    private ImageView casilla_2_5;

    @FXML
    private ImageView casilla_3_5;

    @FXML
    private ImageView casilla_4_5;

    @FXML
    private ImageView casilla_5_5;

    @FXML
    private ImageView casilla_6_5;

    @FXML
    private ImageView casilla_7_5;

    @FXML
    private ImageView casilla_8_5;

    @FXML
    private ImageView casilla_9_5;

    @FXML
    private ImageView casilla_10_5;

    @FXML
    private ImageView casilla_11_5;

    @FXML
    private ImageView casilla_12_5;

    @FXML
    private ImageView casilla_13_5;

    @FXML
    private ImageView casilla_14_5;

    @FXML
    private ImageView casilla_15_5;

    @FXML
    private ImageView casilla_16_5;

    @FXML
    private ImageView casilla_17_5;

    @FXML
    private ImageView casilla_0_6;

    @FXML
    private ImageView casilla_1_6;

    @FXML
    private ImageView casilla_2_6;

    @FXML
    private ImageView casilla_3_6;

    @FXML
    private ImageView casilla_4_6;

    @FXML
    private ImageView casilla_5_6;

    @FXML
    private ImageView casilla_6_6;

    @FXML
    private ImageView casilla_7_6;

    @FXML
    private ImageView casilla_8_6;

    @FXML
    private ImageView casilla_9_6;

    @FXML
    private ImageView casilla_10_6;

    @FXML
    private ImageView casilla_11_6;

    @FXML
    private ImageView casilla_12_6;

    @FXML
    private ImageView casilla_13_6;

    @FXML
    private ImageView casilla_14_6;

    @FXML
    private ImageView casilla_15_6;

    @FXML
    private ImageView casilla_16_6;

    @FXML
    private ImageView casilla_17_6;

    @FXML
    private ImageView casilla_0_7;

    @FXML
    private ImageView casilla_1_7;

    @FXML
    private ImageView casilla_2_7;

    @FXML
    private ImageView casilla_3_7;

    @FXML
    private ImageView casilla_4_7;

    @FXML
    private ImageView casilla_5_7;

    @FXML
    private ImageView casilla_6_7;

    @FXML
    private ImageView casilla_7_7;

    @FXML
    private ImageView casilla_8_7;

    @FXML
    private ImageView casilla_9_7;

    @FXML
    private ImageView casilla_10_7;

    @FXML
    private ImageView casilla_11_7;

    @FXML
    private ImageView casilla_12_7;

    @FXML
    private ImageView casilla_13_7;

    @FXML
    private ImageView casilla_14_7;

    @FXML
    private ImageView casilla_15_7;

    @FXML
    private ImageView casilla_16_7;

    @FXML
    private ImageView casilla_17_7;

    @FXML
    private ImageView casilla_0_8;

    @FXML
    private ImageView casilla_1_8;

    @FXML
    private ImageView casilla_2_8;

    @FXML
    private ImageView casilla_3_8;

    @FXML
    private ImageView casilla_4_8;

    @FXML
    private ImageView casilla_5_8;

    @FXML
    private ImageView casilla_6_8;

    @FXML
    private ImageView casilla_7_8;

    @FXML
    private ImageView casilla_8_8;

    @FXML
    private ImageView casilla_9_8;

    @FXML
    private ImageView casilla_10_8;

    @FXML
    private ImageView casilla_11_8;

    @FXML
    private ImageView casilla_12_8;

    @FXML
    private ImageView casilla_13_8;

    @FXML
    private ImageView casilla_14_8;

    @FXML
    private ImageView casilla_15_8;

    @FXML
    private ImageView casilla_16_8;

    @FXML
    private ImageView casilla_17_8;

    @FXML
    private ImageView casilla_0_9;

    @FXML
    private ImageView casilla_1_9;

    @FXML
    private ImageView casilla_2_9;

    @FXML
    private ImageView casilla_3_9;

    @FXML
    private ImageView casilla_4_9;

    @FXML
    private ImageView casilla_5_9;

    @FXML
    private ImageView casilla_6_9;

    @FXML
    private ImageView casilla_7_9;

    @FXML
    private ImageView casilla_8_9;

    @FXML
    private ImageView casilla_9_9;

    @FXML
    private ImageView casilla_10_9;

    @FXML
    private ImageView casilla_11_9;

    @FXML
    private ImageView casilla_12_9;

    @FXML
    private ImageView casilla_13_9;

    @FXML
    private ImageView casilla_14_9;

    @FXML
    private ImageView casilla_15_9;

    @FXML
    private ImageView casilla_16_9;

    @FXML
    private ImageView casilla_17_9;

    @FXML
    private ImageView casilla_0_10;

    @FXML
    private ImageView casilla_1_10;

    @FXML
    private ImageView casilla_2_10;

    @FXML
    private ImageView casilla_3_10;

    @FXML
    private ImageView casilla_4_10;

    @FXML
    private ImageView casilla_5_10;

    @FXML
    private ImageView casilla_6_10;

    @FXML
    private ImageView casilla_7_10;

    @FXML
    private ImageView casilla_8_10;

    @FXML
    private ImageView casilla_9_10;

    @FXML
    private ImageView casilla_10_10;

    @FXML
    private ImageView casilla_11_10;

    @FXML
    private ImageView casilla_12_10;

    @FXML
    private ImageView casilla_13_10;

    @FXML
    private ImageView casilla_14_10;

    @FXML
    private ImageView casilla_15_10;

    @FXML
    private ImageView casilla_16_10;

    @FXML
    private ImageView casilla_17_10;

    @FXML
    private ImageView casilla_0_11;

    @FXML
    private ImageView casilla_1_11;

    @FXML
    private ImageView casilla_2_11;

    @FXML
    private ImageView casilla_3_11;

    @FXML
    private ImageView casilla_4_11;

    @FXML
    private ImageView casilla_5_11;

    @FXML
    private ImageView casilla_6_11;

    @FXML
    private ImageView casilla_7_11;

    @FXML
    private ImageView casilla_8_11;

    @FXML
    private ImageView casilla_9_11;

    @FXML
    private ImageView casilla_10_11;

    @FXML
    private ImageView casilla_11_11;

    @FXML
    private ImageView casilla_12_11;

    @FXML
    private ImageView casilla_13_11;

    @FXML
    private ImageView casilla_14_11;

    @FXML
    private ImageView casilla_15_11;

    @FXML
    private ImageView casilla_16_11;

    @FXML
    private ImageView casilla_17_11;

    @FXML
    private ImageView casilla_0_12;

    @FXML
    private ImageView casilla_1_12;

    @FXML
    private ImageView casilla_2_12;

    @FXML
    private ImageView casilla_3_12;

    @FXML
    private ImageView casilla_4_12;

    @FXML
    private ImageView casilla_5_12;

    @FXML
    private ImageView casilla_6_12;

    @FXML
    private ImageView casilla_7_12;

    @FXML
    private ImageView casilla_8_12;

    @FXML
    private ImageView casilla_9_12;

    @FXML
    private ImageView casilla_10_12;

    @FXML
    private ImageView casilla_11_12;

    @FXML
    private ImageView casilla_12_12;

    @FXML
    private ImageView casilla_13_12;

    @FXML
    private ImageView casilla_14_12;

    @FXML
    private ImageView casilla_15_12;

    @FXML
    private ImageView casilla_16_12;

    @FXML
    private ImageView casilla_17_12;

    @FXML
    private ImageView casilla_0_13;

    @FXML
    private ImageView casilla_1_13;

    @FXML
    private ImageView casilla_2_13;

    @FXML
    private ImageView casilla_3_13;

    @FXML
    private ImageView casilla_4_13;

    @FXML
    private ImageView casilla_5_13;

    @FXML
    private ImageView casilla_6_13;

    @FXML
    private ImageView casilla_7_13;

    @FXML
    private ImageView casilla_8_13;

    @FXML
    private ImageView casilla_9_13;

    @FXML
    private ImageView casilla_10_13;

    @FXML
    private ImageView casilla_11_13;

    @FXML
    private ImageView casilla_12_13;

    @FXML
    private ImageView casilla_13_13;

    @FXML
    private ImageView casilla_14_13;

    @FXML
    private ImageView casilla_15_13;

    @FXML
    private ImageView casilla_16_13;

    @FXML
    private ImageView casilla_17_13;

    @FXML
    private ImageView casilla_0_14;

    @FXML
    private ImageView casilla_1_14;

    @FXML
    private ImageView casilla_2_14;

    @FXML
    private ImageView casilla_3_14;

    @FXML
    private ImageView casilla_4_14;

    @FXML
    private ImageView casilla_5_14;

    @FXML
    private ImageView casilla_6_14;

    @FXML
    private ImageView casilla_7_14;

    @FXML
    private ImageView casilla_8_14;

    @FXML
    private ImageView casilla_9_14;

    @FXML
    private ImageView casilla_10_14;

    @FXML
    private ImageView casilla_11_14;

    @FXML
    private ImageView casilla_12_14;

    @FXML
    private ImageView casilla_13_14;

    @FXML
    private ImageView casilla_14_14;

    @FXML
    private ImageView casilla_15_14;

    @FXML
    private ImageView casilla_16_14;

    @FXML
    private ImageView casilla_17_14;

    @FXML
    private ImageView casilla_0_15;

    @FXML
    private ImageView casilla_1_15;

    @FXML
    private ImageView casilla_2_15;

    @FXML
    private ImageView casilla_3_15;

    @FXML
    private ImageView casilla_4_15;

    @FXML
    private ImageView casilla_5_15;

    @FXML
    private ImageView casilla_6_15;

    @FXML
    private ImageView casilla_7_15;

    @FXML
    private ImageView casilla_8_15;

    @FXML
    private ImageView casilla_9_15;

    @FXML
    private ImageView casilla_10_15;

    @FXML
    private ImageView casilla_11_15;

    @FXML
    private ImageView casilla_12_15;

    @FXML
    private ImageView casilla_13_15;

    @FXML
    private ImageView casilla_14_15;

    @FXML
    private ImageView casilla_15_15;

    @FXML
    private ImageView casilla_16_15;

    @FXML
    private ImageView casilla_17_15;

    @FXML
    private ImageView casilla_0_16;

    @FXML
    private ImageView casilla_1_16;

    @FXML
    private ImageView casilla_2_16;

    @FXML
    private ImageView casilla_3_16;

    @FXML
    private ImageView casilla_4_16;

    @FXML
    private ImageView casilla_5_16;

    @FXML
    private ImageView casilla_6_16;

    @FXML
    private ImageView casilla_7_16;

    @FXML
    private ImageView casilla_8_16;

    @FXML
    private ImageView casilla_9_16;

    @FXML
    private ImageView casilla_10_16;

    @FXML
    private ImageView casilla_11_16;

    @FXML
    private ImageView casilla_12_16;

    @FXML
    private ImageView casilla_13_16;

    @FXML
    private ImageView casilla_14_16;

    @FXML
    private ImageView casilla_15_16;

    @FXML
    private ImageView casilla_16_16;

    @FXML
    private ImageView casilla_17_16;

    @FXML
    private ImageView casilla_0_17;

    @FXML
    private ImageView casilla_1_17;

    @FXML
    private ImageView casilla_2_17;

    @FXML
    private ImageView casilla_3_17;

    @FXML
    private ImageView casilla_4_17;

    @FXML
    private ImageView casilla_5_17;

    @FXML
    private ImageView casilla_6_17;

    @FXML
    private ImageView casilla_7_17;

    @FXML
    private ImageView casilla_8_17;

    @FXML
    private ImageView casilla_9_17;

    @FXML
    private ImageView casilla_10_17;

    @FXML
    private ImageView casilla_11_17;

    @FXML
    private ImageView casilla_12_17;

    @FXML
    private ImageView casilla_13_17;

    @FXML
    private ImageView casilla_14_17;

    @FXML
    private ImageView casilla_15_17;

    @FXML
    private ImageView casilla_16_17;

    @FXML
    private ImageView casilla_17_17;

    @FXML
    private Label pj1;

    @FXML
    private Label pj2;

    @FXML
    private Label pj3;

    @FXML
    private Label pj4;

    @FXML
    private ImageView imgperfil;

    @FXML
    private ImageView ficha_n1;

    @FXML
    private ImageView ficha_n2;

    @FXML
    private ImageView ficha_n3;

    @FXML
    private ImageView ficha_n4;

    @FXML
    private ImageView ficha_n5;

    @FXML
    private ImageView ficha_n6;

    @FXML
    private ImageView ficha_cambio_n1;

    @FXML
    private ImageView ficha_cambio_n2;

    @FXML
    private ImageView ficha_cambio_n3;

    @FXML
    private ImageView ficha_cambio_n4;

    @FXML
    private ImageView ficha_cambio_n5;

    @FXML
    private ImageView ficha_cambio_n6;

    Juego juego;
    int idFicha;
    boolean regla;
    ImageView[] arregloImageView;
    ImageView arregloImageViewCambio[];
    ImageView arregloImageViewTablero[][];
    Label arregloPuntosJugador[];
    ArrayList<String> listaJugadores;


    public void actualizarFichasTablero() {
        /*for (int f = 0; f<juego.getJugadorEnTurno().getArregloFichas().length; f++) {
            System.out.println("ID de ficha : " + (juego.getJugadorEnTurno().getArregloFichas()[f].getId()));
        }*/
        for (int i = 0; i < juego.getJugadorEnTurno().getArregloFichas().length; i++) {
//TODO reparar problema de duplicación de fichas
            //System.out.println("CANTIDAD DE FICHAS ACTUALES E MANO : " + juego.getJugadorEnTurno().getArregloFichas().length);
            idFicha = (juego.getJugadorEnTurno().getArregloFichas()[i].getId());
            System.out.println("IMPRIMIR ID DE FICHA: " + idFicha);
            arregloImageView[i].setImage(new Image("Fichas/Ficha" + idFicha + ".png"));
        }
    }

    private void opacidad() {
        for (ImageView imageView : arregloImageView) {
            imageView.setOpacity(1);
            imageView.setEffect(null);
        }
    }

    public void actualizarPuntos() {
        for (int i = 0; i < this.juego.jugadores.length; i++) {
            //  System.out.println("actualizando al jugador : " + i);
            //System.out.println(this.juego.jugadores[i].getPuntosJugador());
            // this.arregloPuntosJugador[i].setText(this.juego.jugadores[i].getPuntosJugador() + "pts");
            // System.out.println(this.arregloPuntosJugador[i].getText());
        }
    }

    @FXML
    private void seleccionarFicha(MouseEvent event) {
        opacidad();
        for (int i = 0; i < this.juego.getJugadorEnTurno().getArregloFichas().length; i++) {
            if (((ImageView) (event.getSource())).getId().equals(this.arregloImageView[i].getId())) {
                ((ImageView) (event.getSource())).setOpacity(0.8);
                ((ImageView) (event.getSource())).setEffect(new DropShadow(15, Color.BLACK));
                if (this.juego.getJugadorEnTurno().getIdFicha(i) != 0) {//validar que la ficha seleccionada no sea la fichaVacia
                    this.juego.getJugadorEnTurno().setFichaSeleccionada(this.juego.getJugadorEnTurno().getArregloFichas()[i]);
                }
                break;
            }
        }
    }

    public void actualizarTablaPuntaje() {
        for (int i = 0; i < this.juego.jugadores.length; i++) {
            this.listaPuntajesJugador.getItems().set(i, (this.juego.jugadores[i].getName() + ": " + (this.juego.jugadores[i].getPuntosJugador()) + "puntos"));
        }
    }

    public void setJugadores(ListView listView) {
        this.listaJugadores = new ArrayList<>();
        for (Object cadena : listView.getItems()) {
            this.listaJugadores.add((String) cadena);
        }
        this.arregloImageView = new ImageView[]{ficha_n1, ficha_n2, ficha_n3,
                ficha_n4, ficha_n5, ficha_n6};
        this.arregloImageViewCambio = new ImageView[]{ficha_cambio_n1, ficha_cambio_n2, ficha_cambio_n3, ficha_cambio_n4,
                ficha_cambio_n5, ficha_cambio_n6};
        this.arregloPuntosJugador = new Label[]{pj1, pj2, pj3, pj4};

        this.arregloImageViewTablero = new ImageView[][]
                {{casilla_0_0, casilla_0_1, casilla_0_2, casilla_0_3, casilla_0_4, casilla_0_5, casilla_0_6, casilla_0_7, casilla_0_8, casilla_0_9, casilla_0_10, casilla_0_11, casilla_0_12, casilla_0_13, casilla_0_14, casilla_0_15, casilla_0_16, casilla_0_17},
                        {casilla_1_0, casilla_1_1, casilla_1_2, casilla_1_3, casilla_1_4, casilla_1_5, casilla_1_6, casilla_1_7, casilla_1_8, casilla_1_9, casilla_1_10, casilla_1_11, casilla_1_12, casilla_1_13, casilla_1_14, casilla_1_15, casilla_1_16, casilla_1_17},
                        {casilla_2_0, casilla_2_1, casilla_2_2, casilla_2_3, casilla_2_4, casilla_2_5, casilla_2_6, casilla_2_7, casilla_2_8, casilla_2_9, casilla_2_10, casilla_2_11, casilla_2_12, casilla_2_13, casilla_2_14, casilla_2_15, casilla_2_16, casilla_2_17},
                        {casilla_3_0, casilla_3_1, casilla_3_2, casilla_3_3, casilla_3_4, casilla_3_5, casilla_3_6, casilla_3_7, casilla_3_8, casilla_3_9, casilla_3_10, casilla_3_11, casilla_3_12, casilla_3_13, casilla_3_14, casilla_3_15, casilla_3_16, casilla_3_17},
                        {casilla_4_0, casilla_4_1, casilla_4_2, casilla_4_3, casilla_4_4, casilla_4_5, casilla_4_6, casilla_4_7, casilla_4_8, casilla_4_9, casilla_4_10, casilla_4_11, casilla_4_12, casilla_4_13, casilla_4_14, casilla_4_15, casilla_4_16, casilla_4_17},
                        {casilla_5_0, casilla_5_1, casilla_5_2, casilla_5_3, casilla_5_4, casilla_5_5, casilla_5_6, casilla_5_7, casilla_5_8, casilla_5_9, casilla_5_10, casilla_5_11, casilla_5_12, casilla_5_13, casilla_5_14, casilla_5_15, casilla_5_16, casilla_5_17},
                        {casilla_6_0, casilla_6_1, casilla_6_2, casilla_6_3, casilla_6_4, casilla_6_5, casilla_6_6, casilla_6_7, casilla_6_8, casilla_6_9, casilla_6_10, casilla_6_11, casilla_6_12, casilla_6_13, casilla_6_14, casilla_6_15, casilla_6_16, casilla_6_17},
                        {casilla_7_0, casilla_7_1, casilla_7_2, casilla_7_3, casilla_7_4, casilla_7_5, casilla_7_6, casilla_7_7, casilla_7_8, casilla_7_9, casilla_7_10, casilla_7_11, casilla_7_12, casilla_7_13, casilla_7_14, casilla_7_15, casilla_7_16, casilla_7_17},
                        {casilla_8_0, casilla_8_1, casilla_8_2, casilla_8_3, casilla_8_4, casilla_8_5, casilla_8_6, casilla_8_7, casilla_8_8, casilla_8_9, casilla_8_10, casilla_8_11, casilla_8_12, casilla_8_13, casilla_8_14, casilla_8_15, casilla_8_16, casilla_8_17},
                        {casilla_9_0, casilla_9_1, casilla_9_2, casilla_9_3, casilla_9_4, casilla_9_5, casilla_9_6, casilla_9_7, casilla_9_8, casilla_9_9, casilla_9_10, casilla_9_11, casilla_9_12, casilla_9_13, casilla_9_14, casilla_9_15, casilla_9_16, casilla_9_17},
                        {casilla_10_0, casilla_10_1, casilla_10_2, casilla_10_3, casilla_10_4, casilla_10_5, casilla_10_6, casilla_10_7, casilla_10_8, casilla_10_9, casilla_10_10, casilla_10_11, casilla_10_12, casilla_10_13, casilla_10_14, casilla_10_15, casilla_10_16, casilla_10_17},
                        {casilla_11_0, casilla_11_1, casilla_11_2, casilla_11_3, casilla_11_4, casilla_11_5, casilla_11_6, casilla_11_7, casilla_11_8, casilla_11_9, casilla_11_10, casilla_11_11, casilla_11_12, casilla_11_13, casilla_11_14, casilla_11_15, casilla_11_16, casilla_11_17},
                        {casilla_12_0, casilla_12_1, casilla_12_2, casilla_12_3, casilla_12_4, casilla_12_5, casilla_12_6, casilla_12_7, casilla_12_8, casilla_12_9, casilla_12_10, casilla_12_11, casilla_12_12, casilla_12_13, casilla_12_14, casilla_12_15, casilla_12_16, casilla_12_17},
                        {casilla_13_0, casilla_13_1, casilla_13_2, casilla_13_3, casilla_13_4, casilla_13_5, casilla_13_6, casilla_13_7, casilla_13_8, casilla_13_9, casilla_13_10, casilla_13_11, casilla_13_12, casilla_13_13, casilla_13_14, casilla_13_15, casilla_13_16, casilla_13_17},
                        {casilla_14_0, casilla_14_1, casilla_14_2, casilla_14_3, casilla_14_4, casilla_14_5, casilla_14_6, casilla_14_7, casilla_14_8, casilla_14_9, casilla_14_10, casilla_14_11, casilla_14_12, casilla_14_13, casilla_14_14, casilla_14_15, casilla_14_16, casilla_14_17},
                        {casilla_15_0, casilla_15_1, casilla_15_2, casilla_15_3, casilla_15_4, casilla_15_5, casilla_15_6, casilla_15_7, casilla_15_8, casilla_15_9, casilla_15_10, casilla_15_11, casilla_15_12, casilla_15_13, casilla_15_14, casilla_15_15, casilla_15_16, casilla_15_17},
                        {casilla_16_0, casilla_16_1, casilla_16_2, casilla_16_3, casilla_16_4, casilla_16_5, casilla_16_6, casilla_16_7, casilla_16_8, casilla_16_9, casilla_16_10, casilla_16_11, casilla_16_12, casilla_16_13, casilla_16_14, casilla_16_15, casilla_16_16, casilla_16_17},
                        {casilla_17_0, casilla_17_1, casilla_17_2, casilla_17_3, casilla_17_4, casilla_17_5, casilla_17_6, casilla_17_7, casilla_17_8, casilla_17_9, casilla_17_10, casilla_17_11, casilla_17_12, casilla_17_13, casilla_17_14, casilla_17_15, casilla_17_16, casilla_17_17}};

        try {

            this.juego = new Juego(this.listaJugadores);
            // this.juego.start();
            for (int i = 0; i < this.juego.jugadores.length; i++) {
                System.out.println("entra en juego");
                this.listaPuntajesJugador.getItems().add((this.juego.jugadores[i].getName() + ": " + (this.juego.jugadores[i].getPuntosJugador()) + "puntos"));
//                Se comenta para probar la impresión en interfaz de los nombres de los jugadores
//                this.listaPuntajesJugador.getItems().add("Jugador " + (i + 1) + ": " + this.juego.jugadores[i].getPuntosJugador() + " puntos");
            }

            this.labelJugadorEnTurno.setText("Turno: Jugador 1");
            if (this.juego.getJugadorEnTurno() instanceof Bot) {

                this.turnarBot();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.actualizarFichasTablero();

    }

    @FXML
    private void ponerFichaEnCambio(MouseEvent event) {
        if (this.juego.getJugadorEnTurno().getFichaSeleccionada() != null) {
            for (ImageView imageView : this.arregloImageViewCambio) {
                if (((ImageView) (event.getSource())).getId().equals(imageView.getId())) {
                    imageView.setImage(new Image("Fichas/Ficha" + this.juego.getJugadorEnTurno().getFichaSeleccionada().getId() + ".png"));
                    imageView.setDisable(true);
                    this.juego.agregarFichaCambio(this.juego.getJugadorEnTurno().getFichaSeleccionada());
                    this.juego.getJugadorEnTurno().removerFicha(this.juego.getJugadorEnTurno().getFichaSeleccionada());
                    juego.getJugadorEnTurno().setFichaSeleccionada(null);
                    this.actualizarFichasTablero();
                    this.juego.setFichaEncambio(true);
                    break;
                }
            }
        }
    }

    @FXML
    public void eventoTerminar(MouseEvent mouseEvent) throws IOException {
        ArrayList<Jugador> listaFinal = new ArrayList<>();

        listaFinal.addAll(Arrays.asList(this.juego.jugadores));
        listaFinal.sort(new Comparator<Jugador>() {
            @Override
            public int compare(Jugador o1, Jugador o2) {
                return o2.getPuntosJugador() - o1.getPuntosJugador();
            }
        });

        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setContentText("EL JUGADOR " + listaFinal.get(0).getIdJugador() + " (" + listaFinal.get(0).getName() + ") " + "ES EL GANADOR CON " + listaFinal.get(0).getPuntosJugador() + " PUNTOS");
        alert2.showAndWait();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Diálogo de confirmación...");
        alert.setHeaderText(null);
        alert.setContentText("¿Desea reiniciar el juego?");

        Optional<ButtonType> resultado = alert.showAndWait();
        if (resultado.isPresent()) {
            Node source = (Node) mouseEvent.getSource();     //Me devuelve el elemento al que hice click
            Stage stage2 = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
            stage2.close();
            if (resultado.get() == ButtonType.OK) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLPrincipal.fxml"));

                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                FXMLPrincipalController controlador = (FXMLPrincipalController) fxmlLoader.getController();
                stage.show();
                controlador.setVentanaArranque();
            }

        }
    }

    private void pintarTablero() {
        for (int x = 0; x < this.arregloImageViewTablero.length; x++) {
            for (int y = 0; y < this.arregloImageViewTablero[x].length; y++) {
                if (this.juego.getTablero().casilla[x][y].getFicha() != null) {
                    this.arregloImageViewTablero[x][y].setImage(new Image("Fichas/Ficha" + this.juego.getTablero().casilla[x][y].getFicha().getId() + ".png"));
                }
            }
        }
    }

    @FXML
    private void ponerFicha(MouseEvent event) {
        if (!this.juego.isFichaEncambio()) {
            try {
                if (this.juego.getJugadorEnTurno().getFichaSeleccionada() != null) {
                    for (int x = 0; x < this.arregloImageViewTablero.length; x++) {
                        for (int y = 0; y < this.arregloImageViewTablero[x].length; y++) {
                            if (((ImageView) (event.getSource())).getId().equals(this.arregloImageViewTablero[x][y].getId())) {
                                if (this.juego.isMovimientoValido(this.juego.getTablero().casilla[x][y])) {
                                    ((ImageView) (event.getSource())).setImage(new Image("Fichas/Ficha" + this.juego.getJugadorEnTurno().getFichaSeleccionada().getId() + ".png"));
                                    this.juego.getTablero().casilla[x][y].setFicha(this.juego.getJugadorEnTurno().getFichaSeleccionada());
                                    this.juego.getJugadorEnTurno().removerFicha(this.juego.getJugadorEnTurno().getFichaSeleccionada());
                                    juego.getJugadorEnTurno().setFichaSeleccionada(null);
                                    opacidad();
                                    this.actualizarFichasTablero();
                                    this.resaltarUltimaFicha();
                                }
                                break;
                            }
                        }
                    }
                } else {
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setContentText("NO HAS SELECCIONADO ALGUNA FICHA");
                    alert2.showAndWait();
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("YA HAS PUESTO FICHAS PARA CAMBIAR");
            alert.showAndWait();
        }
    }

    @FXML
    private void deshacer() {
        // {Construir deshacer}
    }

    @FXML
    private void cambiarFicha() throws Exception {
        if (this.juego.isFichaEncambio()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("SE HA CAMBIADO AL JUGADOR " + (this.juego.getNumeroJugadorEnTurno() + 1));
            alert.showAndWait();
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setContentText("Se han cambiado las fichas del jugador anterior");
            alert2.showAndWait();
            this.terminarTurno();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("NO HAS SELECCIONADO FICHAS PARA CAMBIAR");
            alert.showAndWait();
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setContentText("NO HAS SELECCIONADO FICHAS PARA CAMBIAR");
            alert2.showAndWait();
        }
    }

    private void borrarResaltado() {
        for (ImageView[] imageView : this.arregloImageViewTablero) {
            for (ImageView imageView2 : imageView) {
                imageView2.setEffect(null);
            }
        }
    }

    private void resaltarUltimaFicha() {
        for (int i = 0; i < this.juego.getTablero().casilla.length; i++) {
            for (int j = 0; j < this.juego.getTablero().casilla[i].length; j++) {
                if (this.juego.getControladorEstructura().getUltimaJugada() != null && this.juego.getControladorEstructura().getUltimaJugada().equals(this.juego.getTablero().casilla[i][j])) {
                    this.arregloImageViewTablero[i][j].setEffect(new DropShadow(15, Color.BROWN));
                }
            }
        }
    }

    private void turnarBot() throws Exception {
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setContentText("ES TURNO DEL BOT");
        alert2.showAndWait();
        for (Ficha ficha : this.juego.getJugadorEnTurno().fichas) {
            System.out.println(ficha.toString());
        }
        for (int i = 0; i < 6; i++) {
            try {

                this.juego.moverBot(i);
                this.resaltarUltimaFicha();
            } catch (Exception e) {
                System.out.println("YA NO PUEDE O DEBE PONER MÁS");

            }
        }
        if (((Bot) this.juego.getJugadorEnTurno()).isCambioFichaDisponible()) {
            System.out.println("DEBERÍA CAMBIAR LAS FICHAS");
            this.juego.agregarFichaCambio(((Bot) this.juego.getJugadorEnTurno()).cambiarFichas());
        }
        this.terminarTurno();
    }

    @FXML
    private void terminarTurno() throws Exception {
        this.borrarResaltado();
        this.juego.terminarTurno();
        this.actualizarPuntos();
        this.actualizarFichasTablero();
        this.actualizarFichasEnCambio();
        this.actualizarTablaPuntaje();
        this.pintarTablero();
        this.labelJugadorEnTurno.setText("Turno: Jugador " + (this.juego.getNumeroJugadorEnTurno() + 1));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("SE HA CAMBIADO AL JUGADOR " + (this.juego.getNumeroJugadorEnTurno() + 1));
        alert.showAndWait();


        if (this.juego.getJugadorEnTurno() instanceof Bot) {
            this.turnarBot();
        }


    }

    private void actualizarFichasEnCambio() {
        if (this.juego.getBolsa().fichas.isEmpty()) {
            for (int i = 0; i < this.arregloImageViewCambio.length; i++) {
                this.arregloImageViewCambio[i].setDisable(true);
                this.arregloImageViewCambio[i].setOpacity(.8);
            }
        } else {
            for (ImageView imageView : this.arregloImageViewCambio) {
                imageView.setImage(new Image("Fichas/Ficha0.png"));
                imageView.setDisable(false);
            }
        }

    }

    /*@Override
    public void initialize(URL url, ResourceBundle rb) {

        this.listaJugadores = new ArrayList<>();
        try {
            this.juego = new Juego(this.listaJugadores);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NO HAE JUEGO");
        }
        this.arregloImageView = new ImageView[]{ficha_n1, ficha_n2, ficha_n3,
                ficha_n4, ficha_n5, ficha_n6};
        this.arregloImageViewCambio = new ImageView[]{ficha_cambio_n1, ficha_cambio_n2, ficha_cambio_n3, ficha_cambio_n4,
                ficha_cambio_n5, ficha_cambio_n6};
        this.arregloPuntosJugador = new Label[]{pj1, pj2, pj3, pj4};

        this.arregloImageViewTablero = new ImageView[][]
                {{casilla_0_0, casilla_0_1, casilla_0_2, casilla_0_3, casilla_0_4, casilla_0_5, casilla_0_6, casilla_0_7, casilla_0_8, casilla_0_9, casilla_0_10, casilla_0_11, casilla_0_12, casilla_0_13, casilla_0_14, casilla_0_15, casilla_0_16, casilla_0_17},
                        {casilla_1_0, casilla_1_1, casilla_1_2, casilla_1_3, casilla_1_4, casilla_1_5, casilla_1_6, casilla_1_7, casilla_1_8, casilla_1_9, casilla_1_10, casilla_1_11, casilla_1_12, casilla_1_13, casilla_1_14, casilla_1_15, casilla_1_16, casilla_1_17},
                        {casilla_2_0, casilla_2_1, casilla_2_2, casilla_2_3, casilla_2_4, casilla_2_5, casilla_2_6, casilla_2_7, casilla_2_8, casilla_2_9, casilla_2_10, casilla_2_11, casilla_2_12, casilla_2_13, casilla_2_14, casilla_2_15, casilla_2_16, casilla_2_17},
                        {casilla_3_0, casilla_3_1, casilla_3_2, casilla_3_3, casilla_3_4, casilla_3_5, casilla_3_6, casilla_3_7, casilla_3_8, casilla_3_9, casilla_3_10, casilla_3_11, casilla_3_12, casilla_3_13, casilla_3_14, casilla_3_15, casilla_3_16, casilla_3_17},
                        {casilla_4_0, casilla_4_1, casilla_4_2, casilla_4_3, casilla_4_4, casilla_4_5, casilla_4_6, casilla_4_7, casilla_4_8, casilla_4_9, casilla_4_10, casilla_4_11, casilla_4_12, casilla_4_13, casilla_4_14, casilla_4_15, casilla_4_16, casilla_4_17},
                        {casilla_5_0, casilla_5_1, casilla_5_2, casilla_5_3, casilla_5_4, casilla_5_5, casilla_5_6, casilla_5_7, casilla_5_8, casilla_5_9, casilla_5_10, casilla_5_11, casilla_5_12, casilla_5_13, casilla_5_14, casilla_5_15, casilla_5_16, casilla_5_17},
                        {casilla_6_0, casilla_6_1, casilla_6_2, casilla_6_3, casilla_6_4, casilla_6_5, casilla_6_6, casilla_6_7, casilla_6_8, casilla_6_9, casilla_6_10, casilla_6_11, casilla_6_12, casilla_6_13, casilla_6_14, casilla_6_15, casilla_6_16, casilla_6_17},
                        {casilla_7_0, casilla_7_1, casilla_7_2, casilla_7_3, casilla_7_4, casilla_7_5, casilla_7_6, casilla_7_7, casilla_7_8, casilla_7_9, casilla_7_10, casilla_7_11, casilla_7_12, casilla_7_13, casilla_7_14, casilla_7_15, casilla_7_16, casilla_7_17},
                        {casilla_8_0, casilla_8_1, casilla_8_2, casilla_8_3, casilla_8_4, casilla_8_5, casilla_8_6, casilla_8_7, casilla_8_8, casilla_8_9, casilla_8_10, casilla_8_11, casilla_8_12, casilla_8_13, casilla_8_14, casilla_8_15, casilla_8_16, casilla_8_17},
                        {casilla_9_0, casilla_9_1, casilla_9_2, casilla_9_3, casilla_9_4, casilla_9_5, casilla_9_6, casilla_9_7, casilla_9_8, casilla_9_9, casilla_9_10, casilla_9_11, casilla_9_12, casilla_9_13, casilla_9_14, casilla_9_15, casilla_9_16, casilla_9_17},
                        {casilla_10_0, casilla_10_1, casilla_10_2, casilla_10_3, casilla_10_4, casilla_10_5, casilla_10_6, casilla_10_7, casilla_10_8, casilla_10_9, casilla_10_10, casilla_10_11, casilla_10_12, casilla_10_13, casilla_10_14, casilla_10_15, casilla_10_16, casilla_10_17},
                        {casilla_11_0, casilla_11_1, casilla_11_2, casilla_11_3, casilla_11_4, casilla_11_5, casilla_11_6, casilla_11_7, casilla_11_8, casilla_11_9, casilla_11_10, casilla_11_11, casilla_11_12, casilla_11_13, casilla_11_14, casilla_11_15, casilla_11_16, casilla_11_17},
                        {casilla_12_0, casilla_12_1, casilla_12_2, casilla_12_3, casilla_12_4, casilla_12_5, casilla_12_6, casilla_12_7, casilla_12_8, casilla_12_9, casilla_12_10, casilla_12_11, casilla_12_12, casilla_12_13, casilla_12_14, casilla_12_15, casilla_12_16, casilla_12_17},
                        {casilla_13_0, casilla_13_1, casilla_13_2, casilla_13_3, casilla_13_4, casilla_13_5, casilla_13_6, casilla_13_7, casilla_13_8, casilla_13_9, casilla_13_10, casilla_13_11, casilla_13_12, casilla_13_13, casilla_13_14, casilla_13_15, casilla_13_16, casilla_13_17},
                        {casilla_14_0, casilla_14_1, casilla_14_2, casilla_14_3, casilla_14_4, casilla_14_5, casilla_14_6, casilla_14_7, casilla_14_8, casilla_14_9, casilla_14_10, casilla_14_11, casilla_14_12, casilla_14_13, casilla_14_14, casilla_14_15, casilla_14_16, casilla_14_17},
                        {casilla_15_0, casilla_15_1, casilla_15_2, casilla_15_3, casilla_15_4, casilla_15_5, casilla_15_6, casilla_15_7, casilla_15_8, casilla_15_9, casilla_15_10, casilla_15_11, casilla_15_12, casilla_15_13, casilla_15_14, casilla_15_15, casilla_15_16, casilla_15_17},
                        {casilla_16_0, casilla_16_1, casilla_16_2, casilla_16_3, casilla_16_4, casilla_16_5, casilla_16_6, casilla_16_7, casilla_16_8, casilla_16_9, casilla_16_10, casilla_16_11, casilla_16_12, casilla_16_13, casilla_16_14, casilla_16_15, casilla_16_16, casilla_16_17},
                        {casilla_17_1, casilla_17_2, casilla_17_3, casilla_17_4, casilla_17_5, casilla_17_6, casilla_17_7, casilla_17_8, casilla_17_9, casilla_17_10, casilla_17_11, casilla_17_12, casilla_17_13, casilla_17_14, casilla_17_15, casilla_17_16, casilla_17_17}};

        this.actualizarFichasTablero();
    }*/

}
