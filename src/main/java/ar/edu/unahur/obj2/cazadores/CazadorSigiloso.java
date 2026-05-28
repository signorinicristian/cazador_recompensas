package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.Profugo;

public class CazadorSigiloso extends Cazador {

    public CazadorSigiloso(Integer experiencia) {
        super(experiencia);
    }

    @Override
    protected Boolean condicionEspecifica(Profugo profugo) {
        return profugo.esNervioso();
    }

    @Override
    protected void intimidacionEspecifica(Profugo profugo) {
        profugo.reducirHabilidad();
    }

}
