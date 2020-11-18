package ar.edu.undec.computadoras.core.usecase.input;

import ar.edu.undec.computadoras.core.dominio.Computadora;
import ar.edu.undec.computadoras.core.excepcion.ComputadoraIncompletaException;
import ar.edu.undec.computadoras.core.excepcion.UpdateComputadoraException;

public interface EditarCommputadoraInput {
    Computadora EditarComputadora(Computadora computadoraDatosNuevos) throws ComputadoraIncompletaException, UpdateComputadoraException;
}
