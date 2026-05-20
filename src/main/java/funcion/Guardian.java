package funcion;

import java.awt.Point;

public class Guardian extends Personaje {
    private Animal animalObjetivo;
    private int dañoAtaque;

    public Guardian(String nombre, Aldea aldea) {
        super(nombre,"guardian", aldea);
        dañoAtaque = 20;
    }

    @Override
    public void mover() {
        // TODO desplazar elemento y cambiar animación a "caminando"
        throw new UnsupportedOperationException("Unimplemented method 'mover'");
    }

    @Override
    public void realizarAccion() {
        // TODO realiza accion específica
        //throw new UnsupportedOperationException("Unimplemented method 'realizarAccion'");
        /*Si hay animales activos, ataca al animal con mayor fuerza de ataque.  
2. Si no hay animales activos, vigila la entrada.  
3. Si no tiene energía suficiente, descansa */
    switch (getAccionActual()) {
        case "atacar":
            if (animalObjetivo != null) {
                animalObjetivo.recibirDaño(getDañoAtaque()); // Reduce la salud del animal por el ataque
                this.setEnergia(this.getEnergia() - 15); // Reduce energía por atacar
            }
            break;
        case "vigilar":
            //Vigilar ???
            setEnergia(getEnergia()-5);
            break;
        case "descansar":
            this.setEnergia(Math.min(100, this.getEnergia() + 30));
            break;    
        default:
            break;
    }
    setAnimalObjetivo(null);
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
            animalObjetivo = this.getAldea().obtenerAnimalMasFuerte();
            this.setObjetivo(animalObjetivo.getLabelGUI().getLocation());
            this.setAccionActual("atacar");
        }
        else if (this.getEnergia() >= 15) {
            // Objetivo: vigilar la entrada 
            setObjetivo(new Point(getAldea().getVentana().getLABEL_SIZE()*4, getAldea().getVentana().getLABEL_SIZE()*4));
            
            this.setAccionActual("vigilar");
        }
        else {
            // Objetivo: descansar
            this.setObjetivo(this.getLabelGUI().getLocation()); // Podría ser una posición específica para descansar
            this.setAccionActual("descansar");
        }
    }

    public Animal getAnimalObjetivo() {
        return animalObjetivo;
    }

    public void setAnimalObjetivo(Animal animalObjetivo) {
        this.animalObjetivo = animalObjetivo;
    }

    public int getDañoAtaque() {
        return dañoAtaque;
    }

    public void setDañoAtaque(int dañoAtaque) {
        this.dañoAtaque = dañoAtaque;
    }


}
