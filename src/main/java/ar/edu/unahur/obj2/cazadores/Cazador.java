package ar.edu.unahur.obj2.cazadores;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.zona.Zona;

public abstract class Cazador {
    protected String nombre;
    protected Integer cantidadDeExperiencia;
    protected Set<Profugo> profugosCapturados = new HashSet<Profugo>();
    protected List<Profugo> intimidados = new ArrayList<>();

    public Cazador() {}

    public void cazar(Profugo unProfugo) {
        profugosCapturados.add(unProfugo);
    }

    public abstract void intimidar(Profugo unProfugo);

    public Set<Profugo> getProfugosCapturados() {
        return this.profugosCapturados;
    }

    public void setCantidadDeExperiencia(Integer experiencia) {
        this.cantidadDeExperiencia = experiencia;
    }

    public Integer getCantidadDeExperiencia() {
        return this.cantidadDeExperiencia;
    }

    public void realizarProcesoDeCaptura(Zona unaZona) {
        unaZona.getProfugos().stream().forEach(p -> {
            if(this.puedeCazar(p) && this.doPuedeCazar(p)) {
                this.cazar(p);
                this.bonoDeCaza();
            } else {
                this.intimidar(p);
                intimidados.add(p);
            }
        });

    }

    private void bonoDeCaza() {
        Integer bonoPorIntimidados = this.intimidados.isEmpty() ? 0 :
            this.intimidados.stream().min((a, b) -> a.getNivelHabilidad().compareTo(b.getNivelHabilidad())).orElse(null).getNivelHabilidad();
        this.cantidadDeExperiencia += bonoPorIntimidados + 2 * this.profugosCapturados.size();
    }

    private Boolean puedeCazar(Profugo unProfugo) {
        return this.cantidadDeExperiencia > unProfugo.getNivelInocencia();
    }

    protected abstract Boolean doPuedeCazar(Profugo unProfugo);
    
    public Profugo profugoMasHabilCapturado() {
        return this.profugosCapturados.stream()
            .max((a, b) -> a.getNivelHabilidad().compareTo(b.getNivelHabilidad()))
            .orElse(null);
    }
}