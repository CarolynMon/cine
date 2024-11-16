/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Cine {
    private String nombre;
    private String direccion;
    private String telefono;
    private String precios;

    public Cine(String nombre, String direccion, String telefono, String precios) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.precios = precios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPrecios() {
        return precios;
    }

    @Override
    public String toString() {
        return "Cine: " + nombre + "\nDirección: " + direccion + "\nTeléfono: " + telefono + "\nPrecios: " + precios;
    }
}
