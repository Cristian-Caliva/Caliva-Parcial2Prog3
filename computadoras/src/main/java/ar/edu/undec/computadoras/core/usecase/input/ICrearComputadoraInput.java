package ar.edu.undec.computadoras.core.usecase.input;

import ar.edu.undec.computadoras.core.dominio.Computadora;
import ar.edu.undec.computadoras.core.excepcion.ComputadoraExisteException;

public interface ICrearComputadoraInput {
    boolean crearComputadora(Computadora laComputadora) throws ComputadoraExisteException;
}
