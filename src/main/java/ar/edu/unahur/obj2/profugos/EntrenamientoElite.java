package ar.edu.unahur.obj2.profugos;

public class EntrenamientoElite extends ProfugoDecorator {
    public EntrenamientoElite(IProfugo profugo) {
        super(profugo);
    }

    @Override
    public Integer getInocencia() {
        return super.getInocencia();
    }

    @Override
    public Integer getHabilidad() {
        return super.getHabilidad();
    }

    @Override
    public Boolean esNervioso() {
        return false;
    }

    @Override
    public void volverseNervioso() {

    }

    @Override
    public void dejarDeEstarNervioso() {

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
