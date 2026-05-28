package ar.edu.unahur.obj2.cazadores;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.zona.Zona;

public abstract class Cazador {
    private Integer experiencia;

    private Set<Profugo> profugosCapturados = new HashSet<>();

    public Cazador(Integer experiencia) {
        this.experiencia = experiencia;
    }

    public Set<Profugo> getProfugosCapturados() {
        return profugosCapturados;
    }

    protected void intimidar(Profugo profugo) {
        profugo.disminuirInocencia();
        this.intimidacionEspecifica(profugo);
    }

    protected void doCapturar(Profugo profugo) {
        profugosCapturados.add(profugo);
    }

    protected abstract Boolean condicionEspecifica(Profugo profugo);
    protected abstract void intimidacionEspecifica(Profugo profugo);

    public Integer getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }

    public void realizarProcesoDeCaptura(Zona unaZona) {
        Set<Profugo> profugosCapturados = new HashSet<>();
        Set<Profugo> intimidados = new HashSet<>();
        new HashSet<>(unaZona.getProfugos()).forEach(p -> {
            if (experiencia > p.getInocencia() && this.condicionEspecifica(p)) {
                this.doCapturar(p);
                profugosCapturados.add(p);
                unaZona.quitarDeBusqueda(p);
            } else {
                this.intimidar(p);
                intimidados.add(p);
            }
        });
        Integer habilidadMinima = intimidados.stream().mapToInt(i -> i.getHabilidad()).min().orElse(0);
        experiencia += habilidadMinima * (2 * profugosCapturados.size());

    }
}
