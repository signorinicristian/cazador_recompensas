package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.Profugo;

public class CazadorRural extends Cazador {

    public CazadorRural(Integer experiencia) {
        super(experiencia);
    }

    @Override
    protected Boolean condicionEspecifica(Profugo profugo) {
        return profugo.getHabilidad() < 50;
    }

    @Override
    protected void intimidacionEspecifica(Profugo profugo) {
        profugo.volverseNervioso();
    }

}
