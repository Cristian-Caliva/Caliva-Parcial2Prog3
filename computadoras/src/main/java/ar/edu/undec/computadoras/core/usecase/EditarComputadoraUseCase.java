package ar.edu.undec.computadoras.core.usecase;

import ar.edu.undec.computadoras.core.dominio.Computadora;
import ar.edu.undec.computadoras.core.excepcion.ComputadoraIncompletaException;
import ar.edu.undec.computadoras.core.excepcion.UpdateComputadoraException;
import ar.edu.undec.computadoras.core.input.EditarComputadoraInput;
import ar.edu.undec.computadoras.core.repositorio.IRepositorioConsultarComputadoraPorCaracteristica;
import ar.edu.undec.computadoras.core.repositorio.IRepositorioEditarComputadora;

public class EditarComputadoraUseCase implements EditarComputadoraInput {
    private IRepositorioEditarComputadora iRepositorioEditarComputadora;
    private IRepositorioConsultarComputadoraPorCaracteristica iRepositorioConsultarComputadoraPorCaracteristica;

    public EditarComputadoraUseCase(IRepositorioEditarComputadora iRepositorioEditarComputadora, IRepositorioConsultarComputadoraPorCaracteristica iRepositorioConsultarComputadoraPorCaracteristica) {
        this.iRepositorioConsultarComputadoraPorCaracteristica = iRepositorioConsultarComputadoraPorCaracteristica;
        this.iRepositorioEditarComputadora = iRepositorioEditarComputadora;
    }

    @Override
    public Computadora EditarComputadora(Computadora computadoraDatosNuevos) throws ComputadoraIncompletaException, UpdateComputadoraException {

        Computadora computadoraAModificar = iRepositorioConsultarComputadoraPorCaracteristica.findByCaractesiticaComputadora(computadoraDatosNuevos.getCaracteristica());
        computadoraAModificar.modificarDatos(computadoraDatosNuevos);

        if(iRepositorioEditarComputadora.update(computadoraAModificar)){
            return computadoraAModificar;
        }else{
            throw new UpdateComputadoraException();
        }
    }

}
