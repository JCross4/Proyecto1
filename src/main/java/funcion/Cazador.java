package funcion;

import java.awt.Point;

public class Cazador extends Personaje {

    public Cazador(String nombre, Aldea aldea) {
        super(nombre,"cazador", aldea);
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
        /*Si existe al menos 1 animal activo en los alrededores, ataca un animal.  
2. Si no hay animales activos, patrulla.  
3. Si no puede atacar ni patrullar por falta de energía, descansa. */
        if (this.getAldea().getAnimalesActivos().size() > 0 && this.getEnergia() >= 25) {
            // Objetivo: atacar animal (podría ser la posición del animal más cercano o alguna otra lógica)
            this.setObjetivo(this.getAldea().obtenerAnimalCercano(this.getLabelGUI().getLocation()));
        }
        else if (this.getEnergia() >= 10) {
            // Objetivo: patrullar (podría ser una ruta predefinida o alguna otra lógica)
            //this.setObjetivo(this.getAldea().obtenerPuntoPatrulla(this.getLabelGUI().getLocation()));
        }
        else {
            // Objetivo: descansar
            this.setObjetivo(this.getLabelGUI().getLocation()); // Podría ser una posición específica para descansar
        }
    }

  
}
