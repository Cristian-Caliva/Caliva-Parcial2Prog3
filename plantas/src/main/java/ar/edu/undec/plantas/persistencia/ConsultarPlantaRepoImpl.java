package ar.edu.undec.plantas.persistencia;

import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.repositorio.IConsultarPlantasRepositorio;
import ar.edu.undec.plantas.persistencia.crud.IConsultarPlantasCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class ConsultarPlantaRepoImpl implements IConsultarPlantasRepositorio {
    @Autowired
    IConsultarPlantasCRUD consultarPlantasCRUD;

    @Override
    public Collection<Planta> obtenerPlantas() {
        Collection<Planta> plantaCollection = new ArrayList<>();
        consultarPlantasCRUD.findAll().forEach(plantaEntity ->
        {
            try {
                plantaCollection.add(Planta.instancia(plantaEntity.getNombre(),mascotaEntity.getRaza(),mascotaEntity.getFechaNacimiento()));
            } catch (MascotaIncompletaException e) {
                e.printStackTrace();
            }
        });
        return mascotaCollection;
    }
}
