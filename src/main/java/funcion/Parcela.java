package funcion;

public class Parcela extends Estructura {

    @Override
    public void recibirDaño(int daño) {
        // reducir vida igual al daño recibido
        throw new UnsupportedOperationException("Unimplemented method 'recibirDaño'");
    }

    @Override
    public void reparar(int cantidad) {
        // aumentar vida igual a la cantidad de reparación
        throw new UnsupportedOperationException("Unimplemented method 'reparar'");
    }

    @Override
    public boolean estaDestruida() {
        // retornar atributo destruida
        return isDestruida();
    }

}
