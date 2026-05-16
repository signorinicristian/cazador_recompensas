package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.profugos.ArtesMarcialesAvanzadas;
import ar.edu.unahur.obj2.profugos.EntrenamientoElite;
import ar.edu.unahur.obj2.profugos.ProteccionLegal;
import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.profugos.IProfugo;

public class Part2Test {

    @Test
    void artesMarcialesDuplicaHabilidadYCap() {
        IProfugo base = new Profugo(50, 60, false);
        ArtesMarcialesAvanzadas decor = new ArtesMarcialesAvanzadas(base);

        assertEquals(100, decor.getHabilidad()); // 60*2 -> capped to 100

        IProfugo base2 = new Profugo(50, 30, false);
        ArtesMarcialesAvanzadas decor2 = new ArtesMarcialesAvanzadas(base2);
        assertEquals(60, decor2.getHabilidad()); // 30*2 = 60
    }

    @Test
    void entrenamientoEliteNuncaNervioso() {
        IProfugo base = new Profugo(20, 40, true);
        EntrenamientoElite elite = new EntrenamientoElite(base);

        assertFalse(elite.esNervioso());
        elite.volverseNervioso();
        assertFalse(elite.esNervioso());
        elite.dejarDeEstarNervioso();
        assertFalse(elite.esNervioso());
    }

    @Test
    void proteccionLegalMantieneInocenciaMinimaYBloqueaReduccion() {
        IProfugo low = new Profugo(35, 50, false);
        ProteccionLegal plLow = new ProteccionLegal(low);
        assertEquals(40, plLow.getInocencia()); // vista decorada muestra mínimo 40

        IProfugo high = new Profugo(42, 50, false);
        ProteccionLegal plHigh = new ProteccionLegal(high);
        // disminuir dos veces should reach 40 but not below
        plHigh.disminuirInocencia(); // 42 -> 41
        assertEquals(41, plHigh.getInocencia());
        plHigh.disminuirInocencia(); // 41 -> 40
        assertEquals(40, plHigh.getInocencia());
        plHigh.disminuirInocencia(); // should not go below 40
        assertEquals(40, plHigh.getInocencia());
    }

    @Test
    void decoradoresCombinadosFuncionanBien() {
        IProfugo base = new Profugo(30, 40, true);
        // Proteccion legal -> evita inocencia < 40
        IProfugo pl = new ProteccionLegal(base);
        // Elite -> nunca nervioso
        IProfugo elite = new EntrenamientoElite(pl);
        // Artes marciales -> duplica habilidad
        IProfugo artes = new ArtesMarcialesAvanzadas(elite);

        assertEquals(40, pl.getInocencia());
        assertFalse(elite.esNervioso());
        assertEquals(80, artes.getHabilidad());

        // probar reducir habilidad a través del decorador de artes
        IProfugo baseH = new Profugo(20, 30, false);
        ArtesMarcialesAvanzadas artes2 = new ArtesMarcialesAvanzadas(baseH);
        assertEquals(60, artes2.getHabilidad());
        artes2.reducirHabilidad(); // underlying 30 -> 25
        assertEquals(50, artes2.getHabilidad()); // 25*2 = 50
    }
}
