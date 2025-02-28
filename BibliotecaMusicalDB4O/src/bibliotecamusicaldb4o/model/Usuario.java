/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecamusicaldb4o.model;

import java.util.List;

/**
 *
 * @author trejo
 */
public class Usuario extends Persona{
    
    private List<Playlist> playlists;

    public Usuario(String nombre, String correo, List<Playlist> playlists) {
        super(nombre, correo);
        this.playlists = playlists;
    }

    public List<Playlist> getPlaylists() { return playlists; }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
    
    

    @Override
    public String toString() {
        return super.toString() + ", Playlists: " + playlists;
    }
    
}
