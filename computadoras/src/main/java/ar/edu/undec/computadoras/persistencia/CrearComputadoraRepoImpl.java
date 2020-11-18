package ar.edu.undec.computadoras.persistencia;

import ar.edu.undec.computadoras.core.dominio.Computadora;
import ar.edu.undec.computadoras.core.repositorio.IComputadoraRepositorio;
import ar.edu.undec.computadoras.persistencia.crud.ICrearComputadoraCRUD;
import ar.edu.undec.computadoras.persistencia.entity.ComputadoraEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearComputadoraRepoImpl implements IComputadoraRepositorio {
    @Autowired
    ICrearComputadoraCRUD iCrearComputadoraCRUD;
    @Override
    public boolean existeComputadora(String i310401000GB16GB) {
        return false;
    }

    @Override
    public boolean guardarComputadora(Computadora laComputadora) {
        ComputadoraEntity computadoraDB = new ComputadoraEntity();
        computadoraDB.setCaracteristica(laComputadora.getCaracteristica());
        computadoraDB.setProcesador(laComputadora.getProcesador());
        computadoraDB.setRam(laComputadora.getRam());
        computadoraDB.setTamanioDisco(laComputadora.getTamanioDisco());
        computadoraDB.setTipoComputadora(laComputadora.getTipoComputadora());
        computadoraDB.setTipoDisco(laComputadora.getTipoDisco());
        return this.iCrearComputadoraCRUD.save(computadoraDB).getIdComputadora()!=null;
    }
}
