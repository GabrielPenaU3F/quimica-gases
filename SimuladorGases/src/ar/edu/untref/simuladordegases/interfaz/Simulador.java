package ar.edu.untref.simuladordegases.interfaz;

import ar.edu.untref.simuladordegases.implementacion.Contenedor;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.DecimalFormat;

public class Simulador extends JFrame {
		
	/**
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;
	private String presion = "12.300";
	private Integer moles = 25;
	private Float temperatura = (float) 300;
	private Integer volumen = 50;	
	private Color colorDePresion;
	
	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */

    //El objeto simulador es el frame principal
    public void comenzarSimulacion() throws InterruptedException {

        Simulador simulador = this; //Para hacerlo mas visible
        construirLayout(simulador);
        SpringLayout springLayout = (SpringLayout)simulador.getContentPane().getLayout();


        construirComponentesVisuales(simulador, springLayout);
    }

    private void construirComponentesVisuales(Simulador simulador, SpringLayout springLayout) throws InterruptedException {

        JComponent contenedor = construirContenedorDeParticulas(simulador, springLayout); //Nombre: ContenedorParticulas

        construirEtiquetaSimuladorDeGases(simulador, springLayout); //Nombre: EtiquetaSimulador

        construirEtiquetaPresionResultante(simulador, springLayout); //Nombre: EtiquetaPresionResultante

        JComponent indicadorPresion = construirIndicadorDePresion(simulador, springLayout); //Nombre: IndicadorDePresion

        construirEtiquetaMoles(simulador, springLayout); //Nombre: EtiquetaMoles

        construirSliderMoles(simulador, springLayout); //Nombre: SliderMoles

        JComponent lblTemperatura = construirEtiquetaTemperatura(simulador, springLayout); //Nombre: EtiquetaTemperatura

        construirSliderTemperatura(simulador, springLayout); //Nombre: SliderTemperatura

        construirEtiquetaVolumen(simulador, springLayout); //Nombre: EtiquetaVolumen

        JComponent sliderVolumen = construirSliderVolumen(simulador, springLayout); //Nombre: SliderVolumen

        construirBotonActualizar(simulador, springLayout, contenedor, indicadorPresion, lblTemperatura, sliderVolumen); //Nombre: BotonActualizar
    }

    private void construirBotonActualizar(Simulador simulador, SpringLayout springLayout, JComponent contenedor, JComponent indicadorPresion, JComponent lblTemperatura, JComponent sliderVolumen) throws InterruptedException {

        JButton btnActualizar = new JButton("Actualizar");

        imponerRestriccionesParaElTamanioDelContenedor(simulador, springLayout, btnActualizar, sliderVolumen, lblTemperatura);

        colocarListener(simulador, springLayout, contenedor, indicadorPresion, btnActualizar);

        btnActualizar.setFont(new Font("Droid Sans", Font.BOLD, 16));
        btnActualizar.setName("BotonActualizar");
        simulador.getContentPane().add(btnActualizar);

		/*
		 * Primero genera todo el contenido y luego lo hace visible
		 * NOTA: Si esta sentencia esta al principio del main NO SE MUESTRA NADA
		 * NOTA2: Si esta sentencia esta al final del main, el simulador nunca se hace visible porque precipitar() es infinito
		 */
        simulador.setVisible(true);
        ((Contenedor) contenedor).precipitar();
    }

    private void colocarListener(final Simulador simulador, final SpringLayout springLayout, final JComponent contenedor, final JComponent indicadorPresion, JButton btnActualizar) {

        btnActualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                simulador.actualizar();
                //Modificación de la temperatura del gas
                ((Contenedor)contenedor).modificarTemperaturaDeParticulas(simulador.getTemperatura());
                //Modificación de la cantidad de moles de gas
                ((Contenedor)contenedor).modificarCantidadDeMoles(simulador.getMoles());
                //Modificación del volumen del recipiente
                Integer nuevoBordeSur = (int) (550 * (simulador.getVolumen()/100.0));
                Integer nuevoBordeEste = (int) (450 * (simulador.getVolumen()/100.0));
                ((Contenedor)contenedor).setAncho(nuevoBordeEste - 70);
                ((Contenedor)contenedor).setAlto(nuevoBordeSur - 100);
                springLayout.putConstraint(SpringLayout.SOUTH, contenedor, nuevoBordeSur, SpringLayout.NORTH, simulador.getContentPane());
                springLayout.putConstraint(SpringLayout.EAST, contenedor, nuevoBordeEste, SpringLayout.WEST, simulador.getContentPane());
                //Modificación de la etiqueta de presion
                ((JLabel)indicadorPresion).setText(simulador.getPresion() + " atm.");
                indicadorPresion.setForeground(simulador.getColorDePresion());

            }
        });
    }

    private void imponerRestriccionesParaElTamanioDelContenedor(Simulador simulador, SpringLayout springLayout, JButton btnActualizar, JComponent sliderVolumen, JComponent lblTemperatura) {

        springLayout.putConstraint(SpringLayout.NORTH, btnActualizar, 42, SpringLayout.SOUTH, sliderVolumen);
        springLayout.putConstraint(SpringLayout.WEST, btnActualizar, 0, SpringLayout.WEST, lblTemperatura);
        springLayout.putConstraint(SpringLayout.SOUTH, btnActualizar, 550, SpringLayout.NORTH, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, btnActualizar, 131, SpringLayout.WEST, lblTemperatura);
    }

    private JComponent buscarComponentePorNombre(Simulador simulador, String nombre) {

        Component componentes[] = simulador.getContentPane().getComponents();

        for(int i=0; i<componentes.length; i++) {

            if(componentes[i].getName().equals("nombre")) {

                JComponent componente = (JComponent) componentes[i];
                return componente;

            }

        }
        return null;

    }

    private JSlider construirSliderVolumen(Simulador simulador, SpringLayout springLayout) {

        JSlider sliderVolumen = new JSlider();
        springLayout.putConstraint(SpringLayout.NORTH, sliderVolumen, 424, SpringLayout.NORTH, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, sliderVolumen, 553, SpringLayout.WEST, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, sliderVolumen, 868, SpringLayout.WEST, simulador.getContentPane());
        sliderVolumen.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                JSlider source = (JSlider) e.getSource();
                simulador.setVolumen((int) source.getValue());
            }
        });
        sliderVolumen.setMinimum(30);
        sliderVolumen.setMaximum(100);
        sliderVolumen.setValue(100);
        sliderVolumen.setMajorTickSpacing(10);
        sliderVolumen.setMinorTickSpacing(5);
        sliderVolumen.setPaintTicks(true);
        sliderVolumen.setPaintLabels(true);
        sliderVolumen.setName("SliderVolumen");
        simulador.getContentPane().add(sliderVolumen);
        return sliderVolumen;
    }

    private void construirEtiquetaVolumen(Simulador simulador, SpringLayout springLayout) {

        JLabel lblVolumen = new JLabel("Volumen (l)");
        springLayout.putConstraint(SpringLayout.NORTH, lblVolumen, 402, SpringLayout.NORTH, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, lblVolumen, 670, SpringLayout.WEST, simulador.getContentPane());
        lblVolumen.setFont(new Font("Droid Sans", Font.BOLD, 14));
        lblVolumen.setForeground(Color.BLUE);
        lblVolumen.setName("EtiquetaVolumen");
        simulador.getContentPane().add(lblVolumen);
    }

    private void construirSliderTemperatura(Simulador simulador, SpringLayout springLayout) {

        JSlider sliderTemperatura = new JSlider();
        springLayout.putConstraint(SpringLayout.NORTH, sliderTemperatura, 312, SpringLayout.NORTH, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, sliderTemperatura, 553, SpringLayout.WEST, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, sliderTemperatura, 868, SpringLayout.WEST, simulador.getContentPane());

        sliderTemperatura.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                JSlider source = (JSlider) e.getSource();
                simulador.setTemperatura((float) source.getValue());
            }
        });
        sliderTemperatura.setMaximum(600);
        sliderTemperatura.setMinimum(100);
        sliderTemperatura.setValue(350);
        sliderTemperatura.setMajorTickSpacing(100);
        sliderTemperatura.setMinorTickSpacing(50);
        sliderTemperatura.setPaintTicks(true);
        sliderTemperatura.setPaintLabels(true);
        sliderTemperatura.setName("SliderTemperatura");
        simulador.getContentPane().add(sliderTemperatura);
    }

    private JLabel construirEtiquetaTemperatura(Simulador simulador, SpringLayout springLayout) {

        JLabel lblTemperatura = new JLabel("Temperatura (K)");
        springLayout.putConstraint(SpringLayout.NORTH, lblTemperatura, 290, SpringLayout.NORTH, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, lblTemperatura, 653, SpringLayout.WEST, simulador.getContentPane());
        lblTemperatura.setFont(new Font("Droid Sans", Font.BOLD, 14));
        lblTemperatura.setForeground(Color.RED);
        lblTemperatura.setName("EtiquetaTemperatura");
        simulador.getContentPane().add(lblTemperatura);
        return lblTemperatura;

    }

    private void construirSliderMoles(Simulador simulador, SpringLayout springLayout) {

        JSlider sliderMoles = new JSlider();
        springLayout.putConstraint(SpringLayout.NORTH, sliderMoles, 189, SpringLayout.NORTH, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, sliderMoles, 553, SpringLayout.WEST, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, sliderMoles, 868, SpringLayout.WEST, simulador.getContentPane());
        sliderMoles.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                JSlider source = (JSlider) e.getSource();
                simulador.setMoles(source.getValue());
            }
        });
        sliderMoles.setMaximum(100);
        sliderMoles.setValue(50);
        sliderMoles.setMajorTickSpacing(10);
        sliderMoles.setMinorTickSpacing(5);
        sliderMoles.setPaintTicks(true);
        sliderMoles.setPaintLabels(true);
        sliderMoles.setName("SliderMoles");
        simulador.getContentPane().add(sliderMoles);
    }

    private void construirEtiquetaMoles(Simulador simulador, SpringLayout springLayout) {

        JLabel lblMoles = new JLabel("Moles");
        springLayout.putConstraint(SpringLayout.NORTH, lblMoles, 167, SpringLayout.NORTH, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, lblMoles, 690, SpringLayout.WEST, simulador.getContentPane());
        lblMoles.setHorizontalAlignment(SwingConstants.CENTER);
        lblMoles.setFont(new Font("Droid Sans", Font.BOLD, 14));
        lblMoles.setForeground(new Color(0, 128, 0));
        lblMoles.setName("EtiquetaMoles");
        simulador.getContentPane().add(lblMoles);
    }
    
    private JLabel construirIndicadorDePresion(Simulador simulador, SpringLayout springLayout) {
        
        JLabel indicadorPresion = new JLabel(simulador.presion + " atm.");
        springLayout.putConstraint(SpringLayout.NORTH, indicadorPresion, 85, SpringLayout.NORTH, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, indicadorPresion, 667, SpringLayout.WEST, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, indicadorPresion, 118, SpringLayout.NORTH, simulador.getContentPane());
        indicadorPresion.setForeground(new Color(128, 0, 128));
        indicadorPresion.setFont(new Font("Droid Sans", Font.BOLD, 20));
        indicadorPresion.setName("IndicadorDePresion");
        simulador.getContentPane().add(indicadorPresion);
        return indicadorPresion;
    }
    
    private void construirEtiquetaPresionResultante(Simulador simulador, SpringLayout springLayout) {
        
        JLabel lblPresionResultante = new JLabel("PRESION RESULTANTE");
        springLayout.putConstraint(SpringLayout.NORTH, lblPresionResultante, 53, SpringLayout.NORTH, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, lblPresionResultante, 606, SpringLayout.WEST, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, lblPresionResultante, 80, SpringLayout.NORTH, simulador.getContentPane());
        lblPresionResultante.setFont(new Font("Droid Sans", Font.BOLD, 20));
        lblPresionResultante.setName("EtiquetaPresionResultante");
        simulador.getContentPane().add(lblPresionResultante);
    }
    
    private void construirEtiquetaSimuladorDeGases(Simulador simulador, SpringLayout springLayout) {
        
        JLabel lblSimuladorDeGases = new JLabel("SIMULADOR DE GASES");
        springLayout.putConstraint(SpringLayout.NORTH, lblSimuladorDeGases, 15, SpringLayout.NORTH, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, lblSimuladorDeGases, 63, SpringLayout.WEST, simulador.getContentPane());
        lblSimuladorDeGases.setForeground(SystemColor.desktop);
        lblSimuladorDeGases.setFont(new Font("Droid Sans", Font.BOLD, 40));
        lblSimuladorDeGases.setName("EtiquetaSimulador");
        simulador.getContentPane().add(lblSimuladorDeGases);
    }
    
    private JPanel construirContenedorDeParticulas(Simulador simulador, SpringLayout springLayout) {

        JPanel contenedor = new Contenedor();
        ((Contenedor) contenedor).setLimites(80,80,380,450);
        springLayout.putConstraint(SpringLayout.NORTH, contenedor, 100, SpringLayout.NORTH, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, contenedor, 70, SpringLayout.WEST, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, contenedor, 550, SpringLayout.NORTH, simulador.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, contenedor, 450, SpringLayout.WEST, simulador.getContentPane());
        contenedor.setBackground(Color.WHITE);
        contenedor.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        contenedor.setName("ContenedorParticulas");
        simulador.getContentPane().add(contenedor);
        return contenedor;
    }

    private void construirLayout(Simulador simulador) {

        simulador.setBounds(0, 0, 930, 650);
        SpringLayout springLayout = new SpringLayout();
        simulador.getContentPane().setLayout(springLayout);

    }

    /**
	 * Accion ejecutada al presionar el boton "actualizar"
	 * El valor de la presion resultante y el movimiento de las particulas deben actualizarse aqui
	 */
	private void actualizar(){
		this.presion = this.leyDeGasesIdeales();		
	}
	
	/**
	 * Calculo de presion basado en la Ley de los Gases Ideales
	 */
	public String leyDeGasesIdeales(){
		Float constanteDeGases = new Float(0.082);
		Float presionResultante = (this.getMoles() * constanteDeGases * this.getTemperatura())/this.getVolumen();
		this.calcularColorDePresion(presionResultante);
		DecimalFormat numberFormat = new DecimalFormat("#.000");
		return numberFormat.format(presionResultante);
	}
	
	private void calcularColorDePresion(float PresionResultante) {
		Integer verde = (int) (255.0 * ((PresionResultante - 0.082) / 164.0));
		Color colorDePresion = new Color(255, 255 - verde, 0);	
		this.setColorDePresion(colorDePresion);
	}

	public Integer getMoles() {
		return moles;
	}

	public void setMoles(Integer moles) {
		this.moles = moles;
	}

	public Float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Float temperatura) {
		this.temperatura = temperatura;
	}

	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}

	public String getPresion() {
		return presion;
	}

	public void setPresion(String presion) {
		this.presion = presion;
	}

	public Color getColorDePresion() {
		return colorDePresion;
	}

	public void setColorDePresion(Color colorDePresion) {
		this.colorDePresion = colorDePresion;
	}	
}
