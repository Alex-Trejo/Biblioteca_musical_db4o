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
public class Artista extends Persona {
    private List<String> discografia;

    public Artista(String nombre, String correo, List<String> discografia) {
        super(nombre, correo);
        this.discografia = discografia;
    }

    public List<String> getDiscografia() { return discografia; }

    public void setDiscografia(List<String> discografia) {
        this.discografia = discografia;
    }
    
    
    

    @Override
    public String toString() {
        return super.toString() + ", Discografia: " + discografia;
    }
}
