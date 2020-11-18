package ar.edu.undec.computadoras.controller.dtomodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ComputadoraDTO {

    @JsonProperty("caracteristica")
    private String caracteristica;
    @JsonProperty("procesador")
    private String procesador;
    @JsonProperty("tamanioDisco")
    private int tamanioDisco;
    @JsonProperty("tipoDisco")
    private String tipoDisco;
    @JsonProperty("ram")
    private int ram;
    @JsonProperty("tipoComputadora")
    private String tipoComputadora;

    public ComputadoraDTO(@JsonProperty("caracteristica") String caracteristica,
                          @JsonProperty("procesador") String procesador,
                          @JsonProperty("tamanioDisco") int tamanioDisco,
                          @JsonProperty("tipoDisco") String tipoDisco,
                          @JsonProperty("ram") int ram,
                          @JsonProperty("tipoComputadora") String tipoComputadora) {
        this.caracteristica = caracteristica;
        this.procesador = procesador;
        this.tamanioDisco = tamanioDisco;
        this.tipoDisco = tipoDisco;
        this.ram = ram;
        this.tipoComputadora = tipoComputadora;
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
}
