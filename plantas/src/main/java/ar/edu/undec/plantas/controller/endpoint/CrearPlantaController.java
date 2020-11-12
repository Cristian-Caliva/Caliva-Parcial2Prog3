package ar.edu.undec.plantas.controller.endpoint;

import ar.edu.undec.plantas.controller.dtomodel.PlantaDTO;
import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.exception.PlantaIncompletaException;
import ar.edu.undec.plantas.core.usecase.input.ICrearPlantaInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/")
public class CrearPlantaController {

    @Autowired
    ICrearPlantaInput crearPlantaInput;
    @PostMapping(value = "/plantas")
    public ResponseEntity<?> crearPlanta(@RequestBody PlantaDTO laPlanta){

        Planta plantaCore = null;
        try {
            plantaCore = Planta.instancia(laPlanta.getNombreCientifico(), laPlanta.getNombreVulgar(), laPlanta.getCategoria(), laPlanta.getEpocaPlantado(), laPlanta.getAlturaMaxima());
        } catch (PlantaIncompletaException plantaIncompleta) {
            plantaIncompleta.getMessage();
        }

        try {
            boolean resultado=crearPlantaInput.crearPlanta(plantaCore);
            return ResponseEntity.status(HttpStatus.OK).body(resultado);
        } catch (MascotaIncompletaException mascotaIncompleta) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(mascotaIncompleta.getMessage());
        } catch (MascotaExisteException existeLaMascota) {
            return  ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(existeLaMascota.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Interno del Servidor");
        }


    }
}
