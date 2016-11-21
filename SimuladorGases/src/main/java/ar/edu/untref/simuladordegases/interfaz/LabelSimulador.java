package ar.edu.untref.simuladordegases.interfaz;

import javax.swing.*;
import java.awt.*;

/**
 * Created by synysterlove on 06/11/16.
 */
public class LabelSimulador extends JLabel{

    public LabelSimulador(String contenido) {

        super();
        this.setText(contenido);
        this.setForeground(SystemColor.desktop);
        this.setFont(new Font("Droid Sans", Font.BOLD, 40));
        this.setName("EtiquetaSimulador");

    }
}
