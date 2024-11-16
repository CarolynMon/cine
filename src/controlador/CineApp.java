/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Modelo.Funcion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import vista.CineDB;

public class CineApp extends JFrame {
    private JComboBox<String> generoBox;
    private JTextField tituloField;
    private JTextField cineField;
    private JTextArea resultadoArea;
    private CineDB cineDB;
    
    public CineApp() {
        cineDB = new CineDB();  // Inicializar la base de datos simulada

        setTitle("Consulta de Cines y Películas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        JPanel searchPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        
        JLabel generoLabel = new JLabel("Género:");
        generoBox = new JComboBox<>(new String[]{"Todos", "Comedia", "Intriga", "Animación", "Acción", "Drama"});
        
        JLabel tituloLabel = new JLabel("Título:");
        tituloField = new JTextField();
        
        JLabel cineLabel = new JLabel("Cine:");
        cineField = new JTextField();
        
        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new BuscarListener());
        
        searchPanel.add(generoLabel);
        searchPanel.add(generoBox);
        searchPanel.add(tituloLabel);
        searchPanel.add(tituloField);
        searchPanel.add(cineLabel);
        searchPanel.add(cineField);
        searchPanel.add(new JLabel());  
        searchPanel.add(buscarButton);
        
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        
        mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        add(mainPanel);
    }
    
    private class BuscarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String genero = (String) generoBox.getSelectedItem();
            String titulo = tituloField.getText().trim();
            String cine = cineField.getText().trim();
            
            List<Funcion> resultados = cineDB.buscarFuncion(titulo, genero, cine);
            resultadoArea.setText("");
            
            if (resultados.isEmpty()) {
                resultadoArea.append("No se encontraron resultados.\n");
            } else {
                for (Funcion funcion : resultados) {
                    resultadoArea.append(funcion.toString() + "\n-------------------------\n");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CineApp app = new CineApp();
            app.setVisible(true);


        });
    }
}
