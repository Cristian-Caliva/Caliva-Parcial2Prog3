package ar.edu.undec.plantas.persistencia.crud;

import ar.edu.undec.plantas.persistencia.entity.PlantaEntity;
import org.springframework.data.repository.CrudRepository;

public interface IConsultarPlantasCRUD extends CrudRepository<PlantaEntity, Integer> {

}
