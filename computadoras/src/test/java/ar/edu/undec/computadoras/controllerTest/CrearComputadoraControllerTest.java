package ar.edu.undec.computadoras.controllerTest;

import ar.edu.undec.computadoras.controller.dtomodel.ComputadoraDTO;
import ar.edu.undec.computadoras.controller.endpoint.CrearComputadoraController;
import ar.edu.undec.computadoras.core.dominio.Computadora;
import ar.edu.undec.computadoras.core.excepcion.ComputadoraExisteException;
import ar.edu.undec.computadoras.core.usecase.input.ICrearComputadoraInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CrearComputadoraControllerTest {
    @Mock
    private ICrearComputadoraInput crearComputadoraInput;

    @Test
    public void crearComputadora_ComputadoraNoExiste_Devuelve200() throws ComputadoraExisteException/*, ComputadoraIncompletaException*/ {
        ComputadoraDTO laComputadoraDTO=new ComputadoraDTO("I310401000GB16GB","Core I3 1040",1000,"SSD",16,"PC");
        when(crearComputadoraInput.crearComputadora(any(Computadora.class))).thenReturn(true);

        CrearComputadoraController crearComputadoraController = new CrearComputadoraController(crearComputadoraInput);
        ResponseEntity responseEntity = crearComputadoraController.crearComputadora(laComputadoraDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearComputadora_ComputadoraExisteException_Devuelve412() throws ComputadoraExisteException {
        //Completar Test
        ComputadoraDTO laComputadoraDTO=new ComputadoraDTO("I310401000GB16GB","Core I3 1040",1000,"SSD",16,"PC");
        when(crearComputadoraInput.crearComputadora(any(Computadora.class))).thenThrow(ComputadoraExisteException.class);

        CrearComputadoraController crearComputadoraController = new CrearComputadoraController(crearComputadoraInput);
        ResponseEntity responseEntity = crearComputadoraController.crearComputadora(laComputadoraDTO);



        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

    @Test
    public void crearComputadora_ExcepcionNoPrevista_Devuelve500() throws ComputadoraExisteException /*ComputadoraIncompletaException*/ {
        ComputadoraDTO laComputadoraDTO=new ComputadoraDTO("I310401000GB16GB","Core I3 1040",1000,"SSD",16,"PC");
        when(crearComputadoraInput.crearComputadora(any(Computadora.class))).thenThrow(new RuntimeException("Exception"));

        CrearComputadoraController crearComputadoraController = new CrearComputadoraController(crearComputadoraInput);
        ResponseEntity responseEntity = crearComputadoraController.crearComputadora(laComputadoraDTO);



        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }
}
