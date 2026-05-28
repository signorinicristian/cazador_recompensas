package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.excepciones.HabilidadInvalidaException;
import ar.edu.unahur.obj2.profugos.Profugo;

public class HabilidadInvalidaExceptionTest {

    @Test
    void lanzaExcepcionCuandoLaHabilidadEsInvalida() {
        assertThrows(HabilidadInvalidaException.class, () -> new Profugo(10, 0, false));
        assertThrows(HabilidadInvalidaException.class, () -> new Profugo(10, 101, false));
    }
}
