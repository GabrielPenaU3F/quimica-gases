package ar.edu.untref.simuladordegases;

import ar.edu.untref.simuladordegases.implementacion.Agitador;
import ar.edu.untref.simuladordegases.implementacion.Contenedor;
import ar.edu.untref.simuladordegases.implementacion.Particula;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by synysterlove on 06/10/16.
 */
//TODO: CORREGIR URGENTE LOS NUMEROS DE LOS TEST PORQUE AHORA LA VELOCIDAD SE CALCULA DISTINTO
public class AgitadorTest {

    private Agitador agitador;
    private Contenedor contenedor;

    @Before
    public void inicializar() {

        this.agitador = new Agitador();
        this.contenedor = new Contenedor();
        this.contenedor.setAncho(200);
        this.contenedor.setAlto(200);

    }

    @Test
    public void testConCeroOnceLasParticulasSeVanNoroesteYSudesteSegunVelocidad() {

        Particula unaParticula = new Particula(this.contenedor);
        Particula otraParticula = new Particula(this.contenedor);
        unaParticula.setXPosicion(5);
        unaParticula.setYPosicion(5);
        otraParticula.setXPosicion(5);
        otraParticula.setYPosicion(5);

        this.agitador.chocarAleatoriamente(unaParticula, otraParticula, 0.11);
        List<Particula> particulas = new LinkedList<Particula>();
        particulas.add(unaParticula);
        particulas.add(otraParticula);
        this.agitador.moverParticulas(particulas);

        Assert.assertEquals(4, unaParticula.getXPosicion(), 0.0);
        Assert.assertEquals(6, unaParticula.getYPosicion(), 0.0);

        Assert.assertEquals(6, otraParticula.getXPosicion(), 0.0);
        Assert.assertEquals(4, otraParticula.getYPosicion(), 0.0);

    }

    @Test
    public void testConCeroTreintaYSieteLasParticulasSeVanSudesteYNoroesteSegunVelocidad() {

        Particula unaParticula = new Particula(this.contenedor);
        Particula otraParticula = new Particula(this.contenedor);
        unaParticula.setXPosicion(5);
        unaParticula.setYPosicion(5);
        otraParticula.setXPosicion(5);
        otraParticula.setYPosicion(5);

        this.agitador.chocarAleatoriamente(unaParticula, otraParticula, 0.37);
        List<Particula> particulas = new LinkedList<Particula>();
        particulas.add(unaParticula);
        particulas.add(otraParticula);
        this.agitador.moverParticulas(particulas);

        Assert.assertEquals(6, unaParticula.getXPosicion(), 0.0);
        Assert.assertEquals(4, unaParticula.getYPosicion(), 0.0);

        Assert.assertEquals(4, otraParticula.getXPosicion(), 0.0);
        Assert.assertEquals(6, otraParticula.getYPosicion(), 0.0);

    }


    @Test
    public void testConCeroSesentaYCuatroLasParticulasSeVanSudoesteYNoresteSegunVelocidad() {

        Particula unaParticula = new Particula(this.contenedor);
        Particula otraParticula = new Particula(this.contenedor);
        unaParticula.setXPosicion(5);
        unaParticula.setYPosicion(5);
        otraParticula.setXPosicion(5);
        otraParticula.setYPosicion(5);

        this.agitador.chocarAleatoriamente(unaParticula, otraParticula, 0.64);
        List<Particula> particulas = new LinkedList<Particula>();
        particulas.add(unaParticula);
        particulas.add(otraParticula);
        this.agitador.moverParticulas(particulas);

        Assert.assertEquals(4, unaParticula.getXPosicion(), 0.0);
        Assert.assertEquals(4, unaParticula.getYPosicion(), 0.0);

        Assert.assertEquals(6, otraParticula.getXPosicion(), 0.0);
        Assert.assertEquals(6, otraParticula.getYPosicion(), 0.0);

    }

    @Test
    public void testConCeroOchentaYNueveLasParticulasSeVanYNoresteYSudoesteSegunVelocidad() {

        Particula unaParticula = new Particula(this.contenedor);
        Particula otraParticula = new Particula(this.contenedor);
        unaParticula.setXPosicion(5);
        unaParticula.setYPosicion(5);
        otraParticula.setXPosicion(5);
        otraParticula.setYPosicion(5);

        this.agitador.chocarAleatoriamente(unaParticula, otraParticula, 0.89);
        List<Particula> particulas = new LinkedList<Particula>();
        particulas.add(unaParticula);
        particulas.add(otraParticula);
        this.agitador.moverParticulas(particulas);

        Assert.assertEquals(6, unaParticula.getXPosicion(), 0.0);
        Assert.assertEquals(6, unaParticula.getYPosicion(), 0.0);

        Assert.assertEquals(4, otraParticula.getXPosicion(), 0.0);
        Assert.assertEquals(4, otraParticula.getYPosicion(), 0.0);

    }

}
