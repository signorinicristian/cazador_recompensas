package ar.edu.unahur.obj2.profugos;

import ar.edu.unahur.obj2.excepciones.HabilidadInvalidaException;

public class Profugo implements IProfugo {
    private Integer inocencia;
    private Integer habilidad;
    private Boolean esNervioso;

    public Profugo(Integer inocencia, Integer habilidad, Boolean esNervioso) {
        if (habilidad < 1 || habilidad > 100) {
            throw new HabilidadInvalidaException("La habilidad debe estar entre 1 y 100");
        }
        this.inocencia = inocencia;
        this.habilidad = habilidad;
        this.esNervioso = esNervioso;
    }

    @Override
    public Integer getInocencia() {
        return inocencia;
    }

    public void setInocencia(Integer nuevoValor) {
        inocencia = nuevoValor;
    }

    @Override
    public Integer getHabilidad() {
        return habilidad;
    }

    @Override
    public Boolean esNervioso() {
        return esNervioso;
    }

    @Override
    public void volverseNervioso() {
        esNervioso = true;
    }

    @Override
    public void dejarDeEstarNervioso() {
        esNervioso = false;
    }

    @Override
    public void reducirHabilidad() {
        habilidad = Math.max(habilidad - 5, 0);
    }

    @Override
    public void disminuirInocencia() {
        inocencia = Math.max(inocencia - 2, 0);
    }


}
