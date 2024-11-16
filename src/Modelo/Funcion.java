/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Funcion {
    private Cine cine;
    private Pelicula pelicula;
    private String horario;

    public Funcion(Cine cine, Pelicula pelicula, String horario) {
        this.cine = cine;
        this.pelicula = pelicula;
        this.horario = horario;
    }

    public Cine getCine() {
        return cine;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public String getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return cine.toString() + "\n" + pelicula.toString() + "\nHorario: " + horario;
    }
}
