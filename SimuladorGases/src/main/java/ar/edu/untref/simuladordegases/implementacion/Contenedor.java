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
	private int x;
	private int y;
	private double numAleatorio;
    private float temperatura;

	public Contenedor(){
		this.particulas = new LinkedList<Particula>();
	}


	        //Este metodo puede mejorarse mucho
			public void agitar() {

            //Se posiciona en cada partícula de la lista.
            for (int i = 0; i < this.particulas.size(); i++) {

                numAleatorio = Math.random();
                Particula particulaActual = this.particulas.get(i);

                //Se posiciona en otra partícula de la lista.
                for (int j = 0; j < this.particulas.size(); j++) {

                    // Si i es diferente de j porque una partícula no se va a colisionar con ella misma
                    // por eso no tiene sentido probar el if(colisión) si i es igual a j.
                    if (i != j) {

                        Particula otraParticula = this.particulas.get(j);

                        //Verifica la condicion de colision
                        if (hayChoqueEntre(particulaActual, otraParticula)) {

                            if (numAleatorio > 0.0 && numAleatorio < 0.25) {

                                particulaActual.setOrientacion(new OrientacionNoroeste());
                                otraParticula.setOrientacion(new OrientacionSudeste());

                            } else if (numAleatorio >= 0.25 && numAleatorio < 0.50) {

                                particulaActual.setOrientacion(new OrientacionSudeste());
                                otraParticula.setOrientacion(new OrientacionNoroeste());

                            } else if (numAleatorio >= 0.50 && numAleatorio < 0.75) {

                                particulaActual.setOrientacion(new OrientacionSudoeste());
                                otraParticula.setOrientacion(new OrientacionNoreste());

                            } else if (numAleatorio >= 0.75 && numAleatorio < 1.0) {

                                particulaActual.setOrientacion(new OrientacionNoreste());
                                otraParticula.setOrientacion(new OrientacionSudoeste());

                            }

                        }

                        //EN ESTE METODO ESTA EL BUG QUE HAY QUE ARREGLAR.
                        this.moverParticulas();

                    }

                }

            }
        }

    private void moverParticulas() {

        for(Particula particula: this.particulas) {

            particula.mover();

        }

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
			this.agitar();
			this.repaint();	
			Thread.sleep(10);
		}			
	}	

	/** Modifica la temperatura del contenedor
	 */
	public void modificarTemperaturaDeParticulas(float temperatura){

        this.temperatura = temperatura;

        this.setColorDeParticulas();

		this.setVelocidadParticulas(this.temperatura/100);

	}

	private Color calcularColorDeParticulas() {

		Integer verde = (int) (255.0 * ((temperatura - 100.0) / 500.0));
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

    /** El metodo colision tendria que detectar que se esta chocando contra algo (objeto o pared)
     * y la pelota tendria que cambiar el sentido en el que rebota
     * por otro lado, el metodo intersects devuelve true si el obj de la izquierda se choca con el de la derecha
     * */
    private boolean hayChoqueEntre(Particula particula, Particula otraParticula) {

        return particula.getRectanguloLimite().intersects(otraParticula.getRectanguloLimite());

    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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

		this.setX(x);
		this.setY(x);
		this.ancho = ancho;
		this.alto = alto;

	}

	public void setVelocidadParticulas(float velocidad) {

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

}
