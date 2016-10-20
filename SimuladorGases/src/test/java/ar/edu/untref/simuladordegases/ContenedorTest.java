package ar.edu.untref.simuladordegases;

import ar.edu.untref.simuladordegases.implementacion.Contenedor;
import ar.edu.untref.simuladordegases.implementacion.Particula;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

/**
 * Created by synysterlove on 20/10/16.
 */
public class ContenedorTest {

    private Contenedor contenedor;

    @Before
    public void crearContenedorConParticulas() {

        this.contenedor = new Contenedor();
        for(int i=0; i < 20; i++) {

            Particula particula = new Particula(contenedor, 1);
            contenedor.agregarParticula(particula);

        }

    }

    @Test
    public void testQueModifiqueCorrectamenteLaTemperaturaDelContenedorAlCambiarla() {

        this.contenedor.modificarTemperaturaDeParticulas(100);
        Assert.assertEquals(100, this.contenedor.getTemperatura(), 0.0);

    }

    @Test
    public void testQueModifiqueCorrectamenteLaVelocidadDeLasParticulasAlCambiarLaTemperaturaDelContenedor() {

        this.contenedor.modificarTemperaturaDeParticulas(100);
        for(Particula particula: this.contenedor.getParticulas()) {

            Assert.assertEquals(1, particula.getVelocidad(), 0.0);

        }
    }

    @Test
    public void testQueModifiqueCorrectamenteElColorDeLasParticulasAlCambiarLaTemperaturaDelContenedor() {

        this.contenedor.modificarTemperaturaDeParticulas(100);
        Color color = new Color(255,255,0);
        for(Particula particula: this.contenedor.getParticulas()) {

            Assert.assertEquals(color, particula.getColor());

        }
    }
    
}
