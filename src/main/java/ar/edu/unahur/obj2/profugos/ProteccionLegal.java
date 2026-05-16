package ar.edu.unahur.obj2.profugos;

public class ProteccionLegal extends ProfugoDecorator {
    public ProteccionLegal(IProfugo profugo) {
        super(profugo);
    }

    @Override
    public Integer getInocencia() {
        return Math.max(super.getInocencia(), 40);
    }

    @Override
    public Integer getHabilidad() {
        return super.getHabilidad();
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
        if (super.getInocencia() > 40) {
            super.disminuirInocencia();
        }
    }
}
