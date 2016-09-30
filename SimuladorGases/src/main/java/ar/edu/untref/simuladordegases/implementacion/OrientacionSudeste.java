package ar.edu.untref.simuladordegases.implementacion;

/**
 * Created by synysterlove on 29/09/16.
 */
public class OrientacionSudeste extends Orientacion {
    
    @Override
    public void mover(Particula particula) {

        particula.setXPosicion(this.calcularNuevaPosicionEnX(particula, particula.getVelocidad()));
        particula.setYPosicion(this.calcularNuevaPosicionEnY(particula, -particula.getVelocidad()));

    }
}
