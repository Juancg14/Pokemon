package juego_pokemon.pokemon;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login extends Application {

    private TextField nombreUsuario;
    private PasswordField contrasena;
    private Label mensaje;
    private Entrenador entrenador;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Registro de Usuario");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nombreUsuarioLabel = new Label("Nombre de usuario:");
        GridPane.setConstraints(nombreUsuarioLabel, 0, 0);

        nombreUsuario = new TextField();
        GridPane.setConstraints(nombreUsuario, 1, 0);

        Label contrasenaLabel = new Label("Contraseña:");
        GridPane.setConstraints(contrasenaLabel, 0, 1);

        contrasena = new PasswordField();
        GridPane.setConstraints(contrasena, 1, 1);

        Button iniciarSesion = new Button("Iniciar sesión");
        iniciarSesion.setOnAction(e -> iniciarSesion());
        GridPane.setConstraints(iniciarSesion, 1, 2);

        Button cerrarSesion = new Button("Cerrar sesión");
        cerrarSesion.setOnAction(e -> cerrarSesion());
        GridPane.setConstraints(cerrarSesion, 1, 3);

        mensaje = new Label();
        GridPane.setConstraints(mensaje, 1, 4);

        grid.getChildren().addAll(nombreUsuarioLabel, nombreUsuario, contrasenaLabel, contrasena,
                iniciarSesion, cerrarSesion, mensaje);

        
        Scene scene = new Scene(grid, 1080, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void iniciarSesion() {
        String usuario = nombreUsuario.getText();
        String pass = contrasena.getText();

        if (usuario.isEmpty() || pass.isEmpty()) {
            mensaje.setText("Por favor ingresa un nombre de usuario y contraseña");
            return;
        }

        entrenador = new Entrenador(usuario, pass);
        mensaje.setText("Sesión iniciada");
    }

    private void cerrarSesion() {
        entrenador = null;
        mensaje.setText("Sesión cerrada");
    }

    public static void main(String[] args) {
        launch(args);
    }
}