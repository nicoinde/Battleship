/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.battleship;

import Logica.*;
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
public class VentanaJuegoFinalizado {
    
    public void display(String title,boolean winner, String ganador, double[] porcentajes, int[] totales){
        Stage window=new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        String message="El ganador es: "+ganador;
        Label lblMsg= new Label();
        Label lblDisparos= new Label();
        Label lblAciertos= new Label();
        Label lblPorcAciertos= new Label();
        Label lblPorcErrados= new Label();
        if(winner){
            lblDisparos.setText("Disparos: "+Integer.toString(totales[0]));
            lblAciertos.setText("Aciertos: "+Integer.toString(totales[2]));
            lblPorcAciertos.setText("% Aciertos: "+Double.toString(porcentajes[0]));
            lblPorcErrados.setText("% Errados: "+Double.toString(porcentajes[2]));
        }else{
            lblDisparos.setText(Integer.toString(totales[1]));
            lblAciertos.setText(Integer.toString(totales[3]));
            lblPorcAciertos.setText(Double.toString(porcentajes[1]));
            lblPorcErrados.setText(Double.toString(porcentajes[3]));
        }
        
        
        lblMsg.setText(message);
        Button btnSalir=new Button("Aceptar");
        btnSalir.setOnAction(e-> window.close());
        VBox newLayout=new VBox(20);
        newLayout.getChildren().addAll(lblMsg,lblDisparos,lblAciertos,lblPorcAciertos,lblPorcErrados,btnSalir);
        newLayout.setAlignment(Pos.CENTER);
        
        Scene scn =new Scene(newLayout,300,250);
        window.setScene(scn);
        window.showAndWait();
        
    }
    
}
