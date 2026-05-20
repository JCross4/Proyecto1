package funcion;

import java.awt.Point;

public class ThreadMovimiento extends Thread {
    private Personaje personaje;
    private boolean running;

    public ThreadMovimiento(Personaje personaje) {
        this.personaje = personaje;
        this.running = true;
    }

    @Override
    public void run() {
        int currentX;
        int currentY;
        Point puntoOriginal = personaje.getLabelGUI().getLocation();
        while (running) {
            try {
                if (personaje.getLabelGUI().getLocation().equals(personaje.getObjetivo()) && !personaje.getObjetivo().equals(puntoOriginal)) {
                    // El personaje ha llegado a su objetivo, puede realizar una acción o determinar un nuevo objetivo
                    personaje.realizarAccion();
                    System.out.println(personaje.getNombre() + " ha llegado a su objetivo en (" + personaje.getObjetivo().x + ", " + personaje.getObjetivo().y + ")");
                    Thread.sleep(1500); // Simula el tiempo que tarda en realizar la acción
                    //Volver a posición inicial
                    personaje.setObjetivo(puntoOriginal);
                    personaje.setAccionActual("ninguna");
                }
                Thread.sleep(400); // Simula el tiempo entre movimientos
                currentX = personaje.getLabelGUI().getX();
                currentY = personaje.getLabelGUI().getY();
                if (currentX < personaje.getObjetivo().x) {
                    currentX += personaje.getAldea().getVentana().getLABEL_SIZE(); // Mueve a la derecha
                } else if (currentX > personaje.getObjetivo().x) {
                    currentX -= personaje.getAldea().getVentana().getLABEL_SIZE(); // Mueve a la izquierda
                } else if (currentY < personaje.getObjetivo().y) {
                    currentY += personaje.getAldea().getVentana().getLABEL_SIZE(); // Mueve hacia abajo
                } else if (currentY > personaje.getObjetivo().y) {
                    currentY -= personaje.getAldea().getVentana().getLABEL_SIZE(); // Mueve hacia arriba
                }
                personaje.getAldea().getVentana().moverPersonaje(personaje, currentX, currentY); // El personaje se mueve hacia su objetivo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread() {
        running = false;
    }

    public void resumeThread() {
        running = true;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
    

}
