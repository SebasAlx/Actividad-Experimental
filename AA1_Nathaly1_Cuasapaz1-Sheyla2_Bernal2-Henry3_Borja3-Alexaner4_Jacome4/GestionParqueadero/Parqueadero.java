package GestionParqueadero;

import java.util.ArrayList;

public class Parqueadero {
    private ArrayList<Vehiculo> vehiculos;

    public Parqueadero() {
        this.setVehiculos(new ArrayList<>());
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
        
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
        
    }

    public void registrarVehiculo(String placa, String propietario, String tipoVehiculo, long horaEntrada) {
        Vehiculo vehiculo = new Vehiculo(placa, propietario, tipoVehiculo, horaEntrada);
        vehiculos.add(vehiculo);
        System.out.println("Vehículo registrado: " + vehiculo + " con ID: " + vehiculo.getId());
    }
    

    public void registrarSalida(int idVehiculo, long horaSalida) {
        Vehiculo vehiculo = buscarVehiculo(idVehiculo);
        if (vehiculo != null && vehiculo.isEstado()) {
            vehiculo.setHoraSalida(horaSalida);
            vehiculo.setEstado(false);
            double pago = vehiculo.calcularPago();
            System.out.println("El vehículo con ID " + idVehiculo + " ha salido. Total a pagar: $" + pago);
        } else {
            System.out.println("Vehículo no encontrado o ya salió.");
        }
    }
    
    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }
        return null; // Si no encuentra el vehículo
    }
    
    
    // Método adicional para obtener vehículos dentro del parqueadero
    public ArrayList<Vehiculo> getVehiculosDentro() {
        ArrayList<Vehiculo> vehiculosDentro = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.isEstado()) {
                vehiculosDentro.add(vehiculo);
            }
        }
        return vehiculosDentro;
    }
    
    public void mostrarVehiculosDentro() {
        System.out.println("\n--- Vehículos dentro del parqueadero ---");
        for (Vehiculo vehiculo : getVehiculos()) {
            if (vehiculo.isEstado()) {
                System.out.println(vehiculo);
            }
        }
    }

    Vehiculo buscarVehiculo(int id) {
        for (Vehiculo vehiculo : getVehiculos()) {
            if (vehiculo.getId() == id) {
                return vehiculo;
            }
        }
        return null;
    }

}
