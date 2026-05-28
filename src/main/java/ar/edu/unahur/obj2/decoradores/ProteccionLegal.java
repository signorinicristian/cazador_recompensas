package ar.edu.unahur.obj2.decoradores;

import ar.edu.unahur.obj2.profugos.IProfugo;

public class ProteccionLegal extends DecoradorBase {

    public ProteccionLegal(IProfugo profugoEnvuelto) {
        super(profugoEnvuelto);
    }

    @Override
    public Integer getInocencia() {
        return Math.max(40, super.getInocencia());
    }

    @Override
    public void disminuirInocencia() {
        super.setInocencia(Math.max(40, super.getInocencia() - 2));
    }

}
