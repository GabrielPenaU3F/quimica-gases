package ar.edu.untref.simuladordegases.implementacion;

import java.awt.*;

public class Particula {

    //La masa es la de la molecula de hidrogeno
    private double masa = 1.007;
    private Energia energia;

	//Posicion de la pelota en el contenedor
	private int x = 0;
	private int y = 0;
	
	private double velocidad;
	private Color color;
	
	protected Contenedor contenedor;
	private int altura = 10;
	private int ancho = 10;

    protected Orientacion orientacion;

    public Particula(Contenedor contenedor) {

        this.contenedor = contenedor;
        this.orientacion = new OrientacionSudeste(); //Se inicializa en sudeste
        this.energia = new Energia();
        this.energia.calcularEnergiaCineticaTotal(this.contenedor.getTemperatura());
        this.velocidad = this.calcularVelocidad();

	}

    private double calcularVelocidad() {

        double velocidad = Math.sqrt(2 * this.energia.getEnergiaCinetica() / this.masa);
        return velocidad;

    }

    public void mover() {

        this.orientacion.mover(this);

    }

	/* crea un rectangulo alrededor de la pelota para hacer mas facil el metodo colision*/
	public Rectangle getRectanguloLimite() {

		return new Rectangle(this.x, this.y, this.ancho, this.altura);
		
	}		

	public void paint(Graphics2D g) {

		g.fillOval(this.x, this.y, this.ancho, this.altura);
		g.setColor(this.getColor());

	}

	public double getVelocidad() {

		return this.velocidad;

	}

	public void setVelocidad(double velocidad) {

        this.velocidad = velocidad;

	}

	public Color getColor() {

		return color;

	}

	public void setColor(Color color) {

		this.color = color;

	}

    public int getAncho() {

        return this.ancho;
    }
    
    public int getAlto() {
        
        return this.altura;
    }

    public double getXPosicion() {

        return x;
    }

    public double getYPosicion() {

        return y;
    }

    public void setXPosicion(int x) {

        this.x = x;
    }

    public void setYPosicion(int y) {

        this.y = y;
    }
    
    public Contenedor getContenedor() {
        
        return this.contenedor;
    }
    
    public void setOrientacion(Orientacion orientacion) {
        
        this.orientacion = orientacion;

    }
}
