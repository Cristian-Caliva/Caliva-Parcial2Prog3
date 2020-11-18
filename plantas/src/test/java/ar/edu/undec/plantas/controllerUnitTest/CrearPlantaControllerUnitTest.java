package ar.edu.undec.plantas.controllerUnitTest;

//import ar.edu.undec.plantas.controller.dto.PlantaDTO;
import ar.edu.undec.plantas.controller.dtomodel.PlantaDTO;
import ar.edu.undec.plantas.controller.endpoint.CrearPlantaController;
import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.exception.PlantaExisteException;
import ar.edu.undec.plantas.core.exception.PlantaIncompletaException;
import ar.edu.undec.plantas.core.usecase.input.ICrearPlantaInput;
import org.junit.jupiter.api.Assertions;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CrearPlantaControllerUnitTest {
    @Mock
    private ICrearPlantaInput iCrearPlantaInput;


    @Test
    public void crearPlanta_PlantaNoExiste_Devuelve200() throws PlantaExisteException, PlantaIncompletaException {
        PlantaDTO laPlantaDTO=new PlantaDTO("Erythrina crista-galli","Ceibo","Faboideae","Primavera",10);
        when(iCrearPlantaInput.crearPlanta(any(Planta.class))).thenReturn(true);

        CrearPlantaController crearPlantaController = new CrearPlantaController(iCrearPlantaInput);
        ResponseEntity responseEntity = crearPlantaController.crearPlanta(laPlantaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearPlanta_PlantaExisteException_Devuelve412() throws PlantaExisteException, PlantaIncompletaException {
        //Completar Test
        PlantaDTO laPlantaDTO=new PlantaDTO("Erythrina crista-galli","Ceibo","Faboideae","Primavera",10);
        when(iCrearPlantaInput.crearPlanta(any(Planta.class))).thenThrow(PlantaExisteException.class);
        ResponseEntity responseEntity=null;


        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

    @Test
    public void crearPlanta_ExcepcionNoPrevista_Devuelve500() throws PlantaExisteException, PlantaIncompletaException {
        //Completar Test
        PlantaDTO laPlantaDTO=new PlantaDTO("Erythrina crista-galli","Ceibo","Faboideae","Primavera",10);
        when(iCrearPlantaInput.crearPlanta(any(Planta.class))).thenThrow(new RuntimeException("Exception"));


        CrearPlantaController crearPlantaController = new CrearPlantaController(iCrearPlantaInput);
        ResponseEntity responseEntity = crearPlantaController.crearPlanta(laPlantaDTO);
    }



}
