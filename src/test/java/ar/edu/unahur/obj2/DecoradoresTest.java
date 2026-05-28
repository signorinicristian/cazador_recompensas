package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.decoradores.ArtesMarcialesAvanzadas;
import ar.edu.unahur.obj2.decoradores.EntrenamientoDeElite;
import ar.edu.unahur.obj2.decoradores.ProteccionLegal;
import ar.edu.unahur.obj2.excepciones.NoPuedeSerNerviosoException;
import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.profugos.IProfugo;

public class DecoradoresTest {

    @Test
    void artesMarcialesDuplicaHabilidadYRespetaTope() {
        Profugo p = new Profugo(10, 30, false);
        IProfugo decorado = new ArtesMarcialesAvanzadas(p);

        assertEquals(60, decorado.getHabilidad());

        decorado.reducirHabilidad(); 
        assertEquals(50, decorado.getHabilidad());

        Profugo p2 = new Profugo(10, 60, false);
        IProfugo decorado2 = new ArtesMarcialesAvanzadas(p2);
        assertEquals(100, decorado2.getHabilidad());
    }

    @Test
    void entrenamientoDeElite_impideNerviosismoYLanzaExcepcion() {
        Profugo p = new Profugo(20, 40, true);
        IProfugo decorado = new EntrenamientoDeElite(p);

        assertFalse(decorado.esNervioso());
        assertThrows(NoPuedeSerNerviosoException.class, () -> decorado.volverseNervioso());
        assertThrows(NoPuedeSerNerviosoException.class, () -> decorado.dejarDeEstarNervioso());
    }

    @Test
    void proteccionLegal_noPermiteInocenciaMenorA40() {
        Profugo p = new Profugo(50, 30, false);
        IProfugo decorado = new ProteccionLegal(p);

        assertEquals(50, decorado.getInocencia());
        decorado.disminuirInocencia(); 
        assertEquals(48, decorado.getInocencia());

        Profugo p2 = new Profugo(41, 20, false);
        IProfugo decorado2 = new ProteccionLegal(p2);
        decorado2.disminuirInocencia();
        assertEquals(40, decorado2.getInocencia());

        Profugo p3 = new Profugo(40, 10, false);
        IProfugo decorado3 = new ProteccionLegal(p3);
        decorado3.disminuirInocencia();
        assertEquals(40, decorado3.getInocencia());
    }
}
