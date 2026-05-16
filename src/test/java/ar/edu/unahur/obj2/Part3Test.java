package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.agencia.Agencia;
import ar.edu.unahur.obj2.cazadores.CazadorRural;
import ar.edu.unahur.obj2.cazadores.CazadorSigiloso;
import ar.edu.unahur.obj2.cazadores.CazadorUrbano;
import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.zona.Zona;

public class Part3Test {

    @Test
    void reporteAgenciaReporteCapturasYMasHabilYCazadorTop() {
        // Crear prófugos
        Profugo pHigh = new Profugo(10, 90, false);
        Profugo pExtra = new Profugo(1, 20, false);
        Profugo pMid = new Profugo(20, 60, true);
        Profugo pLow = new Profugo(5, 30, false);

        // Zonas
        Set<Profugo> zona1Set = new HashSet<>();
        zona1Set.add(pHigh);
        zona1Set.add(pExtra);
        Zona zona1 = new Zona("Z1", zona1Set);

        Set<Profugo> zona2Set = new HashSet<>();
        zona2Set.add(pMid);
        Zona zona2 = new Zona("Z2", zona2Set);

        Set<Profugo> zona3Set = new HashSet<>();
        zona3Set.add(pLow);
        Zona zona3 = new Zona("Z3", zona3Set);

        // Cazadores
        CazadorUrbano urbano = new CazadorUrbano();
        urbano.setCantidadDeExperiencia(100);

        CazadorRural rural = new CazadorRural();
        rural.setCantidadDeExperiencia(100);

        CazadorSigiloso sigiloso = new CazadorSigiloso();
        sigiloso.setCantidadDeExperiencia(100);

        // Realizar capturas
        urbano.realizarProcesoDeCaptura(zona1); // debe capturar pHigh y pExtra
        rural.realizarProcesoDeCaptura(zona2);  // debe capturar pMid
        sigiloso.realizarProcesoDeCaptura(zona3); // debe capturar pLow

        // Crear agencia
        Set<CazadorUrbano> urbanos = new HashSet<>();
        Set<ar.edu.unahur.obj2.cazadores.Cazador> cazadores = new HashSet<>();
        cazadores.add(urbano);
        cazadores.add(rural);
        cazadores.add(sigiloso);

        Set<Zona> zonas = new HashSet<>();
        zonas.add(zona1);
        zonas.add(zona2);
        zonas.add(zona3);

        Agencia agencia = new Agencia(cazadores, zonas);

        // 1) Todos los prófugos capturados por sus cazadores (comprobamos recuento)
        assertEquals(4, agencia.profugosCapturadosEnTotal());

        // 2) El prófugo más hábil capturado
        Profugo masHabil = agencia.profugoMasHabil();
        assertNotNull(masHabil);
        assertEquals(90, masHabil.getHabilidad());

        // 3) El cazador con más capturas
        assertEquals(urbano, agencia.cazadorConMasCapturas());

        // También verificamos que la unión de capturas coincide con lo esperado
        Set<Profugo> union = new HashSet<>();
        cazadores.forEach(c -> union.addAll(c.getProfugosCapturados()));
        assertTrue(union.contains(pHigh));
        assertTrue(union.contains(pExtra));
        assertTrue(union.contains(pMid));
        assertTrue(union.contains(pLow));
        assertEquals(4, union.size());
    }
}
