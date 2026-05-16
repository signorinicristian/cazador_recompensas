package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.Profugo;

public class CazadorUrbano extends Cazador {
    @Override
    public Boolean doPuedeCazar(Profugo unProfugo) {
        return !unProfugo.esNervioso();
    }

    @Override
    public void intimidar(Profugo unProfugo) {
        unProfugo.setEsNervioso(false);
    }
}
