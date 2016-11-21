package ar.edu.untref.simuladordegases.interfaz;

import ar.edu.untref.simuladordegases.implementacion.Contenedor;
import ar.edu.untref.simuladordegases.implementacion.Particula;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

/**
 * Created by synysterlove on 21/10/16.
 */
public class VistaContenedor extends JPanel {

    private Contenedor contenedor;

    public VistaContenedor(Contenedor contenedor) {

        super();
        this.contenedor = contenedor;

        this.setBackground(Color.WHITE);
        this.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        this.setName("ContenedorParticulas");

    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for(Particula particula : this.contenedor.getParticulas()){

            particula.getVista().paint(g2d);

        }
    }


    public Contenedor getContenedor() {

        return this.contenedor;

    }

    @Override
    public boolean equals (Object o) {

        VistaContenedor otraVista = (VistaContenedor) o;
        if (this.contenedor.equals(otraVista.contenedor)) return true;
        else return false;

    }

}
