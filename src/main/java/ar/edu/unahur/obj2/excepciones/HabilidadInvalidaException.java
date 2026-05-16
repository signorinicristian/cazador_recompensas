package ar.edu.unahur.obj2.excepciones;

public class HabilidadInvalidaException extends RuntimeException {
    public HabilidadInvalidaException(String mensaje) {
        super(mensaje);
    }
}
