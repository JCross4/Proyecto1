package funcion;


public class Lenador extends Personaje {

    public Lenador(String nombre, Aldea aldea) {
        super(nombre,"lenador", aldea);
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
        /*Si quedan árboles disponibles, corta 1 árbol.  
2. Si no quedan árboles, descansa. */
        if (this.getAldea().getArbolesDisponibles() > 0 && this.getEnergia() >= 20) {
            // Objetivo: cortar árbol (podría ser la posición del árbol más cercano o alguna otra lógica)
            this.setObjetivo(this.getAldea().obtenerArbolCercano(this.getLabelGUI().getLocation()));
            this.setAccionActual("cortar");
        }
        else {
            // Objetivo: descansar
            this.setObjetivo(this.getLabelGUI().getLocation()); // Podría ser una posición específica para descansar
            this.setAccionActual("descansar");
        }
    }



}
