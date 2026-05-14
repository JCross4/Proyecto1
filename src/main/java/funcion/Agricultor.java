package funcion;


public class Agricultor extends Personaje {

    public Agricultor(String nombre, Aldea aldea) {
        super(nombre, "agricultor", aldea);
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
        /*Si existe una parcela vacía, siembra una parcela.  
2. Si existe una parcela sembrada lista para cosechar, cosecha.  
3. Si todas las parcelas están ocupadas pero ninguna lista para cosechar, cuida cultivos.  
4. Si no puede hacer ninguna acción anterior, descansa.  */
        Parcela parcelaParaSembrar = null;
        Parcela parcelaParaCosechar = null;
        Parcela parcelaParaCuidar = null;
        for (Parcela parcela : this.getAldea().getParcelasCultivo()) {
            if (parcela.getEstado().equals("vacía")) {
                // Objetivo: sembrar parcela
                parcelaParaSembrar = parcela;
            }
            if (parcela.getEstado().equals("lista para cosechar")) {
                // Objetivo: cosechar parcela
                parcelaParaCosechar = parcela;
            }
            if (parcela.getEstado().equals("sembrada") && parcela.getCiclosParaCosechar() > 0) {
                // Objetivo: cuidar parcela
                parcelaParaCuidar = parcela;
            }
        }
        if (parcelaParaSembrar != null && this.getEnergia() >= 15) {
            this.setObjetivo(parcelaParaSembrar.getLabelGUI().getLocation());
            this.setAccionActual("sembrar");
        }
        else if (parcelaParaCosechar != null && this.getEnergia() >= 15) {
            this.setObjetivo(parcelaParaCosechar.getLabelGUI().getLocation());
            this.setAccionActual("cosechar");
        }
        else if (parcelaParaCuidar != null && this.getEnergia() >= 10) {
            // Objetivo: cuidar cultivos (podría ser la parcela con más ciclos para cosechar o alguna otra lógica)
            this.setObjetivo(parcelaParaCuidar.getLabelGUI().getLocation());
            this.setAccionActual("cuidar");
        }
        else {
            // Objetivo: descansar
            this.setObjetivo(this.getLabelGUI().getLocation()); // Podría ser una posición específica para descansar
            this.setAccionActual("descansar");
        }
    }


}
