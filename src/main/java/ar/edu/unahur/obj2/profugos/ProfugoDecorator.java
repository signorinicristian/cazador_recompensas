package ar.edu.unahur.obj2.profugos;

public abstract class ProfugoDecorator implements IProfugo {
    protected IProfugo profugoEnvuelto;

    public ProfugoDecorator(IProfugo profugo) {
        this.profugoEnvuelto = profugo;
    }

    @Override
    public Integer getInocencia() {
        return profugoEnvuelto.getInocencia();
    }

    @Override
    public Integer getHabilidad() {
        return profugoEnvuelto.getHabilidad();
    }

    @Override
    public Boolean esNervioso() {
        return profugoEnvuelto.esNervioso();
    }

    @Override
    public void volverseNervioso() {
        profugoEnvuelto.volverseNervioso();
    }

    @Override
    public void dejarDeEstarNervioso() {
        profugoEnvuelto.dejarDeEstarNervioso();
    }

    @Override
    public void reducirHabilidad() {
        profugoEnvuelto.reducirHabilidad();
    }

    @Override
    public void disminuirInocencia() {
        profugoEnvuelto.disminuirInocencia();
    }
}
