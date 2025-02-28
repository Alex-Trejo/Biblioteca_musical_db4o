/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecamusicaldb4o.model;

/**
 *
 * @author trejo
 */
public class CancionPremium extends Cancion {
    private double precio;
    private String calidad;

    public CancionPremium(String titulo, Artista artista, String genero, Album album, double precio, String calidad) {
        super(titulo, artista, genero, album);
        this.precio = precio;
        this.calidad = calidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }
    
    
    
    

    @Override
    public String toString() {
        return super.toString() + " - Premium: " + precio + " USD, Calidad: " + calidad;
    }
}


