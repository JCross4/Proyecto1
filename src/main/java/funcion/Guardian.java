package funcion;

import java.awt.Point;

public class Guardian extends Personaje {

    public Guardian(String nombre, Aldea aldea) {
        super(nombre,"guardian", aldea);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void mover() {
        // TODO desplazar elemento y cambiar animación a "caminando"
        throw new UnsupportedOperationException("Unimplemented method 'mover'");
    }

    @Override
    public void realizarAccion() {
        // TODO realiza accion específica
        throw new UnsupportedOperationException("Unimplemented method 'realizarAccion'");
    }

    @Override
    public void comer() {
        // TODO recupera energia y reduce comida disponible
        throw new UnsupportedOperationException("Unimplemented method 'comer'");
    }

    @Override
    public void descansar() {
        // TODO recupera energia y cambia animación a "descansando"
        throw new UnsupportedOperationException("Unimplemented method 'descansar'");
    }

    @Override
    public void determinarObjetivo() {
        // TODO Auto-generated method stub
        /*Si hay animales activos, ataca al animal con mayor fuerza de ataque.  
2. Si no hay animales activos, vigila la entrada.  
3. Si no tiene energía suficiente, descansa */
        if (this.getAldea().getAnimalesActivos().size() > 0 && this.getEnergia() >= 30) {
            // Objetivo: atacar animal con mayor fuerza de ataque
            this.setObjetivo(this.getAldea().obtenerAnimalMasFuerte());
            this.setAccionActual("atacar");
        }
        else if (this.getEnergia() >= 15) {
            // Objetivo: vigilar la entrada (podría ser una posición específica cerca de la entrada)
            //this.setObjetivo(this.getAldea().obtenerPuntoVigilancia());
            this.setObjetivo(this.getLabelGUI().getLocation());
            this.setAccionActual("vigilar");
        }
        else {
            // Objetivo: descansar
            this.setObjetivo(this.getLabelGUI().getLocation()); // Podría ser una posición específica para descansar
            this.setAccionActual("descansar");
        }
    }


}
