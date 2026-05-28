package ar.edu.unahur.obj2.decoradores;

import ar.edu.unahur.obj2.excepciones.NoPuedeSerNerviosoException;
import ar.edu.unahur.obj2.profugos.IProfugo;

public class EntrenamientoDeElite extends DecoradorBase {

    public EntrenamientoDeElite(IProfugo profugoEnvuelto) {
        super(profugoEnvuelto);
    }

    @Override
    public Boolean esNervioso() {
        return false;
    }

    @Override
    public void volverseNervioso() {
        throw new NoPuedeSerNerviosoException("No puede ser nervioso, posee entrenamiento de élite.");
    }

    @Override
    public void dejarDeEstarNervioso() {
        throw new NoPuedeSerNerviosoException("No puede ser nervioso, posee entrenamiento de élite.");
    }
}
