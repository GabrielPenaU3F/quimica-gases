package ar.edu.untref.simuladordegases.implementacion;

/**
 * Created by synysterlove on 06/10/16.
 */
public class CalculadoraGasesIdeales {

    public double calcularPresion(int moles, double temperatura, int volumen){

        double constanteDeGases = 0.08205746;
        double presionResultante = (moles * constanteDeGases * temperatura / volumen);
        return presionResultante;

    }
    
}
