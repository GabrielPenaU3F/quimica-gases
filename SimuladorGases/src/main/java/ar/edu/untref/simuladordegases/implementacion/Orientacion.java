package ar.edu.untref.simuladordegases.implementacion;

/**
 * Created by synysterlove on 29/09/16.
 */
public abstract class Orientacion {

    public abstract void mover(Particula particula);

    protected int calcularNuevaPosicionEnY(Particula particula, double movimientoEnY) {

        double posicionFinalRegular = particula.getYPosicion() + movimientoEnY;
        if(posicionFinalRegular - particula.getAlto()/2 < 0) {

            double movimientoRestanteLuegoDelChoque = movimientoEnY - particula.getYPosicion();
            return (int) movimientoRestanteLuegoDelChoque;

        }
        if(posicionFinalRegular + particula.getAlto()/2 > particula.getContenedor().getAlto()) {

            double movimientoRestanteLuegoDelChoque = -(movimientoEnY - (particula.getContenedor().getAlto() - particula.getYPosicion()));
            return (int) movimientoRestanteLuegoDelChoque;

        }
        return (int) posicionFinalRegular;

    }

    protected int calcularNuevaPosicionEnX(Particula particula, double movimientoEnX) {

        double posicionFinalRegular = particula.getXPosicion() + movimientoEnX;
        if(posicionFinalRegular - particula.getAncho()/2 < 0) {

            double movimientoRestanteLuegoDelChoque = movimientoEnX - particula.getXPosicion();
            return (int) movimientoRestanteLuegoDelChoque;

        }
        if(posicionFinalRegular + particula.getAncho()/2 > particula.getContenedor().getAncho()) {

            double movimientoRestanteLuegoDelChoque = -(movimientoEnX - (particula.getContenedor().getAncho() - particula.getXPosicion()));
            return (int) movimientoRestanteLuegoDelChoque;

        }
        return (int) posicionFinalRegular;

    }
    
}
