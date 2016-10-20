package ar.edu.untref.simuladordegases;

import ar.edu.untref.simuladordegases.implementacion.Energia;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by synysterlove on 20/10/16.
 */
public class EnergiaTest {

    @Test
    public void testQueCalculeLaEnergiaCorrectaPara300K() {

        Energia energia = new Energia();
        energia.calcularEnergiaCineticaTotal(300);
        Assert.assertEquals(0.0387765, energia.getEnergiaCinetica(), 0.001);

    }

    @Test
    public void testQueCalculeLaEnergiaCorrectaPara600K() {

        Energia energia = new Energia();
        energia.calcularEnergiaCineticaTotal(600);
        Assert.assertEquals(0.077553, energia.getEnergiaCinetica(), 0.001);

    }

    
}
