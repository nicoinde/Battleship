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
public class VentanaJuego {
    
    private Partida partida;
    boolean terminado, ganoPlayer1;
    int estA,estB;
    public void display(String title, String message){
        Stage window=new Stage();
        
        iniciarPartida();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        
        Button btnDisparar=new Button("Disparar");
        btnDisparar.setOnAction(e->{ 
            disparo();
        });
        Button btnDispararAll=new Button("Disparar Todo");
        btnDisparar.setOnAction(e->{ 
            disparoAll();
        });
        
        
        
        Label lblMsg= new Label();
        lblMsg.setText(message);
        Button btnSalir=new Button("get Outta Here!!");
        btnSalir.setOnAction(e-> window.close());
        VBox newLayout=new VBox(20);
        newLayout.getChildren().addAll(lblMsg,btnSalir,btnDisparar);
        newLayout.setAlignment(Pos.CENTER);
        
        Scene scn =new Scene(newLayout,300,250);
        window.setScene(scn);
        window.showAndWait();
        
    }
    
    
    ///////////////////////ACA EMPIEZA LA LOGICA DEL CONTROLADOR DEL JUEGO   //////////////////////////
    
    private void iniciarPartida(){
        partida= new Partida(estA, estB);
    }
    
    private void actualizarGrafico(int[] coord){
        
    }
    
    private void disparo(){
        
        if(!partida.isFinished()){
            partida.disparar();
            actualizarGrafico(partida.ultimoAtaqueA());
            actualizarGrafico(partida.ultimoAtaqueB());
        } else{
            terminado=true;
            ganoPlayer1=partida.ganoPlayer1();
            finalizarJuego();
            
        }
        
    }
    
    private void disparoAll(){
        
        for(int i=0;i<10;i++){
            if(!partida.isFinished()){
                partida.dispararAll();
            } else{
                terminado=true;
                ganoPlayer1=partida.ganoPlayer1();
                finalizarJuego();
            
            }
        }
    }

    private String obtenerEstrategia(int a){
        switch(a){
            case 0: return "Lineal.";
            case 1: return "Random.";
            case 2: return "Random Inteligente.";
            case 3: return "Random Inteligente por Impares.";
            default:   return "Error";
        }
    }
    
    private void finalizarJuego() {
        String mensaje="El ganador es el jugador ";
        if(ganoPlayer1){
            mensaje+=1+". Estrategia ganadora: "+ obtenerEstrategia(estA); 
        }else{
            mensaje+=1+". Estrategia ganadora: "+ obtenerEstrategia(estB); 
        }
        VentanaJuegoFinalizado gameTerminado= new VentanaJuegoFinalizado();
        gameTerminado.display("Fin del Juego", mensaje, partida.porcentajesAciertos(), partida.totales());
        reset();
        
    }
    
    public void reset(){
        
    }
    
}
