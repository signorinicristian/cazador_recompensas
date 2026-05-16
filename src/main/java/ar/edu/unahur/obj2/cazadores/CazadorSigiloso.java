package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.Profugo;

public class CazadorSigiloso extends Cazador {
    @Override
    public Boolean doPuedeCazar(Profugo unProfugo) {
        return unProfugo.getNivelHabilidad() < 50;
    }

    @Override
    public void intimidar(Profugo unProfugo) {
        unProfugo.setNivelHabilidad(Math.max(unProfugo.getNivelHabilidad() - 5, 0));
    }
}
