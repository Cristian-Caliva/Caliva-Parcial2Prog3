package ar.edu.undec.plantas.core.usecase;

import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.exception.PlantaExisteException;
import ar.edu.undec.plantas.core.repositorio.ICrearPlantaRepositorio;
import ar.edu.undec.plantas.core.usecase.input.ICrearPlantaInput;

public class CrearPlantaUseCase implements ICrearPlantaInput {
    private ICrearPlantaRepositorio iCrearPlantaRepositorio;

    public CrearPlantaUseCase(ICrearPlantaRepositorio crearPlantaRepositorio) {
        this.iCrearPlantaRepositorio = crearPlantaRepositorio;
    }

    @Override
    public boolean crearPlanta(Planta laPlanta) throws PlantaExisteException {
        if(iCrearPlantaRepositorio.existePlanta(laPlanta.getNombreCientifico())) {
            return false;
        }
        else {
            iCrearPlantaRepositorio.guardarPlanta(laPlanta);
            return true;
        }
    }
}
