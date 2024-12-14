package GestionParqueadero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGrafica extends JFrame {
    private Parqueadero parqueadero;

    private JTextField placaField;
    private JTextField propietarioField;
    private JTextField tipoVehiculoField;
    private JTextField idSalidaField;
    private JTextArea displayArea;

    public InterfazGrafica() {
        parqueadero = new Parqueadero();

        // Configuración de la ventana
        setTitle("Gestión del Parqueadero");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel de entrada de datos (registro de vehículo) en la parte superior
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel placaLabel = new JLabel("Placa:");
        placaField = new JTextField();
        JLabel propietarioLabel = new JLabel("Propietario:");
        propietarioField = new JTextField();
        JLabel tipoVehiculoLabel = new JLabel("Tipo Vehículo(Carro o Moto):");
        tipoVehiculoField = new JTextField();

        inputPanel.add(placaLabel);
        inputPanel.add(placaField);
        inputPanel.add(propietarioLabel);
        inputPanel.add(propietarioField);
        inputPanel.add(tipoVehiculoLabel);
        inputPanel.add(tipoVehiculoField);

        // Botón para registrar vehículo
        JButton registrarButton = new JButton("Registrar Vehículo");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = placaField.getText();
                String propietario = propietarioField.getText();
                String tipoVehiculo = tipoVehiculoField.getText();
                long horaEntrada = System.currentTimeMillis();
                parqueadero.registrarVehiculo(placa, propietario, tipoVehiculo, horaEntrada);
                updateDisplay();
                // Mostrar el ID generado para el vehículo registrado
                Vehiculo ultimoVehiculo = parqueadero.getVehiculos().get(parqueadero.getVehiculos().size() - 1);
                JOptionPane.showMessageDialog(null, "¡Vehículo registrado con éxito! Su ID es: " + ultimoVehiculo.getId());
            }
        });

        // Panel para mostrar vehículos dentro
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Panel para registrar salida en la parte inferior
        JPanel salidaPanel = new JPanel();
        salidaPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel idSalidaLabel = new JLabel("ID del vehículo (para salida):");
        idSalidaField = new JTextField(10);
        JButton registrarSalidaButton = new JButton("Registrar Salida");
        registrarSalidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idVehiculo = Integer.parseInt(idSalidaField.getText());
                    long horaSalida = System.currentTimeMillis();
                    parqueadero.registrarSalida(idVehiculo, horaSalida);
                    updateDisplay();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.");
                }
            }
        });

        salidaPanel.add(idSalidaLabel);
        salidaPanel.add(idSalidaField);
        salidaPanel.add(registrarSalidaButton);

        // Botón para mostrar vehículos dentro
        JPanel mostrarPanel = new JPanel();
        JButton mostrarButton = new JButton("Mostrar Vehículos Dentro");
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDisplay();
            }
        });

        mostrarPanel.add(mostrarButton);

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.add(inputPanel, BorderLayout.NORTH); 
        mainPanel.add(registrarButton, BorderLayout.SOUTH); 

        // Agregar los componentes a la ventana
        add(mainPanel, BorderLayout.NORTH); 
        add(scrollPane, BorderLayout.CENTER);  
        add(salidaPanel, BorderLayout.SOUTH);  
        add(mostrarPanel, BorderLayout.EAST);  

        setVisible(true);
    }

    private void updateDisplay() {
        displayArea.setText(""); // Limpiar el área de texto
        for (Vehiculo vehiculo : parqueadero.getVehiculosDentro()) {
            displayArea.append(vehiculo.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        new InterfazGrafica();
    }
}
