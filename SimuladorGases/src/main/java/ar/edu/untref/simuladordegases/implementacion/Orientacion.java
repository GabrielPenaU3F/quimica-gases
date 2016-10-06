package ar.edu.untref.simuladordegases.implementacion;

import static java.lang.Math.abs;

/**
 * Created by synysterlove on 29/09/16.
 */
public abstract class Orientacion {

    public abstract void mover(Particula particula);

    protected int calcularNuevaPosicionEnY(Particula particula, double movimientoEnY) {

        double posicionFinalRegular = particula.getYPosicion() + movimientoEnY;
        if(posicionFinalRegular < particula.getContenedor().getOrigenY()) {

            double movimientoRestanteLuegoDelChoque = abs(movimientoEnY) - abs(particula.getYPosicion());
            return (int) movimientoRestanteLuegoDelChoque;

        }
        if(posicionFinalRegular > particula.getContenedor().getAlto()) {

            double movimientoRestanteLuegoDelChoque = abs(movimientoEnY) - abs(particula.getContenedor().getAlto() - particula.getYPosicion());
            return (int) ((int) particula.getContenedor().getAlto() - movimientoRestanteLuegoDelChoque);

        }
        return (int) posicionFinalRegular;

    }

    protected int calcularNuevaPosicionEnX(Particula particula, double movimientoEnX) {

        double posicionFinalRegular = particula.getXPosicion() + movimientoEnX;
        if(posicionFinalRegular < particula.getContenedor().getOrigenX()) {

            double movimientoRestanteLuegoDelChoque = abs(movimientoEnX) - abs(particula.getXPosicion());
            return (int) movimientoRestanteLuegoDelChoque;

        }
        if(posicionFinalRegular > particula.getContenedor().getAncho()) {

            double movimientoRestanteLuegoDelChoque = abs(movimientoEnX) - abs(particula.getContenedor().getAncho() - particula.getXPosicion());
            return (int) ((int) particula.getContenedor().getAncho() - movimientoRestanteLuegoDelChoque);

        }
        return (int) posicionFinalRegular;

    }
    
}
