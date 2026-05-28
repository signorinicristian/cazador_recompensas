package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cazadores.CazadorRural;
import ar.edu.unahur.obj2.cazadores.CazadorSigiloso;
import ar.edu.unahur.obj2.cazadores.CazadorUrbano;
import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.zona.Zona;

public class ParteUnoTest {
    @Test
    void realizarProcesoDeCaptura() {
        Profugo p1 = new Profugo(10, 25, false);
        Profugo p2 = new Profugo(10, 52, false);
        Profugo p3 = new Profugo(80, 10, false);

        Zona z = new Zona("Centro", new HashSet<>(Set.of(p1, p2, p3)));
        CazadorUrbano cazador = new CazadorUrbano(15);

        cazador.realizarProcesoDeCaptura(z);

        assertEquals(2, cazador.getProfugosCapturados().size());
        assertTrue(cazador.getProfugosCapturados().contains(p1));
        assertTrue(cazador.getProfugosCapturados().contains(p2));
        assertFalse(cazador.getProfugosCapturados().contains(p3));

        assertEquals(1, z.getProfugos().size());
        assertTrue(z.getProfugos().contains(p3));
        assertFalse(z.getProfugos().contains(p1));
        assertFalse(z.getProfugos().contains(p2));

        assertEquals(78, p3.getInocencia());
        assertFalse(p3.esNervioso());

        assertEquals(55, cazador.getExperiencia());

    }

    @Test
    void realizarProcesoDeCapturaConCazadorRural() {
        Profugo p1 = new Profugo(20, 25, false);
        Profugo p2 = new Profugo(8, 60, false);
        Profugo p3 = new Profugo(70, 15, false);

        Zona z = new Zona("Campo", new HashSet<>(Set.of(p1, p2, p3)));
        CazadorRural cazador = new CazadorRural(30);

        cazador.realizarProcesoDeCaptura(z);

        assertEquals(1, cazador.getProfugosCapturados().size());
        assertTrue(cazador.getProfugosCapturados().contains(p1));
        assertFalse(cazador.getProfugosCapturados().contains(p2));
        assertFalse(cazador.getProfugosCapturados().contains(p3));

        assertEquals(2, z.getProfugos().size());
        assertTrue(z.getProfugos().contains(p2));
        assertTrue(z.getProfugos().contains(p3));
        assertFalse(z.getProfugos().contains(p1));

        assertTrue(p2.esNervioso());
        assertTrue(p3.esNervioso());
        assertEquals(6, p2.getInocencia());
        assertEquals(68, p3.getInocencia());

        assertEquals(60, cazador.getExperiencia());
    }

    @Test
    void realizarProcesoDeCapturaConCazadorSigiloso() {
        Profugo p1 = new Profugo(12, 20, true);
        Profugo p2 = new Profugo(9, 55, false);
        Profugo p3 = new Profugo(60, 30, true);

        Zona z = new Zona("Barrio", new HashSet<>(Set.of(p1, p2, p3)));
        CazadorSigiloso cazador = new CazadorSigiloso(18);

        cazador.realizarProcesoDeCaptura(z);

        assertEquals(1, cazador.getProfugosCapturados().size());
        assertTrue(cazador.getProfugosCapturados().contains(p1));
        assertFalse(cazador.getProfugosCapturados().contains(p2));
        assertFalse(cazador.getProfugosCapturados().contains(p3));

        assertEquals(2, z.getProfugos().size());
        assertTrue(z.getProfugos().contains(p2));
        assertTrue(z.getProfugos().contains(p3));
        assertFalse(z.getProfugos().contains(p1));

        assertEquals(7, p2.getInocencia());
        assertEquals(50, p2.getHabilidad());
        assertFalse(p2.esNervioso());
        assertEquals(58, p3.getInocencia());
        assertEquals(25, p3.getHabilidad());
        assertTrue(p3.esNervioso());

        assertEquals(68, cazador.getExperiencia());
    }
}
