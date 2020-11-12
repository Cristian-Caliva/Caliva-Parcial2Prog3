package ar.edu.undec.plantas.config;

import ar.edu.undec.plantas.core.usecase.ConsultarPlantasUseCase;
import ar.edu.undec.plantas.core.usecase.CrearPlantaUseCase;
import ar.edu.undec.plantas.persistencia.ConsultarPlantaRepoImpl;
import ar.edu.undec.plantas.persistencia.CrearPlantaRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Autowired
    CrearPlantaRepoImpl crearPlantaRepo;

    @Autowired
    ConsultarPlantaRepoImpl consultarPlantaRepo;

    @Bean
    public CrearPlantaUseCase crearPlantaUseCase(){
        return new CrearPlantaUseCase(crearPlantaRepo);
    }

    @Bean
    public ConsultarPlantasUseCase consultarPlantasUseCase() {
        return new ConsultarPlantasUseCase(consultarPlantaRepo);}

}
