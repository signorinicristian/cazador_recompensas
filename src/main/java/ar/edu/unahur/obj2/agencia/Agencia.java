package ar.edu.unahur.obj2.agencia;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Comparator;

import ar.edu.unahur.obj2.cazadores.Cazador;
import ar.edu.unahur.obj2.zona.Zona;
import ar.edu.unahur.obj2.profugos.Profugo;

public class Agencia {
    private Set<Cazador> cazadores = new HashSet<>();
    private Set<Zona> zonas = new HashSet<>();
    
    public Agencia(Set<Cazador> cazadores, Set<Zona> zonas) {
        this.cazadores = cazadores;
        this.zonas = zonas;
    }

    public Integer profugosCapturadosEnTotal() {
        return this.cazadores.stream()
                .mapToInt(c -> c.getProfugosCapturados().size())
                .sum();
    }

    public Profugo profugoMasHabil() {
        return this.cazadores.stream()
                .map(c -> c.profugoMasHabilCapturado())
                .filter(p -> p != null)
                .max((p1, p2) -> Integer.compare(p1.getHabilidad(), p2.getHabilidad()))
                .orElse(null);
    }

    public Cazador cazadorConMasCapturas() {
        return this.cazadores.stream()
                .max(Comparator.comparingInt(c -> c.getProfugosCapturados().size()))
                .orElse(null);
    }
}
