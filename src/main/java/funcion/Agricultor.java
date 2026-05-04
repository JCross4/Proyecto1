package funcion;

public class Agricultor extends Personaje {

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
    public void recibirDaño(int daño) {
        // TODO reduce vida actual segun daño recibido
        throw new UnsupportedOperationException("Unimplemented method 'recibirDaño'");
    }

    @Override
    public boolean estaVivo() {
        // TODO retorna boolean vivo
        throw new UnsupportedOperationException("Unimplemented method 'estaVivo'");
    }

}
