package ar.edu.undec.computadoras.usecaseUnitTest;

import ar.edu.undec.computadoras.core.dominio.Computadora;
import ar.edu.undec.computadoras.core.excepcion.ComputadoraIncompletaException;
import ar.edu.undec.computadoras.core.excepcion.UpdateComputadoraException;
import ar.edu.undec.computadoras.core.repositorio.IRepositorioConsultarComputadoraPorCaracteristica;
import ar.edu.undec.computadoras.core.repositorio.IRepositorioEditarComputadora;
import ar.edu.undec.computadoras.core.usecase.EditarComputadoraUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EditarComputadoraUseCaseUnitTest {
    @Mock
    IRepositorioEditarComputadora iRepositorioEditarComputadora;

    @Mock
    IRepositorioConsultarComputadoraPorCaracteristica iRepositorioConsultarComputadoraPorCaracteristica;

    @Test
    public void editarComputadora_datosCorrectos_devuelveComputadoraModificada() throws ComputadoraIncompletaException, UpdateComputadoraException {
        Computadora computadoraViejaModificar = Computadora.instancia("I310401000GB16GB","Core I3 1040",1000,"SSD",16,"PC");
        Computadora computadoraNueva = Computadora.instancia("I310401000GB16GB", "Core I3 1040", 2000, "SSD", 32, "PC");

        when(iRepositorioConsultarComputadoraPorCaracteristica.findByCaractesiticaComputadora("I310401000GB16GB")).thenReturn(computadoraViejaModificar);
        when(iRepositorioEditarComputadora.update(computadoraViejaModificar)).thenReturn(true);

        EditarComputadoraUseCase editarComputadoraUseCase = new EditarComputadoraUseCase(iRepositorioEditarComputadora, iRepositorioConsultarComputadoraPorCaracteristica);

        Computadora computadora = editarComputadoraUseCase.EditarComputadora(computadoraNueva);
        Assertions.assertEquals(2000,computadora.getTamanioDisco());
        Assertions.assertEquals(32,computadora.getRam());
        Assertions.assertEquals("I310401000GB16GB",computadora.getCaracteristica());
    }

}
