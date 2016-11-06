package ar.edu.untref.simuladordegases.implementacion;

/**
 * Created by synysterlove on 29/09/16.
 */
public class OrientacionNoreste extends Orientacion {

    /*La velocidad en Y se pasa negativa porque
    la coordenada Y debe disminuir para ir al norte.
    La velocidad en X se pasa positiva porque la
    coordenada X debe aumentar para ir al este.
    */

    @Override
    public void mover(Particula particula) {

        particula.setXPosicion(this.calcularNuevaPosicionEnX(particula, particula.getVelocidad()));
        particula.setYPosicion(this.calcularNuevaPosicionEnY(particula, -particula.getVelocidad()));

    }
}
