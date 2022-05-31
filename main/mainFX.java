package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class mainFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Juego de Qwirkle - Equipo [5,6,7] - 8SI");
        stage.setResizable(false);
        stage.getIcons().add(new Image("image/qwirkle_icon.jpg"));
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
