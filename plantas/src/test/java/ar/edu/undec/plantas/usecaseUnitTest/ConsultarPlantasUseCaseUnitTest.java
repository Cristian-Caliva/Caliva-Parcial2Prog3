package ar.edu.undec.plantas.usecaseUnitTest;

import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.exception.PlantaIncompletaException;
import ar.edu.undec.plantas.core.repositorio.IConsultarPlantasRepositorio;
import ar.edu.undec.plantas.core.usecase.ConsultarPlantasUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarPlantasUseCaseUnitTest {


    @Mock
    IConsultarPlantasRepositorio consultarPlantasRepositorio;

    @Test
    void consultarPlantas_ExistenPlantas_DevuelveColeccionConDatos() throws PlantaIncompletaException {
        ConsultarPlantasUseCase consultarPlantasUseCase=new ConsultarPlantasUseCase(consultarPlantasRepositorio);
        when(consultarPlantasRepositorio.obtenerPlantas()).thenReturn(Collections.singletonList(Planta.instancia("Erythrina crista-galli","Ceibo","Faboideae","Primavera",10)));
        Assertions.assertFalse(consultarPlantasUseCase.consultarPlantas().isEmpty());
    }

    @Test
    void consultarPlantas_NoExistenPlantas_DevuelveColeccionVacia(){
        ConsultarPlantasUseCase consultarPlantasUseCase = new ConsultarPlantasUseCase(consultarPlantasRepositorio);
        when(consultarPlantasUseCase.consultarPlantas()).thenReturn(new ArrayList<>());

        Collection<Planta> plantaList = consultarPlantasUseCase.consultarPlantas();

        Assertions.assertEquals(0, plantaList.size());
    }
}
