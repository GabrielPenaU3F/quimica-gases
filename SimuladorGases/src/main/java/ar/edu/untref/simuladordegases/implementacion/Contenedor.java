package ar.edu.untref.simuladordegases.implementacion;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class Contenedor extends JPanel {

	private List<Particula> particulas;

	private int ancho;
	private int alto;
	private int origen_x;
	private int origen_y;
    private double temperatura;
    private Agitador agitador;

	public Contenedor(){

        this.particulas = new LinkedList<Particula>();
        this.agitador = new Agitador();
	}

    
    @Override
	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		for(Particula particula : this.particulas){

			particula.paint(g2d);

		}		
	}
	
	public void precipitar() throws InterruptedException{

		while (true) {
			this.agitador.agitar(this.particulas);
			this.repaint();	
			Thread.sleep(10);
		}			
	}	

	/** Modifica la temperatura del contenedor
     * @param temperatura
     */
	public void modificarTemperaturaDeParticulas(double temperatura){

        this.temperatura = temperatura;

        this.setColorDeParticulas();

		this.setVelocidadParticulas(this.temperatura/100);

	}

	private Color calcularColorDeParticulas() {

		Integer verde = (int) (255.0 * ((this.temperatura - 100.0) / 500.0));
		return new Color(255, 255 - verde, 0);

	}

	/**
	 * Modifica cantidad de particulas
	 */	
	public void modificarCantidadDeMoles(int cantidadDeParticulas){

		if(cantidadDeParticulas >= this.particulas.size()){

			this.agregarParticulas(cantidadDeParticulas - this.particulas.size());

        } else {

			this.eliminarParticulas(this.particulas.size() - cantidadDeParticulas);

        }
	}

	/** 
	 * Agregar un determinado paquete de particulas
	 */
	public void agregarParticulas(int cantidadDeParticulas){	

		for(int i = 0; i < cantidadDeParticulas; i++){

            Particula particula = new Particula(this, 1);
            particula.setColor(this.calcularColorDeParticulas());
			this.particulas.add(particula);

		}
		
	}

	/**
	 * Elimina un determinado paquete de particulas
	 */
	public void eliminarParticulas(int cantidadDeParticulas){
		
		for(int i = 0; i < cantidadDeParticulas; i++){

			this.particulas.remove(this.particulas.size() - 1);

		}
		
	}

	public int getOrigenX() {
		return this.origen_x;
	}

	public void setOrigenX(int x) {
		this.origen_x = x;
	}

	public int getOrigenY() {
		return this.origen_y;
	}

	public void setOrigenY(int y) {
		this.origen_y = y;
	}

	public int getAncho(){
		return this.ancho;
	}

	public int getAlto(){
		return this.alto;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public void setLimites(int x, int y, int ancho, int alto) {

		this.setOrigenX(x);
		this.setOrigenY(y);
		this.ancho = ancho;
		this.alto = alto;

	}

	public void setVelocidadParticulas(double velocidad) {

		for (Particula particula : this.particulas) {

            particula.setVelocidad(velocidad);

        }

	}

	public void setColorDeParticulas() {

        Color color = this.calcularColorDeParticulas();
		for(Particula particula : this.particulas) {

            particula.setColor(color);

        }

	}

    public void agregarParticula(Particula particula) {

        this.particulas.add(particula);

    }
    
    public double getTemperatura() {
        
        return this.temperatura;
    }

    public List<Particula> getParticulas() {

        return this.particulas;
    }
}
