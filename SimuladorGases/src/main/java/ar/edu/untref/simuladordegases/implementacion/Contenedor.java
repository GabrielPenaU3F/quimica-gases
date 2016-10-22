package ar.edu.untref.simuladordegases.implementacion;

import ar.edu.untref.simuladordegases.interfaz.VistaContenedor;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class Contenedor {

	private List<Particula> particulas;

	private int ancho;
	private int alto;
	private int origen_x;
	private int origen_y;
    private double temperatura;
    private Agitador agitador;
    private VistaContenedor vistaContenedor;

	public Contenedor(){

        this.particulas = new LinkedList<Particula>();
        this.agitador = new Agitador();
        this.temperatura = 300;

        this.vistaContenedor = new VistaContenedor(this);

	}

	
	public void precipitar() throws InterruptedException{

		while (true) {
			this.agitador.agitar(this.particulas);
			this.vistaContenedor.repaint();
			Thread.sleep(10);
		}			
	}	

	/** Modifica la temperatura del contenedor
     * @param temperatura
     */
	public void modificarTemperatura(double temperatura){

        this.temperatura = temperatura;

        this.setColorDeParticulas();

		this.setVelocidadParticulas(this.temperatura/100);

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

            Particula particula = new Particula(this);
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

		for(Particula particula : this.particulas) {

            particula.actualizarColor();

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
    
    public VistaContenedor getVista() {

        return this.vistaContenedor;

    }
}
