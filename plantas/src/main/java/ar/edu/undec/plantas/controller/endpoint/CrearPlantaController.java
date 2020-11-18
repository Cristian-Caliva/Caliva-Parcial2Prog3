package ar.edu.undec.plantas.controller.endpoint;

import ar.edu.undec.plantas.controller.dtomodel.PlantaDTO;
import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.exception.PlantaExisteException;
import ar.edu.undec.plantas.core.exception.PlantaIncompletaException;
import ar.edu.undec.plantas.core.usecase.input.ICrearPlantaInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/vivero")

public class CrearPlantaController {

    @Autowired
    ICrearPlantaInput crearPlantaInput;
    /*public CrearComputadoraController(ICrearPlantaInputInput ) {
        this.iCrearComputadoraInput=crearComputadoraInput;
    }*/

    @PostMapping(value = "/plantas")
    public ResponseEntity<?> crearPlanta(@RequestBody PlantaDTO laPlanta) throws PlantaIncompletaException {

        Planta plantaCore = Planta.instancia(laPlanta.getNombreCientifico(), laPlanta.getNombreVulgar(),
                laPlanta.getCategoria(), laPlanta.getEpocaPlantado(), laPlanta.getAlturaMaxima());

        try {
            boolean resultado = crearPlantaInput.crearPlanta(plantaCore);
            return ResponseEntity.status(HttpStatus.OK).body(resultado);
        } catch (PlantaExisteException existeLaPlanta) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(existeLaPlanta.getMessage());
        }

        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("sorry, error interno");
        }

    }
}
