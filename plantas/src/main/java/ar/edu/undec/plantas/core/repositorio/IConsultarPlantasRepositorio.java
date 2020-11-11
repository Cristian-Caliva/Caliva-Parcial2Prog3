package ar.edu.undec.plantas.core.repositorio;

import ar.edu.undec.plantas.core.dominio.Planta;

import java.util.Collection;

public interface IConsultarPlantasRepositorio {
    //Collection<Planta> ob();

    Collection<Planta> obtenerPlantas();
}
