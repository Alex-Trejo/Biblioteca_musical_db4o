/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecamusicaldb4o.model;

/**
 *
 * @author trejo
 */
public class Album {
    private String nombre;
    private int año;

    public Album() {

    } 
    
    public Album(String nombre, int año) {
        this.nombre = nombre;
        this.año = año;
    }

    public String getNombre() { return nombre; }
    public int getAño() { return año; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    
    
    @Override
    public String toString() {
        return "Album: " + nombre + " (" + año + ")";
    }
}
