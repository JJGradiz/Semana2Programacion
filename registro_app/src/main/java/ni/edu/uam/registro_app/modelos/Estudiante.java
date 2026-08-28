package ni.edu.uam.registro_app.modelos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class Estudiante {
    private String nombre;
    private String apellido;
    private String carrera;
    private LocalDate fechaNacimiento;
    private Boolean tieneBeca;
    private String genero;
    private String departamento;

    public Estudiante(String nombre, String apellido, String carrera, LocalDate fechaNacimiento, Boolean tieneBeca, String genero, String departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.fechaNacimiento = fechaNacimiento;
        this.tieneBeca = tieneBeca;
        this.genero = genero;
        this.departamento = departamento;
    }
}
