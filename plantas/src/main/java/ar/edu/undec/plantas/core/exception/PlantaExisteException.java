package ar.edu.undec.plantas.core.exception;

public class PlantaExisteException extends Exception {
    @Override
    public String getMessage() {
        return "Ya existe la planta con ese nombre";
    }
}
