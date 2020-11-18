package ar.edu.undec.computadoras.persistenceTest;

import ar.edu.undec.computadoras.core.dominio.Computadora;
import ar.edu.undec.computadoras.persistencia.CrearComputadoraRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CrearComputadoraDataTest {
    @Autowired
    CrearComputadoraRepoImpl crearComputadoraRepo;

    @Test
    public void testCreaMascota(){
        Computadora laComputadora=Computadora.instancia("I310401000GB16GB","Core I3 1040",1000,"SSD",16,"PC");
        boolean resultado = crearComputadoraRepo.guardarComputadora(laComputadora);
        Assertions.assertTrue(resultado);
    }
}
