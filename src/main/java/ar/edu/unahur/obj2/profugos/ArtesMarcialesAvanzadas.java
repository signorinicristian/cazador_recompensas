package ar.edu.unahur.obj2.profugos;

public class ArtesMarcialesAvanzadas extends ProfugoDecorator {

    public ArtesMarcialesAvanzadas(IProfugo profugo) {
        super(profugo);
    }

    @Override
    public Integer getInocencia() {
        return super.getInocencia();
    }

    @Override
    public Integer getHabilidad() {
        return Math.min(super.getHabilidad() * 2, 100);
    }

    @Override
    public Boolean esNervioso() {
        return super.esNervioso();
    }

    @Override
    public void volverseNervioso() {
        super.volverseNervioso();
    }

    @Override
    public void dejarDeEstarNervioso() {
        super.dejarDeEstarNervioso();
    }

    @Override
    public void reducirHabilidad() {
        super.reducirHabilidad();
    }

    @Override
    public void disminuirInocencia() {
        super.disminuirInocencia();
    }
    
}
