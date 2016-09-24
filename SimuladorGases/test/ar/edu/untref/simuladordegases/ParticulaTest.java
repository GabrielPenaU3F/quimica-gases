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
    
}
