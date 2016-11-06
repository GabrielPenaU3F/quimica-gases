package ar.edu.untref.simuladordegases.implementacion;

/**
 * Created by synysterlove on 29/09/16.
 */
public class OrientacionSudoeste extends Orientacion {
    
    @Override
    public void mover(Particula particula) {

        /*La velocidad en Y se pasa positiva porque
    la coordenada Y debe aumentar para ir al sur.
    La velocidad en X se pasa negativa porque
    la coordenada X debe disminuir para ir al oeste.
     */

        particula.setXPosicion(this.calcularNuevaPosicionEnX(particula, -particula.getVelocidad()));
        particula.setYPosicion(this.calcularNuevaPosicionEnY(particula, particula.getVelocidad()));

    }
}
