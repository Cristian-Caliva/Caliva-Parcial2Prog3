package ar.edu.undec.plantas.controller.dtomodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlantaDTO {
    @JsonProperty("nombreCientifico")
    private String nombreCientifico;
    @JsonProperty("nombreVulgar")
    private String nombreVulgar;
    @JsonProperty("categoria")
    private String categoria;
    @JsonProperty("epocaPlantado")
    private String epocaPlantado;
    @JsonProperty("alturaMaxima")
    private int alturaMaxima;

    public PlantaDTO(@JsonProperty("nombreCientifico")String nombreCientifico,
                     @JsonProperty("nombreVulgar")String nombreVulgar,
                     @JsonProperty("categoria")String categoria,
                     @JsonProperty("epocaPlantado")String epocaPlantado,
                     @JsonProperty("alturaMaxima")int alturaMaxima) {
        this.nombreCientifico = nombreCientifico;
        this.nombreVulgar = nombreVulgar;
        this.categoria = categoria;
        this.epocaPlantado = epocaPlantado;
        this.alturaMaxima = alturaMaxima;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public String getNombreVulgar() {
        return nombreVulgar;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEpocaPlantado() {
        return epocaPlantado;
    }

    public int getAlturaMaxima() {
        return alturaMaxima;
    }
}
