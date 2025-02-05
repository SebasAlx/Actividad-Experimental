package Modularidad;

import java.util.ArrayList;
import java.util.List;

// Clase que gestiona una lista de usuarios
public class servicio {
    private List<Usuario> usuarios = new ArrayList<>();

    // Método para agregar un usuario a la lista
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Método para listar todos los usuarios
    public void listarUsuarios() {
        System.out.println("Lista de Usuarios:");
        for (Usuario u : usuarios) {
            u.mostrarInfo();
        }
    }
}
