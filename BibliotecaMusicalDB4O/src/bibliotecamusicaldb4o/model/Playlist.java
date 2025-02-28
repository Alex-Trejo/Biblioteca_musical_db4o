/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecamusicaldb4o.model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author trejo
 */
public class Playlist {
    
    private String nombre;
    private List<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Cancion> getCanciones() { return canciones; }

    // Agregar canción a la playlist
    public void agregarCancion(Cancion cancion) {
        this.canciones.add(cancion);
    }

    @Override
    public String toString() {
        return "🎼 Playlist: " + nombre + " | Canciones: " + canciones;
    }
    
    
    
}
