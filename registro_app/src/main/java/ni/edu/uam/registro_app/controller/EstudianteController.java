package ni.edu.uam.registro_app.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ni.edu.uam.registro_app.dao.EstudianteDao;
import ni.edu.uam.registro_app.modelos.Estudiante;

import java.net.URL;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

public class EstudianteController {
    EstudianteDao listado = new EstudianteDao();


    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCarrera;
    @FXML
    private DatePicker dpFechaNacimiento;
    @FXML
    private CheckBox chkTieneBeca;
    @FXML
    private Label lblRegistro;
    @FXML
    private ComboBox<String> cbDepartamento;
    @FXML
    private RadioButton rbMasculino;
    @FXML
    private RadioButton rbFemenino;
    @FXML
    private ToggleGroup grupoGenero;

    @FXML
    public void initialize() {
        cbDepartamento.setItems(FXCollections.observableArrayList(
                "Managua", "León", "Chinandega", "Masaya",
                "Matagalpa", "Jinotega", "Estelí", "Granada"
        ));

        if (rbMasculino != null) rbMasculino.setToggleGroup(grupoGenero);
        if (rbFemenino != null) rbFemenino.setToggleGroup(grupoGenero);
    }



    @FXML
    protected void guardarOnClick() {
        leerDatos();
        contarRegistros();
        limpiarFormulario();
    }

    private void leerDatos() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String carrera = txtCarrera.getText();
        LocalDate fechaNac = dpFechaNacimiento.getValue();
        boolean tieneBeca = chkTieneBeca.isSelected();
        String departamento = cbDepartamento.getValue();
        String genero = obtenerGeneroSeleccionado();
        agregarDatos(new Estudiante(nombre, apellido, carrera, fechaNac,
                tieneBeca, genero, departamento));
    }

    private String obtenerGeneroSeleccionado() {
        RadioButton radioSeleccionado = (RadioButton) grupoGenero.getSelectedToggle();
        return radioSeleccionado != null ? radioSeleccionado.getText() : null;
    }


    private void agregarDatos(Estudiante estudiante) {
        listado.agregar(estudiante);

    }

    private void contarRegistros() {
        int cantidad = listado.Obtener().size();
        lblRegistro.setText("Cantidad de estudiantes registrados: " + cantidad);

    }


    private void limpiarFormulario() {
        txtNombre.clear();
        txtApellido.clear();
        txtCarrera.clear();
        dpFechaNacimiento.setValue(null);
        chkTieneBeca.setSelected(false);
        cbDepartamento.setValue(null);
        grupoGenero.selectToggle(null);
    }
}














