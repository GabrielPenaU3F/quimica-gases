package ar.edu.untref.simuladordegases.interfaz;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by synysterlove on 06/11/16.
 */
public class SliderTemperatura extends JSlider {

    private double valor;

    public SliderTemperatura() {

        super();
        this.setMaximum(600);
        this.setMinimum(100);
        this.setValue(300);
        this.setMajorTickSpacing(100);
        this.setMinorTickSpacing(50);
        this.setPaintTicks(true);
        this.setPaintLabels(true);
        this.setName("SliderTemperatura");

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                JSlider source = (JSlider) e.getSource();
                valor = source.getValue();
            }
        });

    }

    public double getValor() {

        return this.valor;

    }

}
