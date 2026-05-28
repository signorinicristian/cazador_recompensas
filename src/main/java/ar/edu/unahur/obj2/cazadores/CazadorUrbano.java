package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.Profugo;

public class CazadorUrbano extends Cazador {

    public CazadorUrbano(Integer experiencia) {
        super(experiencia);
    }

    @Override
    protected Boolean condicionEspecifica(Profugo profugo) {
        return !profugo.esNervioso();
    }

    @Override
    protected void intimidacionEspecifica(Profugo profugo) {
        profugo.dejarDeEstarNervioso();
    }

}
