package ar.edu.untref.simuladordegases;

import ar.edu.untref.simuladordegases.implementacion.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by synysterlove on 23/09/16.
 */
public class ParticulaTest {

    private Particula particula;
    private Contenedor contenedor;



    @Before
    public void inicializar() {

        this.contenedor = new Contenedor();
        this.particula = new Particula(contenedor,1);

    }

    @Test
    public void testCrearParticula() {

        Assert.assertNotNull(this.particula);

    }

    @Test
    public void testQueLaParticulaSeCreeConPosicionDefaultCeroCero() {

        Assert.assertEquals(0, this.particula.getXPosicion(), 0.0);
        Assert.assertEquals(0, this.particula.getYPosicion(), 0.0);
    }

    @Test
    public void testQueLaParticulaSeCreeConAltoYAnchoDefault10() {

        Assert.assertEquals(10, this.particula.getAncho());
        Assert.assertEquals(10, this.particula.getAlto());
    }

    @Test
    public void testQueLaParticulaSeCreeConVelocidadDefault1() {

        Assert.assertEquals(1, this.particula.getVelocidad(), 0.0);

    }

    /*
        TESTS DEL MOVIMIENTO CON VELOCIDAD 1
     */
    @Test
    public void testQueSeMueva1AlNoresteSinChocar() {

        this.contenedor.setAncho(200);
        this.contenedor.setAlto(200);
        this.particula.setOrientacion(new OrientacionNoreste());
        this.particula.mover();
        Assert.assertEquals(1, this.particula.getXPosicion(), 0.0);
        Assert.assertEquals(1, this.particula.getYPosicion(), 0.0);

    }

    @Test
    public void testQueSeMueva1AlNoroesteSinChocar() {

        this.contenedor.setAncho(200);
        this.contenedor.setAlto(200);
        this.particula.setXPosicion(2);
        this.particula.setOrientacion(new OrientacionNoroeste());
        this.particula.mover();
        Assert.assertEquals(1, this.particula.getXPosicion(), 0.0);
        Assert.assertEquals(1, this.particula.getYPosicion(), 0.0);

    }


    @Test
    public void testQueSeMueva1AlSudesteSinChocar() {

        this.contenedor.setAncho(200);
        this.contenedor.setAlto(200);
        this.particula.setYPosicion(2);
        this.particula.setOrientacion(new OrientacionSudeste());
        this.particula.mover();
        Assert.assertEquals(1, particula.getXPosicion(), 0.0);
        Assert.assertEquals(1, particula.getYPosicion(), 0.0);

    }

    @Test
    public void testQueSeMueva1AlSudoesteSinChocar() {

        this.contenedor.setAncho(200);
        this.contenedor.setAlto(200);
        this.particula.setXPosicion(2);
        this.particula.setYPosicion(2);
        this.particula.setOrientacion(new OrientacionSudoeste());
        this.particula.mover();
        Assert.assertEquals(1, particula.getXPosicion(), 0.0);
        Assert.assertEquals(1, particula.getYPosicion(), 0.0);

    }


       // TESTS DEL MOVIMIENTO CON VELOCIDAD 5


    @Test
    public void testQueSeMueva5AlNoresteSinChocar() {

        this.particula.setVelocidad(5);
        this.contenedor.setAncho(200);
        this.contenedor.setAlto(200);
        this.particula.setOrientacion(new OrientacionNoreste());
        this.particula.mover();
        Assert.assertEquals(5, this.particula.getXPosicion(), 0.0);
        Assert.assertEquals(5, this.particula.getYPosicion(), 0.0);

    }

    @Test
    public void testQueSeMueva5AlNoroesteSinChocar() {

        this.particula.setVelocidad(5);
        this.contenedor.setAncho(200);
        this.contenedor.setAlto(200);
        this.particula.setXPosicion(6);
        this.particula.setOrientacion(new OrientacionNoroeste());
        this.particula.mover();
        Assert.assertEquals(1, this.particula.getXPosicion(), 0.0);
        Assert.assertEquals(5, this.particula.getYPosicion(), 0.0);

    }

    @Test
    public void testQueSeMueva5AlSudesteSinChocar() {

        this.particula.setVelocidad(5);
        this.contenedor.setAncho(200);
        this.contenedor.setAlto(200);
        this.particula.setYPosicion(6);
        this.particula.setOrientacion(new OrientacionSudeste());
        this.particula.mover();
        Assert.assertEquals(5, particula.getXPosicion(), 0.0);
        Assert.assertEquals(1, particula.getYPosicion(), 0.0);

    }

    @Test
    public void testQueSeMueva5AlSudoesteSinChocar() {

        this.particula.setVelocidad(5);
        this.contenedor.setAncho(200);
        this.contenedor.setAlto(200);
        this.particula.setXPosicion(6);
        this.particula.setYPosicion(6);
        this.particula.setOrientacion(new OrientacionSudoeste());
        this.particula.mover();
        Assert.assertEquals(1, particula.getXPosicion(), 0.0);
        Assert.assertEquals(1, particula.getYPosicion(), 0.0);

    }

    /*
    //TESTS DEL MOVIMIENTO ALEATORIO

    @Test
    public void testQueSeMueva5AlNoroesteConAleatorioCeroTrece() {

        this.particula.setVelocidad(5);
        this.particula.setXPosicion(6);
        this.particula.moverAleatoriamente(0.13);
        Assert.assertEquals(1, particula.getXPosicion(), 0.0);
        Assert.assertEquals(5, particula.getYPosicion(), 0.0);

    }

    @Test
    public void testQueSeMueva5AlNoresteConAleatorioCeroCuarenta() {

        this.particula.setVelocidad(5);
        this.particula.moverAleatoriamente(0.40);
        Assert.assertEquals(5, particula.getXPosicion(), 0.0);
        Assert.assertEquals(5, particula.getYPosicion(), 0.0);

    }

    @Test
    public void testQueSeMueva5AlSudoesteConAleatorioCeroSesenta() {

        this.particula.setVelocidad(5);
        this.particula.setXPosicion(6);
        this.particula.setYPosicion(6);
        this.particula.moverAleatoriamente(0.60);
        Assert.assertEquals(1, particula.getXPosicion(), 0.0);
        Assert.assertEquals(1, particula.getYPosicion(), 0.0);

    }

    @Test
    public void testQueSeMueva5AlSudesteConAleatorioCeroNoventa() {

        this.particula.setVelocidad(5);
        this.particula.setYPosicion(6);
        this.particula.moverAleatoriamente(0.90);
        Assert.assertEquals(5, particula.getXPosicion(), 0.0);
        Assert.assertEquals(1, particula.getYPosicion(), 0.0);

    }*/

}