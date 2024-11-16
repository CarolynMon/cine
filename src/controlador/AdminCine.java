/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author USUARIO
 */

import Modelo.Cine;
import Modelo.Funcion;
import Modelo.Pelicula;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.CineDB;

public class AdminCine  extends JFrame {
    private JTextField cineField;
    private JTextField direccionField;
    private JTextField telefonoField;
    private JTextField preciosField;
    private JTextField tituloField;
    private JTextField directorField;
    private JTextField protagonistasField;
    private JTextField generoField;
    private JTextField clasificacionField;
    private JTextField horarioField;
    private CineDB cineDB;

    public AdminCine(CineDB cineDB) {
        this.cineDB = cineDB;

        setTitle("Gestión de Cines y Películas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("Nombre del Cine:"));
        cineField = new JTextField();
        add(cineField);

        add(new JLabel("Dirección:"));
        direccionField = new JTextField();
        add(direccionField);

        add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        add(telefonoField);

        add(new JLabel("Precios:"));
        preciosField = new JTextField();
        add(preciosField);

        add(new JLabel("Título de la Película:"));
        tituloField = new JTextField();
        add(tituloField);

        add(new JLabel("Director:"));
        directorField = new JTextField();
        add(directorField);

        add(new JLabel("Protagonistas (separados por coma):"));
        protagonistasField = new JTextField();
        add(protagonistasField);

        add(new JLabel("Género:"));
        generoField = new JTextField();
        add(generoField);

        add(new JLabel("Clasificación:"));
        clasificacionField = new JTextField();
        add(clasificacionField);

        add(new JLabel("Horario:"));
        horarioField = new JTextField();
        add(horarioField);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new GuardarListener());
        add(guardarButton);
    }

    private class GuardarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombreCine = cineField.getText().trim();
            String direccion = direccionField.getText().trim();
            String telefono = telefonoField.getText().trim();
            String precios = preciosField.getText().trim();
            String titulo = tituloField.getText().trim();
            String director = directorField.getText().trim();
            String[] protagonistas = protagonistasField.getText().trim().split(",");
            String genero = generoField.getText().trim();
            String clasificacion = clasificacionField.getText().trim();
            String horario = horarioField.getText().trim();

            Cine cine = new Cine(nombreCine, direccion, telefono, precios);
            Pelicula pelicula = new Pelicula(titulo, director, protagonistas, genero, clasificacion);
            Funcion funcion = new Funcion(cine, pelicula, horario);

            cineDB.agregarFuncion(funcion);

            JOptionPane.showMessageDialog(null, "Función guardada correctamente.");
            limpiarCampos();
        }

        private void limpiarCampos() {
            cineField.setText("");
            direccionField.setText("");
            telefonoField.setText("");
            preciosField.setText("");
            tituloField.setText("");
            directorField.setText("");
            protagonistasField.setText("");
            generoField.setText("");
            clasificacionField.setText("");
            horarioField.setText("");
        }
    }

    public static void main(String[] args) {
        CineDB cineDB = new CineDB();
        SwingUtilities.invokeLater(() -> {
            AdminCine adminApp = new AdminCine(cineDB);
            adminApp.setVisible(true);
        });
    }
}
