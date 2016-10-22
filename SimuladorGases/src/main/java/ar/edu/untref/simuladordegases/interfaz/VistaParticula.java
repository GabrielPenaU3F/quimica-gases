package ar.edu.untref.simuladordegases.interfaz;

import ar.edu.untref.simuladordegases.implementacion.Particula;

import java.awt.*;

/**
 * Created by synysterlove on 21/10/16.
 */
public class VistaParticula {

    private Particula particula;

    public VistaParticula(Particula particula) {

        this.particula = particula;

    }

    public void paint(Graphics2D g) {

        g.fillOval(this.particula.getXPosicion(), this.particula.getYPosicion(), this.particula.getAncho(), this.particula.getAlto());
        g.setColor(this.particula.getColor());

    }

    @Override
    public boolean equals (Object o) {

        VistaParticula otraVista = (VistaParticula) o;
        if (this.particula.equals(otraVista.particula)) return true;
        else return false;

    }

}
