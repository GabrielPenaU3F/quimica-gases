package ar.edu.untref.simuladordegases.interfaz;

import javax.swing.*;
import java.awt.*;

/**
 * Created by synysterlove on 06/11/16.
 */
public class LabelMoles extends JLabel {

    public LabelMoles(String contenido) {

        super();
        this.setText(contenido);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(new Font("Droid Sans", Font.BOLD, 14));
        this.setForeground(new Color(0, 128, 0));
        this.setName("EtiquetaMoles");

    }
    
}
