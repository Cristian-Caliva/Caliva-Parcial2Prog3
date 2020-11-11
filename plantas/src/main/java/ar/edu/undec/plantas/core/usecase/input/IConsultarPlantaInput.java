package ar.edu.undec.plantas.core.usecase.input;

import ar.edu.undec.plantas.core.dominio.Planta;

import java.util.Collection;

public interface IConsultarPlantaInput {
    Collection<Planta> consultarPlantas();
}
