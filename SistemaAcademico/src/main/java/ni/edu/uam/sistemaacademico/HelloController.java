package ni.edu.uam.sistemaacademico;



import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.InputStream;

public class HelloController {

    @FXML private Label lblMiEtiqueta;
    @FXML private Label welcomeText;
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtClave;
    @FXML private Label lblMensaje;

    @FXML
    public void initialize() {

        InputStream stream = getClass().getResourceAsStream("uamlogo.png");
        if (stream != null) {
            Image miImagen = new Image(stream);
            ImageView imageView = new ImageView(miImagen);
            imageView.setFitWidth(40);
            imageView.setFitHeight(40);
            imageView.setPreserveRatio(true);
            lblMiEtiqueta.setGraphic(imageView);
        }
    }

    @FXML
    protected void btnConfirmar() {
        String usuario = txtUsuario.getText().trim();
        String clave = txtClave.getText();

        if (usuario.isEmpty() || clave.isEmpty()) {
            lblMensaje.setTextFill(Color.RED);
            lblMensaje.setText("Complete todos los campos.");
            return;
        }

        if (usuario.equals("admin") && clave.equals("admin123")) {
            lblMensaje.setTextFill(Color.GREEN);
            lblMensaje.setText("Datos recibidos para validación.");
        } else {
            lblMensaje.setTextFill(Color.RED);
            lblMensaje.setText("Usuario o contraseña incorrectos.");
        }

        // Limpiamos la clave por seguridad
        txtClave.clear();
    }

    @FXML
    protected void btnLimpiar() {
        txtUsuario.clear();
        txtClave.clear();
        lblMensaje.setText("");
    }
}