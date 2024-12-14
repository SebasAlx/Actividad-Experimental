package GestionParqueadero;

public class Vehiculo {
    private static int contadorId = 1; // Atributo estático para generar IDs únicos
    private final int id; // ID único
    private String placa;
    private String propietario;
    private String tipoVehiculo; // "Carro" o "Moto"
    private long horaEntrada; // En milisegundos
    private long horaSalida; // En milisegundos
    private boolean estado; // true: dentro del parqueadero, false: salió

    public Vehiculo(String placa, String propietario, String tipoVehiculo, long horaEntrada) {
        this.id = contadorId++;
        this.placa = placa;
        this.propietario = propietario;
        this.tipoVehiculo = tipoVehiculo;
        this.horaEntrada = horaEntrada;
        this.estado = true; 
    }

    public int getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public long getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraSalida(long horaSalida) {
        this.horaSalida = horaSalida;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double calcularPago() {
        if (horaSalida > horaEntrada) {
            long horas = (horaSalida - horaEntrada) / (1000 * 60 * 60); // Convertir de milisegundos a horas
            if (tipoVehiculo.equalsIgnoreCase("Moto")) {
                return horas * 0.50; // 50 centavos por hora para motos
            } else if (tipoVehiculo.equalsIgnoreCase("Carro")) {
                return horas * 1.0; // 1 dólar por hora para carros
            }
        }
        return 0.0;
    }
    

    @Override
    public String toString() {
        String estadoStr = estado ? "Dentro" : "Salió";
        return "ID: " + id + ", Placa: " + placa + ", Propietario: " + propietario +
               ", Tipo: " + tipoVehiculo + ", Estado: " + estadoStr;
    }
}
