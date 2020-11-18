package ar.edu.undec.plantas.persistencia;

import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.repositorio.ICrearPlantaRepositorio;
import ar.edu.undec.plantas.persistencia.crud.ICrearPlantaCRUD;
import ar.edu.undec.plantas.persistencia.entity.PlantaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearPlantaRepoImpl implements ICrearPlantaRepositorio {
    @Autowired
    ICrearPlantaCRUD iCrearPlantaCRUD;

    @Override
    public boolean existePlanta(String nombreCientifico) {
        return false;
    }

    @Override
    public boolean guardarPlanta(Planta laPlanta) {
        PlantaEntity plantaDB = new PlantaEntity();
        plantaDB.setNombreCientifico(laPlanta.getNombreCientifico());
        plantaDB.setAlturaMaxima(laPlanta.getAlturaMaxima());
        plantaDB.setCategoria(laPlanta.getCategoria());
        plantaDB.setEpocaPlantado(laPlanta.getEpocaPlantado());
        plantaDB.setNombreVulgar(laPlanta.getNombreVulgar());
        return this.iCrearPlantaCRUD.save(plantaDB).getIdPlanta()!=null;
    }
}
