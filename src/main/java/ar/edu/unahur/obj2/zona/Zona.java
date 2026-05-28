package ar.edu.unahur.obj2.zona;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unahur.obj2.profugos.Profugo;

public class Zona {
    private final String nombre;
    private Set<Profugo> profugos = new HashSet<>();
    
    public Zona(String nombre, Set<Profugo> profugos) {
        this.nombre = nombre;
        this.profugos = profugos;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Profugo> getProfugos() {
        return profugos;
    }

    public void quitarDeBusqueda(Profugo profugo) {
        profugos.remove(profugo);
    }
}
