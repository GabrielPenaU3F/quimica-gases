package ar.edu.untref.simuladordegases;

import ar.edu.untref.simuladordegases.implementacion.CalculadoraGasesIdeales;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by synysterlove on 06/10/16.
 */
public class CalculadoraGasesIdealesTest {

    private static CalculadoraGasesIdeales calculadora;

    @BeforeClass
    public static void inicializarCalculadora() {

        calculadora = new CalculadoraGasesIdeales();

    }

    @Test
    public void testQueCalculeBienLaPresionCon50Litros25MolesY300Kelvin() {

       double presion = calculadora.calcularPresion(25,300,50);
       Assert.assertEquals(12.308, presion, 0.005);

    }

    @Test
    public void testQueCalculeBienLaPresionCon100Litros100MolesY1000Kelvin() {

        double presion = calculadora.calcularPresion(100, 1000, 100);
        Assert.assertEquals(82.057, presion, 0.005);

    }
    
}
