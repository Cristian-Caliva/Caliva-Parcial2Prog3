package ar.edu.undec.computadoras.controller.endpoint;

import ar.edu.undec.computadoras.controller.dtomodel.ComputadoraDTO;
//import ar.edu.undec.computadoras.core.usecase.input.ICrearCommputadoraInput;
import ar.edu.undec.computadoras.core.dominio.Computadora;
import ar.edu.undec.computadoras.core.excepcion.ComputadoraExisteException;
import ar.edu.undec.computadoras.core.usecase.input.ICrearComputadoraInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/informatica")
public class CrearComputadoraController {

    @Autowired
    ICrearComputadoraInput iCrearComputadoraInput;

    public CrearComputadoraController(ICrearComputadoraInput crearComputadoraInput) {
        this.iCrearComputadoraInput=crearComputadoraInput;
    }

    @PostMapping(value = "/computadoras")
    public ResponseEntity<?> crearComputadora(@RequestBody ComputadoraDTO laComputadora){
        Computadora computadoraCore = Computadora.instancia(laComputadora.getCaracteristica(),
                laComputadora.getProcesador(), laComputadora.getTamanioDisco(), laComputadora.getTipoDisco(),
                laComputadora.getRam(), laComputadora.getTipoComputadora());
        try {
            boolean resultado = iCrearComputadoraInput.crearComputadora(computadoraCore);
            return ResponseEntity.status(HttpStatus.OK).body(resultado);
        } catch (ComputadoraExisteException existeLaMascota) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(existeLaMascota.getMessage());
        }

        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("sorry, error interno");
        }
    }
}
