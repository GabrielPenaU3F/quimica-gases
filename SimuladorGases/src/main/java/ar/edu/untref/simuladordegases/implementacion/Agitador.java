package ar.edu.untref.simuladordegases.implementacion;

import java.util.List;

/**
 * Created by synysterlove on 06/10/16.
 */
public class Agitador {

    //Este metodo puede mejorarse mucho
    public void agitar(List<Particula> particulas) {

        //Se posiciona en cada partícula de la lista.
        for (int i = 0; i < particulas.size(); i++) {

            Particula particulaActual = particulas.get(i);

            //Se posiciona en otra partícula de la lista.
            for (int j = 0; j < particulas.size(); j++) {

                // Si i es diferente de j porque una partícula no se va a colisionar con ella misma
                // por eso no tiene sentido probar el if(colisión) si i es igual a j.
                if (i != j) {

                    Particula otraParticula = particulas.get(j);

                    //Verifica la condicion de colision
                    double numAleatorio = Math.random();
                    if (hayChoqueEntre(particulaActual, otraParticula)) {

                        this.chocarAleatoriamente(particulaActual, otraParticula, numAleatorio);

                    }

                    //EN ESTE METODO ESTA EL BUG QUE HAY QUE ARREGLAR.
                    this.moverParticulas(particulas);

                }

            }

        }
    }

    public void chocarAleatoriamente(Particula particulaActual, Particula otraParticula, double numAleatorio) {

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

    public void moverParticulas(List<Particula> particulas) {

        for(Particula particula: particulas) {

            particula.mover();

        }

    }

    private boolean hayChoqueEntre(Particula particula, Particula otraParticula) {

        return particula.getRectanguloLimite().intersects(otraParticula.getRectanguloLimite());

    }
    
}
