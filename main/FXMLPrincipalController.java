package main;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLPrincipalController implements Initializable {
    @FXML
    public ListView<String> listaJugadores;
    @FXML
    public Spinner<Integer> spinnerJugadores;
    @FXML
    public Button botonLimpiar;
    @FXML
    private MenuItem botonCantidadJugadores;
    @FXML
    private Button botonPrueba;


    public void eventoJugador(ActionEvent actionEvent) {
        this.listaJugadores.getItems().clear();
        JOptionPane.showMessageDialog(null, "IMPRIME" + actionEvent.getSource().toString());
        for (int i = 0; i < Integer.parseInt(((MenuItem) actionEvent.getSource()).getText()); i++) {
            this.listaJugadores.getItems().add("Jugador Humano");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.spinnerJugadores.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 18, 0));

        this.spinnerJugadores.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                if (oldValue < newValue) {
                    listaJugadores.getItems().add("Jugador Humano");
                } else {
                    listaJugadores.getItems().remove("Jugador Humano");
                }
            }
        });

    }

    public void setVentanaArranque() {
        this.listaJugadores.getItems().clear();
        this.spinnerJugadores.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 4, 0));
        //ESTO EVITA QUE SE AGREGUE E LISTENER Y CREE OTRO JUGADOR EXTRA AL REINICIAR EL JUEGO
//        this.spinnerJugadores.valueProperty().addListener(new ChangeListener<Integer>() {
//            @Override
//            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
//                if (oldValue < newValue) {
//                    listaJugadores.getItems().add("Jugador Humano");
//                } else {
//                    listaJugadores.getItems().remove("Jugador Humano");
//                }
//            }
//        });
    }

    @FXML
    public void eventoBot(ActionEvent actionEvent) {
        if (this.listaJugadores.getItems().size() == 18) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Limite de jugadores");
            alert.setHeaderText(null);
            alert.setContentText("Se ha alcanzado el límite de jugadores en el juego");
            alert.showAndWait();
        } else {
            this.listaJugadores.getItems().add(((MenuItem) actionEvent.getSource()).getText());
        }
    }

    @FXML
    public void eventoLimpiar(MouseEvent mouse) {
        this.listaJugadores.getItems().clear();
        this.spinnerJugadores.decrement(this.spinnerJugadores.getValue());
    }

    @FXML
    public void eventoJugar(MouseEvent mouseEvent) throws IOException {

        if (this.listaJugadores.getItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Sin jugadores");
            alert.setHeaderText(null);
            alert.setContentText("No puede comenzar el juego sin jugadores");
            alert.showAndWait();

        } else {
            Node source = (Node) mouseEvent.getSource();     //Me devuelve el elemento al que hice click
            Stage stage2 = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
            stage2.close();

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            FXMLDocumentController controlador = (FXMLDocumentController) fxmlLoader.getController();
            stage.show();
            controlador.setJugadores(this.listaJugadores);
        }


    }
}
