package ar.edu.undec.computadoras.core.dominio;

import ar.edu.undec.computadoras.core.excepcion.ComputadoraExisteException;
import ar.edu.undec.computadoras.core.excepcion.ComputadoraIncompletaException;

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

    public static Computadora instancia(String caracteristicas, String procesador, int tamanioDisco, String tipoDisco, int ram, String tipoComputadora) /*throws ComputadoraIncompletaException*/ {
        /*if(caracteristicas.isEmpty() || procesador.isEmpty() || tamanioDisco < 0 || tipoDisco.isEmpty() || ram < 0 || tipoComputadora.isEmpty()) {
            throw new ComputadoraIncompletaException();
        }*/
        return new Computadora(caracteristicas, procesador, tamanioDisco, tipoDisco, ram, tipoComputadora);
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public String getProcesador() {
        return procesador;
    }

    public int getTamanioDisco() {
        return tamanioDisco;
    }

    public String getTipoDisco() {
        return tipoDisco;
    }

    public int getRam() {
        return ram;
    }

    public String getTipoComputadora() {
        return tipoComputadora;
    }

    public void modificarDatos(Computadora computadoraDatosNuevos) {
        this.caracteristica = computadoraDatosNuevos.getCaracteristica();
        this.procesador = computadoraDatosNuevos.getProcesador();
        this.tipoComputadora = computadoraDatosNuevos.getTipoComputadora();
        this.ram = computadoraDatosNuevos.getRam();
        this.tipoDisco = computadoraDatosNuevos.getTipoDisco();
        this.tamanioDisco = computadoraDatosNuevos.getTamanioDisco();
    }
}
