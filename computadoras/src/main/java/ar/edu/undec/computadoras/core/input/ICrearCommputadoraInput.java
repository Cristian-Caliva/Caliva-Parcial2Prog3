package ar.edu.undec.computadoras.core.input;

import ar.edu.undec.computadoras.core.dominio.Computadora;
import ar.edu.undec.computadoras.core.excepcion.ComputadoraExisteException;

public interface ICrearCommputadoraInput{
    boolean crearComputadora(Computadora laComputadora) throws ComputadoraExisteException;
}
