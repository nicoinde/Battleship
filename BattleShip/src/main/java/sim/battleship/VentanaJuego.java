/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.battleship;
import java.util.HashSet;
import java.util.Set;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.application.Application.launch;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.stage.*;

/**
 *
 * @author Nico
 */
public class VentanaJuego {
    
    public static void display(String title, String message){
        Stage window=new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        
        Label lblMsg= new Label();
        lblMsg.setText(message);
        Button btnSalir=new Button("get Outta Here!!");
        btnSalir.setOnAction(e-> window.close());
        VBox newLayout=new VBox(20);
        newLayout.getChildren().addAll(lblMsg,btnSalir);
        newLayout.setAlignment(Pos.CENTER);
        
        Scene scn =new Scene(newLayout,300,250);
        window.setScene(scn);
        window.showAndWait();
        
    }
    
}
