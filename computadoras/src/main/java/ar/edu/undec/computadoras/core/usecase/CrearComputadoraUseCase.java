package ar.edu.undec.computadoras.core.usecase;

import ar.edu.undec.computadoras.core.dominio.Computadora;
import ar.edu.undec.computadoras.core.input.ICrearCommputadoraInput;
import ar.edu.undec.computadoras.core.repositorio.IComputadoraRepositorio;

public class CrearComputadoraUseCase implements ICrearCommputadoraInput {
    private IComputadoraRepositorio iComputadoraRepositorio;
    public CrearComputadoraUseCase(IComputadoraRepositorio computadoraRepositorio) {
        this.iComputadoraRepositorio = computadoraRepositorio;
    }

    public boolean crearComputadora(Computadora laComputadora) {
        if(iComputadoraRepositorio.existeComputadora(laComputadora.getCaracteristica())) {
            return false;
        }
        else {
            iComputadoraRepositorio.guardarComputadora(laComputadora);
            return true;
        }
    }
}
