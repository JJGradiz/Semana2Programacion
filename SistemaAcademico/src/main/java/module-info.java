module ni.edu.uam.sistemaacademico {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.sistemaacademico to javafx.fxml;
    exports ni.edu.uam.sistemaacademico;
}