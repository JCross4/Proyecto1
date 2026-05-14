package funcion;

import java.awt.Point;

public class Constructor extends Personaje {

    public Constructor(String nombre, Aldea aldea) {
        super(nombre,"constructor", aldea);
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
        /*1. Si la cerca tiene resistencia menor a 100 y hay al menos 5 unidades de madera, 
repara la cerca.  
2. Si la cerca está en 100 y existe alguna torre con resistencia menor a su máximo y 
hay al menos 4 unidades de madera, repara una torre.  
3. Si la cerca está en 100, todas las torres están al máximo y la aldea tiene menos de 3 
torres, construye una nueva torre si hay al menos 20 unidades de madera.  
4. Si ninguna condición anterior se cumple, descansa.  */
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
        /*1. Si la cerca tiene resistencia menor a 100 y hay al menos 5 unidades de madera, 
repara la cerca.  
2. Si la cerca está en 100 y existe alguna torre con resistencia menor a su máximo y 
hay al menos 4 unidades de madera, repara una torre.  
3. Si la cerca está en 100, todas las torres están al máximo y la aldea tiene menos de 3 
torres, construye una nueva torre si hay al menos 20 unidades de madera.  
4. Si ninguna condición anterior se cumple, descansa.  */
        TorreDefensa torreParaReparar = null;
        for (TorreDefensa torre : this.getAldea().getTorres()) {
            if (torre.getResistenciaActual() < torre.getResistenciaMaxima()) {
                // Objetivo: reparar torre
                torreParaReparar = torre;
            }
        }
        if (this.getAldea().getCercaPrincipal().getResistenciaActual() < this.getAldea().getCercaPrincipal().getResistenciaMaxima() && this.getAldea().getMaderaDisponible() >= 5 && this.getEnergia() >= 20) {
            // Objetivo: reparar cerca
            this.setObjetivo(new Point(this.getAldea().getCercaPrincipal().getLabelGUI().getLocation().x + getAldea().getVentana().getLABEL_SIZE() * 4, this.getAldea().getCercaPrincipal().getLabelGUI().getLocation().y + getAldea().getVentana().getLABEL_SIZE() * 4));
            setAccionActual("reparar cerca");
            getAldea().getVentana().agregarLog("Constructor " + this.getNombre() + " va a reparar la cerca.");
        } else if (this.getAldea().getCercaPrincipal().getResistenciaActual() == 100 && torreParaReparar != null && this.getAldea().getMaderaDisponible() >= 4 && this.getEnergia() >= 20) {
            // Objetivo: reparar torre
            this.setObjetivo(torreParaReparar.getLabelGUI().getLocation());
            setAccionActual("reparar torre");
            getAldea().getVentana().agregarLog("Constructor " + this.getNombre() + " va a reparar la torre " + torreParaReparar.getNombre() + ".");
        } else if (this.getAldea().getCercaPrincipal().getResistenciaActual() == this.getAldea().getCercaPrincipal().getResistenciaMaxima() && torreParaReparar == null && this.getAldea().getTorres().size() < 3 && this.getAldea().getMaderaDisponible() >= 20 && this.getEnergia() >= 20) {
            // Objetivo: construir nueva torre
            this.setObjetivo(new Point(getAldea().getVentana().getLABEL_SIZE()*this.getAldea().getTorres().size(), getAldea().getVentana().getLABEL_SIZE() * 4));
            setAccionActual("construir torre");
            getAldea().getVentana().agregarLog("Constructor " + this.getNombre() + " va a construir una nueva torre.");
        } else {
            // Objetivo: descansar
            this.setObjetivo(getLabelGUI().getLocation());
            setAccionActual("descansar");
            getAldea().getVentana().agregarLog("Constructor " + this.getNombre() + " va a descansar.");
        }
    }


}
