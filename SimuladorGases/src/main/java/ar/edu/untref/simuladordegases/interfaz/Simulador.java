package ar.edu.untref.simuladordegases.interfaz;

import ar.edu.untref.simuladordegases.implementacion.CalculadoraGasesIdeales;
import ar.edu.untref.simuladordegases.implementacion.Contenedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Simulador extends JFrame {
		
	/**
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;

	private double presion = 12.309;
	private int moles = 50;
	private double temperatura = 300;
	private double volumen = 70;
	private Color colorDePresion;

    private Map<String, JComponent> componentes;

    private CalculadoraGasesIdeales calculadoraGases;

    private SpringLayout springLayout;

	/**
	 * Launch the application.
	 * @throws InterruptedException
	 */

    public void comenzarSimulacion() throws InterruptedException {

        this.construirLayout();
        this.componentes = new HashMap<String, JComponent>();
        this.calculadoraGases = new CalculadoraGasesIdeales();
        this.construirComponentesVisuales();
        this.construirBotonActualizar(); //Nombre: BotonActualizar

        this.setVisible(true);
        ((VistaContenedor) this.componentes.get("ContenedorParticulas")).getContenedor().precipitar();

    }

    private void construirComponentesVisuales() throws InterruptedException {

        this.construirContenedorDeParticulas(); //Nombre: ContenedorParticulas

        this.construirEtiquetaSimuladorDeGases(); //Nombre: EtiquetaSimulador

        this.construirEtiquetaPresionResultante(); //Nombre: EtiquetaPresionResultante

        this.construirIndicadorDePresion(); //Nombre: IndicadorDePresion

        this.construirEtiquetaMoles(); //Nombre: EtiquetaMoles

        this.construirSliderMoles(); //Nombre: SliderMoles

        this.construirEtiquetaTemperatura(); //Nombre: EtiquetaTemperatura

        this.construirSliderTemperatura(); //Nombre: SliderTemperatura

        this.construirEtiquetaVolumen(); //Nombre: EtiquetaVolumen

        this.construirSliderVolumen(); //Nombre: SliderVolumen

    }

    private void construirBotonActualizar() throws InterruptedException {

        JButton btnActualizar = new JButton("Actualizar");

        imponerRestriccionesParaElTamanioDelContenedor(btnActualizar);

        colocarListener(btnActualizar);

        btnActualizar.setFont(new Font("Droid Sans", Font.BOLD, 16));
        btnActualizar.setName("BotonActualizar");
        this.getContentPane().add(btnActualizar);

		/*
		 * Primero genera todo el contenido y luego lo hace visible
		 * NOTA: Si esta sentencia esta al principio del main NO SE MUESTRA NADA
		 * NOTA2: Si esta sentencia esta al final del main, el simulador nunca se hace visible porque precipitar() es infinito
		 */

    }

    private void colocarListener(JComponent boton) {

        Simulador simulador = this;
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                simulador.actualizar();

                //Modificación de la temperatura del gas
                double temp_actual = simulador.getTemperatura();
                ((VistaContenedor)simulador.componentes.get("ContenedorParticulas")).getContenedor().modificarTemperatura(temp_actual);

                //Modificación de la cantidad de moles de gas
                int moles_actual = simulador.getMoles();
                ((VistaContenedor)simulador.componentes.get("ContenedorParticulas")).getContenedor().modificarCantidadDeMoles(moles_actual);

                //Modificación del volumen del recipiente
                double vol_actual = simulador.getVolumen();
                modificarVolumen(vol_actual);

                //Modificación de la etiqueta de presion
                ((LabelPresion)simulador.componentes.get("IndicadorDePresion")).setText(simulador.getPresionFormateada() + " atm.");
                simulador.componentes.get("IndicadorDePresion").setForeground(simulador.getColorDePresion());

            }
        });
    }

    private void modificarVolumen(double vol_actual) {

        Integer nuevoBordeSur = (int) (550 * (vol_actual/100.0));
        Integer nuevoBordeEste = (int) (450 * (vol_actual/100.0));
        ((VistaContenedor)this.componentes.get("ContenedorParticulas")).getContenedor().setAncho(nuevoBordeEste - 70);
        ((VistaContenedor)this.componentes.get("ContenedorParticulas")).getContenedor().setAlto(nuevoBordeSur - 100);
        springLayout.putConstraint(SpringLayout.SOUTH, this.componentes.get("ContenedorParticulas"), nuevoBordeSur, SpringLayout.NORTH, this.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, this.componentes.get("ContenedorParticulas"), nuevoBordeEste, SpringLayout.WEST, this.getContentPane());
    }

    private void imponerRestriccionesParaElTamanioDelContenedor(JButton btnActualizar) {

        this.springLayout.putConstraint(SpringLayout.NORTH, btnActualizar, 42, SpringLayout.SOUTH, this.componentes.get("SliderVolumen"));
        this.springLayout.putConstraint(SpringLayout.WEST, btnActualizar, 0, SpringLayout.WEST, this.componentes.get("EtiquetaTemperatura"));
        this.springLayout.putConstraint(SpringLayout.SOUTH, btnActualizar, 550, SpringLayout.NORTH, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.EAST, btnActualizar, 131, SpringLayout.WEST, this.componentes.get("EtiquetaTemperatura"));
    }


    private void construirSliderVolumen() {

        SliderVolumen sliderVolumen = new SliderVolumen();

        this.springLayout.putConstraint(SpringLayout.NORTH, sliderVolumen, 424, SpringLayout.NORTH, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.WEST, sliderVolumen, 553, SpringLayout.WEST, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.EAST, sliderVolumen, 868, SpringLayout.WEST, this.getContentPane());

        this.getContentPane().add(sliderVolumen);
        this.componentes.put("SliderVolumen", sliderVolumen);
        this.volumen = sliderVolumen.getValor();

    }

    private void construirEtiquetaVolumen() {

        LabelVolumen lblVolumen = new LabelVolumen("Volumen (l)");

        this.springLayout.putConstraint(SpringLayout.NORTH, lblVolumen, 402, SpringLayout.NORTH, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.WEST, lblVolumen, 670, SpringLayout.WEST, this.getContentPane());

        this.getContentPane().add(lblVolumen);
        this.componentes.put("EtiquetaVolumen", lblVolumen);

    }

    private void construirSliderTemperatura() {

        SliderTemperatura sliderTemperatura = new SliderTemperatura();

        this.springLayout.putConstraint(SpringLayout.NORTH, sliderTemperatura, 312, SpringLayout.NORTH, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.WEST, sliderTemperatura, 553, SpringLayout.WEST, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.EAST, sliderTemperatura, 868, SpringLayout.WEST, this.getContentPane());

        this.getContentPane().add(sliderTemperatura);
        this.componentes.put("SliderTemperatura", sliderTemperatura);
        this.temperatura = sliderTemperatura.getValor();

    }

    private void construirEtiquetaTemperatura() {

        LabelTemperatura lblTemperatura = new LabelTemperatura("Temperatura (K)");

        this.springLayout.putConstraint(SpringLayout.NORTH, lblTemperatura, 290, SpringLayout.NORTH, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.WEST, lblTemperatura, 653, SpringLayout.WEST, this.getContentPane());

        this.getContentPane().add(lblTemperatura);
        this.componentes.put("EtiquetaTemperatura", lblTemperatura);

    }

    private void construirSliderMoles() {

        SliderMoles sliderMoles = new SliderMoles();

        this.springLayout.putConstraint(SpringLayout.NORTH, sliderMoles, 189, SpringLayout.NORTH, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.WEST, sliderMoles, 553, SpringLayout.WEST, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.EAST, sliderMoles, 868, SpringLayout.WEST, this.getContentPane());

        this.getContentPane().add(sliderMoles);
        this.componentes.put("SliderMoles", sliderMoles);
        this.moles = (int)sliderMoles.getValor();

    }

    private void construirEtiquetaMoles() {

        LabelMoles lblMoles = new LabelMoles("Moles");

        this.springLayout.putConstraint(SpringLayout.NORTH, lblMoles, 167, SpringLayout.NORTH, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.WEST, lblMoles, 690, SpringLayout.WEST, this.getContentPane());

        this.getContentPane().add(lblMoles);
        this.componentes.put("EtiquetaMoles", lblMoles);

    }

    private void construirIndicadorDePresion() {

        LabelPresion indicadorPresion = new LabelPresion(this.presion + " atm.");

        this.springLayout.putConstraint(SpringLayout.NORTH, indicadorPresion, 85, SpringLayout.NORTH, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.WEST, indicadorPresion, 667, SpringLayout.WEST, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.SOUTH, indicadorPresion, 118, SpringLayout.NORTH, this.getContentPane());

        this.getContentPane().add(indicadorPresion);
        this.componentes.put("IndicadorDePresion", indicadorPresion);

    }

    private void construirEtiquetaPresionResultante() {

        LabelPresion lblPresionResultante = new LabelPresion("PRESION RESULTANTE");
        this.springLayout.putConstraint(SpringLayout.NORTH, lblPresionResultante, 53, SpringLayout.NORTH, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.WEST, lblPresionResultante, 606, SpringLayout.WEST, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.SOUTH, lblPresionResultante, 80, SpringLayout.NORTH, this.getContentPane());

        //lblPresionResultante.setFont(new Font("Droid Sans", Font.BOLD, 20));
        //lblPresionResultante.setName("EtiquetaPresionResultante");

        this.getContentPane().add(lblPresionResultante);
        this.componentes.put("EtiquetaPresionResultante", lblPresionResultante);

    }

    private void construirEtiquetaSimuladorDeGases() {

        LabelSimulador lblSimuladorDeGases = new LabelSimulador("SIMULADOR DE GASES");

        this.springLayout.putConstraint(SpringLayout.NORTH, lblSimuladorDeGases, 15, SpringLayout.NORTH, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.WEST, lblSimuladorDeGases, 63, SpringLayout.WEST, this.getContentPane());

        this.getContentPane().add(lblSimuladorDeGases);
        this.componentes.put("EtiquetaSimulador", lblSimuladorDeGases);
    }

    private void construirContenedorDeParticulas() {

        Contenedor contenedor = new Contenedor();
        contenedor.setLimites(0,0,400,400);
        JPanel vistaContenedor = new VistaContenedor(contenedor);

        this.springLayout.putConstraint(SpringLayout.NORTH, vistaContenedor, 100, SpringLayout.NORTH, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.WEST, vistaContenedor, 70, SpringLayout.WEST, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.SOUTH, vistaContenedor, 550, SpringLayout.NORTH, this.getContentPane());
        this.springLayout.putConstraint(SpringLayout.EAST, vistaContenedor, 450, SpringLayout.WEST, this.getContentPane());

        this.getContentPane().add(vistaContenedor);
        this.componentes.put("ContenedorParticulas", vistaContenedor);
    }

    private void construirLayout() {

        this.setBounds(0, 0, 930, 650);
        this.springLayout = new SpringLayout();
        this.getContentPane().setLayout(this.springLayout);

    }

    /**
	 * Accion ejecutada al presionar el boton "actualizar"
	 * El valor de la presion resultante y el movimiento de las particulas deben actualizarse aqui
	 */
	private void actualizar()
    {

        this.temperatura = ((SliderTemperatura)this.componentes.get("SliderTemperatura")).getValor();
        this.volumen = ((SliderVolumen)this.componentes.get("SliderVolumen")).getValor();
        this.moles = ((SliderMoles)this.componentes.get("SliderMoles")).getValor();

        this.presion = this.calculadoraGases.calcularPresion(this.getMoles(), this.getTemperatura(), this.getVolumen());
        this.calcularColorSegunPresion();

	}

	/**
	 * Calculo de presion basado en la Ley de los Gases Ideales
	 */


	private void calcularColorSegunPresion() {

		Integer verde = (int) (255.0 * ((this.getPresion() - 0.082) / 164.0));
		Color colorDePresion = new Color(255, 255 - verde, 0);
		this.setColorDePresion(colorDePresion);

	}

	public int getMoles() {

        return this.moles;

	}


	public double getTemperatura() {

		return this.temperatura;

	}


	public double getVolumen() {

		return this.volumen;

	}


	public String getPresionFormateada() {

        DecimalFormat numberFormat = new DecimalFormat("#.000");
        return numberFormat.format(this.presion);

	}

    public double getPresion() {

        return this.presion;

    }

	public Color getColorDePresion() {
		return this.colorDePresion;
	}

	public void setColorDePresion(Color colorDePresion) {
		this.colorDePresion = colorDePresion;
	}	
}
