package ar.edu.untref.simuladordegases;

import ar.edu.untref.simuladordegases.implementacion.Contenedor;
import ar.edu.untref.simuladordegases.implementacion.Particula;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by synysterlove on 23/09/16.
 */
public class ParticulaTest {

    @Test
    public void testCrearParticula() {

        Contenedor contenedor = new Contenedor();
        Particula particula = new Particula(contenedor,1,1,1);
        Assert.assertNotNull(particula);

    }

    @Test
    public void testQueLaParticulaSeCreeConAltoYAnchoDefault10() {

        Contenedor contenedor = new Contenedor();
        Particula particula = new Particula(contenedor,1,1,1);
        Assert.assertEquals(10, particula.getAncho());
        Assert.assertEquals(10, particula.getAlto());
    }

    @Test
    public void testQueLaParticulaSeCreeConVelocidadDefault1() {

        Contenedor contenedor = new Contenedor();
        Particula particula = new Particula(contenedor,1,1,1);
        Assert.assertEquals(1, particula.getVelocidad(), 0.0);

    }

    @Test
    public void testQueLaParticulaSeCreeConMovimientoEnXDefault1() {

        Contenedor contenedor = new Contenedor();
        Particula particula = new Particula(contenedor,1,1,1);
        Assert.assertEquals(1, particula.getMovimientoX(), 0.0);


    }

    @Test
    public void testQueLaParticulaSeCreeConMovimientoEnYDefault1() {

        Contenedor contenedor = new Contenedor();
        Particula particula = new Particula(contenedor,1,1,1);
        Assert.assertEquals(1, particula.getMovimientoY(), 0.0);

    }

    @Test
    public void testQueSeMueva1EnXSinChocar() {

        Contenedor contenedor = new Contenedor();
        contenedor.setAncho(200);
        contenedor.setAlto(200);
        Particula particula = new Particula(contenedor,1,1,1);
        particula.mover();
        Assert.assertEquals(1, particula.getXPosicion(), 0.0);

    }

    @Test
    public void testQueSeMueva1EnYSinChocar() {

        Contenedor contenedor = new Contenedor();
        contenedor.setAncho(200);
        contenedor.setAlto(200);
        Particula particula = new Particula(contenedor,1,1,1);
        particula.mover();
        Assert.assertEquals(1, particula.getYPosicion(), 0.0);

    }

    
}
