package sim.battleship;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.application.Application.launch;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    Button btnNuevo, btnSalir, btnPopUp;
    VBox layoutMenu1,layoutMenuJuego;
    Stage window;
    Scene ventPrincipal, ventJuego;
    Label lblMenuPrincipal, lblJuego;

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        window=stage;
        //Stage es la ventana
        //Scene es el contenido
        inicializar();

        ventPrincipal.getStylesheets().add("/styles/Styles.css");

        window.setTitle("Battleship - Simulaciones");
        window.setScene(ventPrincipal);
        window.show();
    }

    private void inicializar() {
        //inicializando para ventana principal
        layoutMenu1 = new VBox(20);
        lblMenuPrincipal=new Label("Menu Principal");
        lblJuego=new Label("Pantalla del juego");
        btnNuevo = new Button("Nueva Partida");
        //ActionHandler con lambdaExpression
        btnNuevo.setOnAction(e -> {
            window.setScene(ventJuego);
        });
        layoutMenu1.getChildren().addAll(lblMenuPrincipal,btnNuevo);
        ventPrincipal = new Scene(layoutMenu1, 1080, 720);

        
        //INICIALIZANDO PARA VENTANA DE JUEGO
        VentanaJuego ventanaJuego= new VentanaJuego();
        layoutMenuJuego = new VBox(20);
        btnPopUp=new Button("Pop it up!");
        btnPopUp.setOnAction(e->ventanaJuego.display("Trying", "And not Dying"));
        btnSalir = new Button("Salir");
        btnSalir.setOnAction(e -> {
            window.setScene(ventPrincipal);
        });
        layoutMenuJuego.getChildren().addAll(lblJuego,btnPopUp,btnSalir);
        ventJuego = new Scene(layoutMenuJuego,1080,720);
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    ///////////////////////ACA EMPIEZA LA LOGICA DEL CONTROLADOR DEL JUEGO   //////////////////////////
    
    
    
    
    
    
    
    
    
}
