package ar.edu.untref.simuladordegases.interfaz;

import javax.swing.*;
import java.awt.*;

/**
 * Created by synysterlove on 06/11/16.
 */
public class LabelPresion extends JLabel {


    public LabelPresion(String contenido) {

        super();
        this.setText(contenido);
        this.setForeground(new Color(128, 0, 128));
        this.setFont(new Font("Droid Sans", Font.BOLD, 20));
        this.setName("IndicadorDePresion");

    }
}
