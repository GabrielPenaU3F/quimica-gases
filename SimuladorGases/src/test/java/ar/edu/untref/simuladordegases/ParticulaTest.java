package ar.edu.untref.simuladordegases;

import ar.edu.untref.simuladordegases.implementacion.*;
import ar.edu.untref.simuladordegases.interfaz.VistaParticula;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

/**
 * Created by synysterlove on 23/09/16.
 */
public class ParticulaTest {

    /*La posicion de la particula en el contenedor es:
    El origen, (0,0), esta en la esquina superior izquierda
    X aumenta hacia la derecha
    Y aumenta hacia abajo
     */

    private Particula particula;
    private Contenedor contenedor;



    @Before
    public void inicializar() {

        this.contenedor = new Contenedor();
        this.particula = new Particula(contenedor);
        this.contenedor.setAncho(200);
        this.contenedor.setAlto(200);

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
    public void testQueLaParticulaSeCreeConVelocidadDefault1A300Kelvin() {

        Assert.assertEquals(1, this.particula.getVelocidad(), 0.0);

    }

    @Test
    public void testQueLaParticulaSeCreeConColorDefaultNaranjaA300Kelvin() {

        Color color = new Color(255, 255 - (255*200/500), 0);
        Assert.assertEquals(color, this.particula.getColor());

    }

    @Test
    public void testQueLaParticulaSeCreeConUnaVistaPorDefault() {

        VistaParticula vista = new VistaParticula(this.particula);
        Assert.assertEquals(vista, this.particula.getVista());

    }

    @Test
    public void testQueLaParticulaSeCreeConOrientacionDefaultSudeste() {

        Orientacion orientacionSudeste = new OrientacionSudeste();
        Assert.assertEquals(orientacionSudeste, this.particula.getOrientacion());

    }

    /*
        TESTS DEL MOVIMIENTO CON VELOCIDAD 1
     */
    @Test
    public void testQueSeMueva1AlNoresteSinChocar() {

        this.particula.setOrientacion(new OrientacionNoreste());
        this.particula.setYPosicion(2);
        this.particula.mover();
        Assert.assertEquals(1, this.particula.getXPosicion(), 0.0);
        Assert.assertEquals(1, this.particula.getYPosicion(), 0.0);

    }


    @Test
    public void testQueSeMueva1AlNoroesteSinChocar() {

        this.particula.setXPosicion(2);
        this.particula.setYPosicion(2);
        this.particula.setOrientacion(new OrientacionNoroeste());
        this.particula.mover();
        Assert.assertEquals(1, this.particula.getXPosicion(), 0.0);
        Assert.assertEquals(1, this.particula.getYPosicion(), 0.0);

    }


    @Test
    public void testQueSeMueva1AlSudesteSinChocar() {

        this.particula.setOrientacion(new OrientacionSudeste());
        this.particula.mover();
        Assert.assertEquals(1, this.particula.getXPosicion(), 0.0);
        Assert.assertEquals(1, this.particula.getYPosicion(), 0.0);

    }


    @Test
    public void testQueSeMueva1AlSudoesteSinChocar() {

        this.particula.setXPosicion(2);
        this.particula.setOrientacion(new OrientacionSudoeste());
        this.particula.mover();
        Assert.assertEquals(1, this.particula.getXPosicion(), 0.0);
        Assert.assertEquals(1, this.particula.getYPosicion(), 0.0);

    }


       // TESTS DEL MOVIMIENTO CON VELOCIDAD 5



    @Test
    public void testQueSeMueva5AlNoresteSinChocar() {

        this.particula.setVelocidad(5);
        this.particula.setOrientacion(new OrientacionNoreste());
        this.particula.setYPosicion(6);
        this.particula.mover();
        Assert.assertEquals(5, this.particula.getXPosicion(), 0.0);
        Assert.assertEquals(1, this.particula.getYPosicion(), 0.0);

    }


    @Test
    public void testQueSeMueva5AlNoroesteSinChocar() {

        this.particula.setVelocidad(5);
        this.particula.setXPosicion(6);
        this.particula.setYPosicion(6);
        this.particula.setOrientacion(new OrientacionNoroeste());
        this.particula.mover();
        Assert.assertEquals(1, this.particula.getXPosicion(), 0.0);
        Assert.assertEquals(1, this.particula.getYPosicion(), 0.0);

    }

    @Test
    public void testQueSeMueva5AlSudesteSinChocar() {

        this.particula.setVelocidad(5);
        this.particula.setOrientacion(new OrientacionSudeste());
        this.particula.mover();
        Assert.assertEquals(5, particula.getXPosicion(), 0.0);
        Assert.assertEquals(5, particula.getYPosicion(), 0.0);

    }

    @Test
    public void testQueSeMueva5AlSudoesteSinChocar() {

        this.particula.setVelocidad(5);
        this.particula.setXPosicion(6);
        this.particula.setOrientacion(new OrientacionSudoeste());
        this.particula.mover();
        Assert.assertEquals(1, particula.getXPosicion(), 0.0);
        Assert.assertEquals(5, particula.getYPosicion(), 0.0);

    }

    /* TESTS DE COLISIONES CONTRA LAS PAREDES */



    @Test
    public void testQueChoqueYReboteDelNoroesteAlSudesteDesde0() {

        this.particula.setVelocidad(5);
        this.particula.setOrientacion(new OrientacionNoroeste());
        this.particula.mover();
        Assert.assertEquals(5, particula.getXPosicion(), 0.0);
        Assert.assertEquals(5, particula.getYPosicion(), 0.0);

    }

    @Test
    public void testQueDesdeCincoCincoChoqueYReboteDelNoroesteAlSudesteHastaDosDos() {

        this.particula.setVelocidad(7);
        this.particula.setXPosicion(5);
        this.particula.setYPosicion(5);
        this.particula.setOrientacion(new OrientacionNoroeste());
        this.particula.mover();
        Assert.assertEquals(2, particula.getXPosicion(), 0.0);
        Assert.assertEquals(2, particula.getYPosicion(), 0.0);

    }

    @Test
    public void testQueDesdeCientoOchentaYCientoOchentaChoqueYReboteDelSudesteAlNoroesteHastaElMismoPunto() {

        this.particula.setVelocidad(40);
        this.particula.setXPosicion(180);
        this.particula.setYPosicion(180);
        this.particula.setOrientacion(new OrientacionSudeste());
        this.particula.mover();
        Assert.assertEquals(180, particula.getXPosicion(), 0.0);
        Assert.assertEquals(180, particula.getYPosicion(), 0.0);

    }

}
