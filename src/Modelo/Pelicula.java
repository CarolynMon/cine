/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
public class Pelicula {
    private String titulo;
    private String director;
    private String[] protagonistas;
    private String genero;
    private String clasificacion;

    public Pelicula(String titulo, String director, String[] protagonistas, String genero, String clasificacion) {
        this.titulo = titulo;
        this.director = director;
        this.protagonistas = protagonistas;
        this.genero = genero;
        this.clasificacion = clasificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getDirector() {
        return director;
    }

    public String[] getProtagonistas() {
        return protagonistas;
    }
    

    @Override
    public String toString() {
        return "Título: " + titulo + "\nDirector: " + director + "\nProtagonistas: " + String.join(", ", protagonistas) +
                "\nGénero: " + genero + "\nClasificación: " + clasificacion;
    }
}
