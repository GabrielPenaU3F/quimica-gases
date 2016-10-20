package ar.edu.untref.simuladordegases.implementacion;

/**
 * Created by synysterlove on 20/10/16.
 */
public class Energia {

    //Las medidas están en electron-volt
    private final double k_boltzmann = 8.617 * Math.pow(10, -5);
    private double energiaCinetica;

    /*Se calcula con la formula de la energia promedio de Maxwell-Boltzmann,
    pero en este momento esta representando la energia total de las particulas,
    ya que esta version del programa asume distribucion energetica uniforme.
     */
    public void calcularEnergiaCineticaTotal(double temperatura) {

        this.energiaCinetica = (3 * this.k_boltzmann * temperatura) / 2;

    }

    public double getEnergiaCinetica() {

        return this.energiaCinetica;

    }


    
}
