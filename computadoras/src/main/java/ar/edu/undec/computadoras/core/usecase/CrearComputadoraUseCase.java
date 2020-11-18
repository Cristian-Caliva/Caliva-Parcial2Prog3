package ar.edu.undec.computadoras.core.usecase;

import ar.edu.undec.computadoras.core.dominio.Computadora;
import ar.edu.undec.computadoras.core.excepcion.ComputadoraExisteException;
import ar.edu.undec.computadoras.core.repositorio.IComputadoraRepositorio;
import ar.edu.undec.computadoras.core.repositorio.IRepositorioConsultarComputadora;
import ar.edu.undec.computadoras.core.usecase.input.ICrearComputadoraInput;

//import ar.edu.undec.computadoras.core.usecase.input.ICrearCommputadoraInput;

public class CrearComputadoraUseCase implements ICrearComputadoraInput {
    private IComputadoraRepositorio iComputadoraRepositorio;
    private IRepositorioConsultarComputadora iRepositorioConsultarComputadora;

    public CrearComputadoraUseCase(IComputadoraRepositorio computadoraRepositorio) {
        this.iComputadoraRepositorio = computadoraRepositorio;
    }

    @Override
    public boolean crearComputadora(Computadora laComputadora) throws ComputadoraExisteException {
        if(iComputadoraRepositorio.existeComputadora(laComputadora.getCaracteristica())) {
            throw new ComputadoraExisteException();
        }
        else {
            iComputadoraRepositorio.guardarComputadora(laComputadora);
            return true;
        }
    }

    private boolean existeComputadora(String caracteristica) {
        if(this.iRepositorioConsultarComputadora.findByUsuario(caracteristica) != null){
            return true;
        }
        return false;
    }
}
