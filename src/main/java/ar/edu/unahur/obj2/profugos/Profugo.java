package ar.edu.unahur.obj2.profugos;

import ar.edu.unahur.obj2.excepciones.HabilidadInvalidaException;

public class Profugo implements IProfugo{
    private Integer nivelInocencia;

    private Integer nivelHabilidad;

    private Boolean esNervioso;

    public Profugo(Integer inocencia, Integer habilidad, Boolean esNervioso) {
        if (habilidad <= 0 || habilidad >= 101) {
            throw new HabilidadInvalidaException("El nivel de habilidad debe estar entre 1 y 100");
        }
        this.nivelInocencia = inocencia;
        this.nivelHabilidad = habilidad;
        this.esNervioso = esNervioso;
    }

    public Integer getNivelInocencia() {
        return this.nivelInocencia;
    }

    public Integer getNivelHabilidad() {
        return this.nivelHabilidad;
    }

    public Boolean esNervioso() {
        return this.esNervioso;
    }

    public void setEsNervioso(Boolean nuevoEstado) {
        this.esNervioso = nuevoEstado;
    }

    public void setNivelHabilidad(Integer nuevoNivel) {
        this.nivelHabilidad = nuevoNivel;
    }

    @Override
    public Integer getInocencia() {
        return this.nivelInocencia;
    }

    @Override
    public Integer getHabilidad() {
        return this.nivelHabilidad;
    }

    @Override
    public void volverseNervioso() {
        this.setEsNervioso(true);
    }

    @Override
    public void dejarDeEstarNervioso() {
        this.setEsNervioso(false);
    }

    @Override
    public void reducirHabilidad() {
        this.setNivelHabilidad(Math.max(this.nivelHabilidad - 5, 0));
    }

    @Override
    public void disminuirInocencia() {
        this.nivelInocencia = Math.max(this.nivelInocencia - 1, 0);
    }
}
