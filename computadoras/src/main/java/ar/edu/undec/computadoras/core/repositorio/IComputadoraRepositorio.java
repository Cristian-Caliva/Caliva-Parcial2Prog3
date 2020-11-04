package ar.edu.undec.computadoras.core.repositorio;

import ar.edu.undec.computadoras.core.dominio.Computadora;

public interface IComputadoraRepositorio {
    boolean existeComputadora(String i310401000GB16GB);

    boolean guardarComputadora(Computadora laComputadora);
}
