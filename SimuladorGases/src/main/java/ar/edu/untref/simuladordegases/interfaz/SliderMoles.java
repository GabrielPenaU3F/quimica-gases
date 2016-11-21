package ar.edu.untref.simuladordegases.interfaz;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by synysterlove on 06/11/16.
 */
public class SliderMoles extends JSlider {
    
    private int valor;
    
    public SliderMoles() {

        super();
        this.setMaximum(100);
        this.setValue(50);
        this.setMajorTickSpacing(10);
        this.setMinorTickSpacing(5);
        this.setPaintTicks(true);
        this.setPaintLabels(true);
        this.setName("SliderMoles");
        
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                JSlider source = (JSlider) e.getSource();
                valor = source.getValue();
            }
        });
        
    }
    
    public int getValor() {
        
        return this.valor;
        
    }
    
}
