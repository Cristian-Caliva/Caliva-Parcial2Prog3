package ar.edu.undec.computadoras.core.dominio;

import ar.edu.undec.computadoras.core.excepcion.ComputadoraExisteException;

public class Computadora {
    private String caracteristica;
    private String procesador;
    private int tamanioDisco;
    private String tipoDisco;
    private int ram;
    private String tipoComputadora;

    public Computadora(String caracteristica, String procesador, int tamanioDisco, String tipoDisco, int ram, String tipoComputadora) {
        this.caracteristica = caracteristica;
        this.procesador = procesador;
        this.tamanioDisco = tamanioDisco;
        this.tipoDisco = tipoDisco;
        this.ram = ram;
        this.tipoComputadora = tipoComputadora;
    }

    public static Computadora instancia(String caracteristicas, String procesador, int tamanioDisco, String tipoDisco, int ram, String tipoComputadora) throws ComputadoraExisteException {
        return new Computadora(caracteristicas, procesador, tamanioDisco, tipoDisco, ram, tipoComputadora);
    }

    public String getCaracteristica() {
        return caracteristica;
    }
}
