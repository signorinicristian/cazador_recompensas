package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.agencia.Agencia;
import ar.edu.unahur.obj2.cazadores.CazadorUrbano;
import ar.edu.unahur.obj2.cazadores.CazadorSigiloso;
import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.zona.Zona;

public class AgenciaTest {

    @Test
    void todosLosProfugosCapturados_y_masHabilCapturado() {
        Agencia.getInstance().getCazadores().clear();

        Profugo p1 = new Profugo(5, 20, false);
        Profugo p2 = new Profugo(9, 30, false);
        Set<Profugo> set1 = new HashSet<>(Set.of(p1, p2));
        Zona z1 = new Zona("Z1", set1);
        CazadorUrbano caz1 = new CazadorUrbano(10);
        caz1.realizarProcesoDeCaptura(z1);

        Profugo p3 = new Profugo(50, 80, true);
        Set<Profugo> set2 = new HashSet<>(Set.of(p3));
        Zona z2 = new Zona("Z2", set2);
        CazadorSigiloso caz2 = new CazadorSigiloso(100);
        caz2.realizarProcesoDeCaptura(z2);

        Agencia.getInstance().agregarCazador(caz1);
        Agencia.getInstance().agregarCazador(caz2);

        assertEquals(3, Agencia.getInstance().todosLosProfugosCapturados().size());
        assertEquals(p3, Agencia.getInstance().masHabilCapturado());
    }

    @Test
    void cazadorConMasCapturas_devuelveElCorrecto() {
        Agencia.getInstance().getCazadores().clear();

        Profugo a = new Profugo(2, 10, false);
        Profugo b = new Profugo(3, 15, false);
        Zona zA = new Zona("A", new HashSet<>(Set.of(a, b)));
        CazadorUrbano cazA = new CazadorUrbano(10);
        cazA.realizarProcesoDeCaptura(zA);

        Profugo c = new Profugo(1, 50, true);
        Zona zB = new Zona("B", new HashSet<>(Set.of(c)));
        CazadorSigiloso cazB = new CazadorSigiloso(100);
        cazB.realizarProcesoDeCaptura(zB);

        Agencia.getInstance().agregarCazador(cazA);
        Agencia.getInstance().agregarCazador(cazB);

        assertSame(cazA.getClass(), Agencia.getInstance().cazadorConMasCapturas().getClass());
        assertEquals(2, Agencia.getInstance().cazadorConMasCapturas().getProfugosCapturados().size());
    }
}
