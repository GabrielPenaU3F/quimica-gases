package ar.edu.untref.simuladordegases.interfaz;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by synysterlove on 06/11/16.
 */
public class SliderVolumen extends JSlider{
    
    private double valor;
    
    public SliderVolumen() {

        super();
        this.setMinimum(30);
        this.setMaximum(100);
        this.setValue(70);
        this.setMajorTickSpacing(10);
        this.setMinorTickSpacing(5);
        this.setPaintTicks(true);
        this.setPaintLabels(true);
        this.setName("SliderVolumen");

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
