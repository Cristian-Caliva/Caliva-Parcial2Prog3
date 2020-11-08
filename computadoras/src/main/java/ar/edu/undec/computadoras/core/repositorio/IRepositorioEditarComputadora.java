package ar.edu.undec.computadoras.core.repositorio;

import ar.edu.undec.computadoras.core.dominio.Computadora;

public interface IRepositorioEditarComputadora {
    boolean update(Computadora computadoraViejaModificar);
}
