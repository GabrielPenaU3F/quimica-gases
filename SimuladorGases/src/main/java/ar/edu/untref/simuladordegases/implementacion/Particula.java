package ar.edu.untref.simuladordegases.implementacion;

import java.awt.*;

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

	public Particula(Contenedor contenedor, float mov_x, float mov_y, float vel) {

        this.contenedor = contenedor;
		this.modificarMovimiento(mov_x, mov_y);
		this.velocidad = vel;

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
    
    public void modificarMovimiento(float mov_x, float mov_y) {

        this.mov_x = mov_x;
        this.mov_y = mov_y;
        
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

    public void moverNoroeste() {

        this.x = calcularNuevaPosicionEnX(-this.velocidad);
        this.y = calcularNuevaPosicionEnY(this.velocidad);

    }

    public void moverNoreste() {

        this.x = calcularNuevaPosicionEnX(this.velocidad);
        this.y = calcularNuevaPosicionEnY(this.velocidad);

    }

    public void moverSudeste() {

        this.x = calcularNuevaPosicionEnX(this.velocidad);
        this.y = calcularNuevaPosicionEnY(-this.velocidad);

    }

    public void moverSudoeste() {

        this.x = calcularNuevaPosicionEnX(-this.velocidad);
        this.y = calcularNuevaPosicionEnY(-this.velocidad);

    }

    private int calcularNuevaPosicionEnY(float movimientoEnY) {

        float posicionFinalRegular = this.y + movimientoEnY;
        if(posicionFinalRegular < 0) {

            float movimientoRestanteLuegoDelChoque = movimientoEnY - this.y;
            return (int) movimientoRestanteLuegoDelChoque;

        }
        if(posicionFinalRegular > this.contenedor.getAlto()) {

            float movimientoRestanteLuegoDelChoque = movimientoEnY - (this.contenedor.getAlto() - this.y);
            return (int) movimientoRestanteLuegoDelChoque;

        }
        return (int) posicionFinalRegular;

    }

    private int calcularNuevaPosicionEnX(float movimientoEnX) {

        float posicionFinalRegular = this.x + movimientoEnX;
        if(posicionFinalRegular < 0) {

            float movimientoRestanteLuegoDelChoque = movimientoEnX - this.x;
            return (int) movimientoRestanteLuegoDelChoque;

        }
        if(posicionFinalRegular > this.contenedor.getAncho()) {

            float movimientoRestanteLuegoDelChoque = movimientoEnX - (this.contenedor.getAncho() - this.x);
            return (int) movimientoRestanteLuegoDelChoque;

        }
        return (int) posicionFinalRegular;

    }

}
