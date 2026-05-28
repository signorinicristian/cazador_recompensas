package ar.edu.unahur.obj2.decoradores;

import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.profugos.Profugo;

public class DecoradorBase implements IProfugo {
	private IProfugo profugoEnvuelto;

	public DecoradorBase(IProfugo profugoEnvuelto) {
		this.profugoEnvuelto = profugoEnvuelto;
	}

	@Override
	public Integer getInocencia() {
		return profugoEnvuelto.getInocencia();
	}

	protected void setInocencia(Integer nuevoValor) {
		if (profugoEnvuelto instanceof Profugo) {
			((Profugo) profugoEnvuelto).setInocencia(nuevoValor);
		} else {
			throw new UnsupportedOperationException("No se puede setear inocencia en el envuelto");
		}
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
