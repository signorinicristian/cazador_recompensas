package ar.edu.unahur.obj2.zona;

import java.util.Set;

import ar.edu.unahur.obj2.profugos.Profugo;

public class Zona {
    private String nombre;
    private Set<Profugo> profugos;

    public Zona(String nombre, Set<Profugo> profugos) {
        this.nombre = nombre;
        this.profugos = profugos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Set<Profugo> getProfugos() {
        return this.profugos;
    }
}
