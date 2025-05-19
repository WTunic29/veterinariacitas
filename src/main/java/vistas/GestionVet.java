/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import dao.CitaDaoMongo;
import dao.CitaDao;
import modelo.Cita;

import javax.swing.*;

/**
 *
 * @author poeta
 */
public class GestionVet extends JFrame {

    private JTextField txtId, txtFecha, txtHora, txtEstado;
    private JButton btnBuscar, btnActualizar, btnCancelar, btnHistorial;

    private CitaDao citaDAO = new CitaDaoMongo();
    private Cita citaActual;

    public GestionVet() {
        setTitle("Gestión de Citas - Veterinario");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel lblId = new JLabel("ID de Cita:");
        lblId.setBounds(30, 30, 100, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(140, 30, 200, 25);
        add(txtId);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(140, 60, 100, 25);
        add(btnBuscar);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(30, 100, 100, 25);
        add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(140, 100, 200, 25);
        add(txtFecha);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setBounds(30, 140, 100, 25);
        add(lblHora);

        txtHora = new JTextField();
        txtHora.setBounds(140, 140, 200, 25);
        add(txtHora);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(30, 180, 100, 25);
        add(lblEstado);

        txtEstado = new JTextField();
        txtEstado.setBounds(140, 180, 200, 25);
        add(txtEstado);

        btnActualizar = new JButton("Actualizar Cita");
        btnActualizar.setBounds(30, 220, 150, 30);
        add(btnActualizar);

        btnCancelar = new JButton("Cancelar Cita");
        btnCancelar.setBounds(200, 220, 140, 30);
        add(btnCancelar);

        btnHistorial = new JButton("Registrar Historial");
        btnHistorial.setBounds(100, 270, 180, 30);
        add(btnHistorial);

        eventos();

        setVisible(true);
    }

    private void eventos() {
        btnBuscar.addActionListener(e -> {
            citaActual = citaDAO.buscarPorId(txtId.getText());
            if (citaActual != null) {
                txtFecha.setText(citaActual.getFecha());
                txtHora.setText(citaActual.getHora());
                txtEstado.setText(citaActual.getEstado());
            } else {
                JOptionPane.showMessageDialog(this, "Cita no encontrada.");
            }
        });

        btnActualizar.addActionListener(e -> {
            if (citaActual != null) {
                citaActual.setFecha(txtFecha.getText());
                citaActual.setHora(txtHora.getText());
                citaActual.setEstado(txtEstado.getText());
                citaDAO.actualizar(citaActual);
                JOptionPane.showMessageDialog(this, "Cita actualizada.");
            }
        });

        btnCancelar.addActionListener(e -> {
            if (citaActual != null) {
                citaDAO.cancelarCita(citaActual.getId());
                txtEstado.setText("Cancelada");
                JOptionPane.showMessageDialog(this, "Cita cancelada.");
            }
        });

        btnHistorial.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Funcionalidad de historial en desarrollo.");
        });
    }
}
