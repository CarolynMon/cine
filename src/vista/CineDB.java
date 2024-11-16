/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

    
import Modelo.Cine;
import Modelo.Funcion;
import Modelo.Pelicula;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class CineDB {
    private List<Funcion> funciones;
    private static final String FILE_NAME = "cine_db.txt";

    public CineDB() {
        funciones = new ArrayList<>();
        cargarDatosDesdeArchivo();
        
    }

    public void agregarFuncion(Funcion funcion) {
        funciones.add(funcion);
        guardarDatosEnArchivo();
    }

    public List<Funcion> buscarFuncion(String titulo, String genero, String cine) {
        List<Funcion> resultados = new ArrayList<>();
        
        for (Funcion funcion : funciones) {
            boolean coincideTitulo = titulo.isEmpty() || funcion.getPelicula().getTitulo().equalsIgnoreCase(titulo);
            boolean coincideGenero = genero.equals("Todos") || funcion.getPelicula().getGenero().equalsIgnoreCase(genero);
            boolean coincideCine = cine.isEmpty() || funcion.getCine().getNombre().equalsIgnoreCase(cine);
            
            if (coincideTitulo && coincideGenero && coincideCine) {
                resultados.add(funcion);
            }
        }
        
        return resultados;
    }

    private void guardarDatosEnArchivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Funcion funcion : funciones) {
                writer.println(funcion.getCine().getNombre());
                writer.println(funcion.getCine().getDireccion());
                writer.println(funcion.getCine().getTelefono());
                writer.println(funcion.getCine().getPrecios());
                writer.println(funcion.getPelicula().getTitulo());
                writer.println(funcion.getPelicula().getGenero());
                writer.println(funcion.getPelicula().getClasificacion());
                writer.println(String.join(",", funcion.getPelicula().getProtagonistas()));
                writer.println(funcion.getHorario());
                writer.println("---");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarDatosDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.equals("---")) continue;
                
                String nombreCine = linea;
                String direccion = reader.readLine();
                String telefono = reader.readLine();
                String precios = reader.readLine();
                
                Cine cine = new Cine(nombreCine, direccion, telefono, precios);
                
                String titulo = reader.readLine();
                String genero = reader.readLine();
                String clasificacion = reader.readLine();
                String[] protagonistas = reader.readLine().split(",");
                
                Pelicula pelicula = new Pelicula(titulo, null, protagonistas, genero, clasificacion);
                String horario = reader.readLine();
                
                funciones.add(new Funcion(cine, pelicula, horario));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de datos no encontrado. Se iniciará con una base vacía.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
