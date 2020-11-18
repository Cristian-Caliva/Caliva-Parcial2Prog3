package ar.edu.undec.computadoras.core.excepcion;

public class ComputadoraExisteException extends Exception {
    @Override
    public String getMessage() {
        return "Ya existe una computadora con ese nombre";
    }
}
