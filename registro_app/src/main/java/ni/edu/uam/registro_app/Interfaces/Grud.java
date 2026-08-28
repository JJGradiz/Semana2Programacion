package ni.edu.uam.registro_app.Interfaces;

import java.util.List;

public interface Grud <T> {
    public void agregar(T entidad);
    public List<T> Obtener();

}
