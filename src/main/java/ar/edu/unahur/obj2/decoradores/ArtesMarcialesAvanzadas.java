package ar.edu.unahur.obj2.decoradores;

import ar.edu.unahur.obj2.profugos.IProfugo;

public class ArtesMarcialesAvanzadas extends DecoradorBase {

    public ArtesMarcialesAvanzadas(IProfugo profugoEnvuelto) {
        super(profugoEnvuelto);
    }

    @Override
    public Integer getHabilidad() {
        return Math.min(super.getHabilidad() * 2, 100);
    }
    
}
