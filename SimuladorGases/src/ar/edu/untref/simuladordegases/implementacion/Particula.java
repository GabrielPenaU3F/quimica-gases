package ar.edu.untref.simuladordegases.implementacion;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Particula {

	//Posicion de la pelota en el contenedor
	private int x = 0;
	private int y = 0;

	//mov_x y mov_y representan el movimiento de la pelota
	private float mov_x;
	private float mov_y;
	
	private float velocidad;
	private Color color;
	
	private Contenedor contenedor;
	private int altura = 10;
	private int ancho = 10;
	
	Shape circle = new Ellipse2D.Float(this.altura, this.ancho, this.x, this.y);

	public Particula(Contenedor contenedor, float mov_x, float mov_y, float vel) {

        this.contenedor= contenedor;
		this.modificarMovimiento(mov_x, mov_y);
		this.velocidad = vel;

	}

	public void mover() {
		
		if (x + mov_x < 0)

			mov_x = velocidad;

		if (x + mov_x > contenedor.getAncho() - this.ancho)

			mov_x = -velocidad;

		if (y + mov_y < 0)

			mov_y = velocidad;

		if (y + mov_y > contenedor.getAlto() - this.altura)

			mov_y = -velocidad;
		
		x = (int) (x + mov_x);
		y = (int) (y + mov_y);
	}

	/* crea un rectangulo alrededor de la pelota para hacer mas facil el metodo colision*/
	public Rectangle getRectanguloLimite() {
		return new Rectangle(this.x, this.y, this.ancho, this.altura);
		
	}		

	public void paint(Graphics2D g) {
		g.fillOval(this.x, this.y, this.ancho, this.altura);
		g.setColor(this.getColor());
	}

	public float getVelocidad() {

		return this.velocidad;

	}

	public void setVelocidad(float velocidad) {

        this.velocidad = velocidad;

	}

	public void setX(int x) {

		this.x = x;

	}

	public void setY(int y) {

		this.y = y;

	}

	public float getMovimientoX() {

		// TODO Auto-generated method stub
		return this.mov_x;

	}

	public float getMovimientoY() {

		// TODO Auto-generated method stub
		return this.mov_y;

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
    
    public void modificarMovimiento(Float mov_x, Float mov_y) {

        this.mov_x = mov_x;
        this.mov_y = mov_y;
        
    }

    public int getAncho() {

        return this.ancho;
    }
    
    public int getAlto() {
        
        return this.altura;
    }
}
