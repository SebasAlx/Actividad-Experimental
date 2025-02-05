package Modularidad;

public class main {
    public static void main(String[] args) {
        // Crear servicio de usuario
        servicio usuarioService = new servicio();

        // Crear usuarios
        Usuario usuario1 = new Usuario("Juan", 25);
        Usuario usuario2 = new Usuario("Ana", 30);

        // Agregar usuarios al servicio
        usuarioService.agregarUsuario(usuario1);
        usuarioService.agregarUsuario(usuario2);

        // Listar los usuarios
        usuarioService.listarUsuarios();
    }
}
