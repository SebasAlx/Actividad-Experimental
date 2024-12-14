package GestionParqueadero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú del Parqueadero ---");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Registrar salida");
            System.out.println("3. Mostrar vehículos dentro");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del vehículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Ingrese el nombre del propietario: ");
                    String propietario = scanner.nextLine();
                    System.out.print("Ingrese el tipo de vehículo (Carro/Moto): ");
                    String tipoVehiculo = scanner.nextLine();
                    long horaEntrada = System.currentTimeMillis();
                    parqueadero.registrarVehiculo(placa, propietario, tipoVehiculo, horaEntrada);
                    break;

                case 2:
                    System.out.print("Ingrese el ID del vehículo: ");
                    int idVehiculo = scanner.nextInt();
                    long horaSalida = System.currentTimeMillis();
                    parqueadero.registrarSalida(idVehiculo, horaSalida);
                    break;

                case 3:
                    parqueadero.mostrarVehiculosDentro();
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
