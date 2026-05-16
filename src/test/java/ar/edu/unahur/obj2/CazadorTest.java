package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cazadores.CazadorRural;
import ar.edu.unahur.obj2.cazadores.CazadorUrbano;
import ar.edu.unahur.obj2.cazadores.CazadorSigiloso;
import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.zona.Zona;

public class CazadorTest {
    private Profugo profugoNervioso;
    private Profugo profugoNoNervioso;
    private Profugo profugoAltaHabilidad;
    private Profugo profugoBajaHabilidad;
    private Zona zona;

    @BeforeEach
    void setUp() {
        // Crear prófugos con diferentes características
        profugoNervioso = new Profugo(10, 30, true);
        profugoNoNervioso = new Profugo(20, 40, false);
        profugoAltaHabilidad = new Profugo(15, 80, false);
        profugoBajaHabilidad = new Profugo(25, 25, true);

        Set<Profugo> profugos = new HashSet<>();
        profugos.add(profugoNervioso);
        profugos.add(profugoNoNervioso);
        profugos.add(profugoAltaHabilidad);
        profugos.add(profugoBajaHabilidad);

        zona = new Zona("Centro", profugos);
    }

    @Test
    void testCazadorRuralRealizaProcesoDeCaptura() {
        // Crear un cazador rural con experiencia suficiente
        CazadorRural cazador = new CazadorRural();
        cazador.setCantidadDeExperiencia(50);

        // Realizar el proceso de captura
        cazador.realizarProcesoDeCaptura(zona);

        // Verificar que capturó los prófugos nerviosos
        assertTrue(cazador.getProfugosCapturados().contains(profugoNervioso));
        assertTrue(cazador.getProfugosCapturados().contains(profugoBajaHabilidad));
        assertEquals(2, cazador.getProfugosCapturados().size());

        // Verificar que los prófugos no capturados fueron intimidados
        // El cazador rural intimidida volviéndolos nerviosos
        assertTrue(profugoNoNervioso.esNervioso()); // Se vuelve nervioso al intimidar
        assertTrue(profugoAltaHabilidad.esNervioso()); // Se vuelve nervioso al intimidar
    }

    @Test
    void testCazadorUrbanoCapturaYIntimida() {
        // Crear un cazador urbano con experiencia suficiente
        CazadorUrbano cazador = new CazadorUrbano();
        cazador.setCantidadDeExperiencia(50);

        // Realizar el proceso de captura
        cazador.realizarProcesoDeCaptura(zona);

        // El cazador urbano solo puede capturar a no nerviosos
        // profugoNoNervioso y profugoAltaHabilidad no son nerviosos inicialmente
        assertTrue(cazador.getProfugosCapturados().contains(profugoNoNervioso));
        assertTrue(cazador.getProfugosCapturados().contains(profugoAltaHabilidad));
        assertEquals(2, cazador.getProfugosCapturados().size());

        // Los prófugos nerviosos deben haber sido intimidados (volverse false)
        assertFalse(profugoNervioso.esNervioso());
        assertFalse(profugoBajaHabilidad.esNervioso());
    }

    @Test
    void testCazadorSiguilosoCapturaYIntimida() {
        // Crear un cazador sigiloso con experiencia suficiente
        CazadorSigiloso cazador = new CazadorSigiloso();
        cazador.setCantidadDeExperiencia(50);

        // Realizar el proceso de captura
        cazador.realizarProcesoDeCaptura(zona);

        // El cazador sigiloso solo puede capturar a prófugos con habilidad < 50
        assertTrue(cazador.getProfugosCapturados().contains(profugoNervioso));
        assertTrue(cazador.getProfugosCapturados().contains(profugoNoNervioso));
        assertTrue(cazador.getProfugosCapturados().contains(profugoBajaHabilidad));
        assertEquals(3, cazador.getProfugosCapturados().size());

        // Los prófugos de alta habilidad deben ser intimidados
        assertEquals(75, profugoAltaHabilidad.getNivelHabilidad()); // 80 - 5 = 75
    }

    @Test
    void testProcesoDeCapturaSinExperienciaSuficiente() {
        // Crear un cazador rural sin experiencia suficiente
        CazadorRural cazador = new CazadorRural();
        cazador.setCantidadDeExperiencia(5); // Experiencia muy baja

        // Realizar el proceso de captura
        cazador.realizarProcesoDeCaptura(zona);

        // No debería capturar a nadie porque no tiene experiencia suficiente
        assertEquals(0, cazador.getProfugosCapturados().size());

        // Todos deberían ser intimidados
        assertTrue(profugoNoNervioso.esNervioso());
        assertTrue(profugoAltaHabilidad.esNervioso());
    }
}
