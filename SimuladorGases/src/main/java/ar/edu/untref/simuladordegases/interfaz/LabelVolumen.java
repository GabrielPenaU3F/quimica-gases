package ar.edu.untref.simuladordegases.interfaz;

import javax.swing.*;
import java.awt.*;

/**
 * Created by synysterlove on 06/11/16.
 */
public class LabelVolumen extends JLabel {

    public LabelVolumen(String contenido) {

        super();
        this.setText(contenido);
        this.setFont(new Font("Droid Sans", Font.BOLD, 14));
        this.setForeground(Color.BLUE);
        this.setName("EtiquetaVolumen");
    }

}
