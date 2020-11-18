package ar.edu.undec.plantas.persistenceTest;

import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.exception.PlantaIncompletaException;
import ar.edu.undec.plantas.persistencia.CrearPlantaRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CrearPlantaDataTest {
    @Autowired
    CrearPlantaRepoImpl crearPlantaRepo;

    @Test
    public void testCreaPlanta() throws PlantaIncompletaException {
        Planta laPlanta=Planta.instancia("Erythrina crista-galli","Ceibo","Faboideae","Primavera",10);
        boolean resultado = crearPlantaRepo.guardarPlanta(laPlanta);
        Assertions.assertTrue(resultado);

    }


}
