package ar.edu.unahur.obj2.agencia;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import ar.edu.unahur.obj2.cazadores.Cazador;
import ar.edu.unahur.obj2.profugos.Profugo;

public class Agencia {
    private static Agencia instancia = new Agencia();
    private Set<Cazador> cazadores = new HashSet<>();

    public static Agencia getInstance() {
        return instancia;
    }
    
    private Agencia() {}

    public Set<Cazador> getCazadores() {
        return cazadores;
    }

    public void agregarCazador(Cazador cazador) {
        cazadores.add(cazador);
    }

    public Set<Profugo> todosLosProfugosCapturados() {
        Set<Profugo> profugosCapturados = new HashSet<>();
        cazadores.forEach(c -> {
            c.getProfugosCapturados().forEach(p -> {
                profugosCapturados.add(p);
            });
        });
        return profugosCapturados;
    }

    
    public Profugo masHabilCapturado() {
        return this.todosLosProfugosCapturados().stream()
            .max(Comparator.comparingInt(p -> p.getHabilidad()))
            .orElseThrow();
    }

    public Cazador cazadorConMasCapturas() {
        return cazadores.stream().max(Comparator.comparingInt(c -> c.getProfugosCapturados().size()))
            .orElseThrow();
    }
}
