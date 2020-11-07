package ar.edu.undec.computadoras.core.repositorio;

import ar.edu.undec.computadoras.core.dominio.Computadora;

public interface IRepositorioConsultarComputadora {
    Computadora findByUsuario(String caracteristica);
}
