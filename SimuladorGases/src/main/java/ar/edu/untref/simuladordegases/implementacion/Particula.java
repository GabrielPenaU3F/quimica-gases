package ar.edu.untref.simuladordegases.implementacion;

import ar.edu.untref.simuladordegases.interfaz.VistaParticula;

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

    private final double constanteProporcionalidadVelocidad = 3.603424558562339;

    private VistaParticula vistaParticula;

    protected Orientacion orientacion;

    public Particula(Contenedor contenedor) {

        this.contenedor = contenedor;
        this.orientacion = new OrientacionSudeste(); //Se inicializa en sudeste
        this.energia = new Energia();
        this.energia.calcularEnergiaCineticaTotal(this.contenedor.getTemperatura());
        this.velocidad = this.calcularVelocidad();
        this.color = this.calcularColor(this.contenedor.getTemperatura());

        this.vistaParticula = new VistaParticula(this);

	}
    
    private Color calcularColor(double temperatura) {

        Integer verde = (int) (255.0 * ((temperatura - 100.0) / 500.0));
        return new Color(255, 255 - verde, 0);

    }
    
    private double calcularVelocidad() {

        /* Velocidad real es la velocidad fisica segun la teoria cinetica
        Velocidad es un numero que nosotros usamos, proporcional a esa
        velocidad real, para ajustarnos a los limites de temperatura establecidos
         Especificamente: la constante es tal que a 300K
         la particula tiene velocidad 1
         */
        double velocidadReal = Math.sqrt(2 * this.energia.getEnergiaCinetica() / this.masa);
        double velocidad = velocidadReal * constanteProporcionalidadVelocidad;
        return velocidad;

    }

    public void mover() {

        this.orientacion.mover(this);

    }

	/* crea un rectangulo alrededor de la pelota para hacer mas facil el metodo colision*/
	public Rectangle getRectanguloLimite() {

		return new Rectangle(this.x, this.y, this.ancho, this.altura);
		
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

    public int getAncho() {

        return this.ancho;
    }
    
    public int getAlto() {
        
        return this.altura;
    }

    public int getXPosicion() {

        return x;
    }

    public int getYPosicion() {

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

    public void actualizarColor() {

        this.color = calcularColor(this.contenedor.getTemperatura());

    }

    public VistaParticula getVista() {

        return this.vistaParticula;
    }
}
