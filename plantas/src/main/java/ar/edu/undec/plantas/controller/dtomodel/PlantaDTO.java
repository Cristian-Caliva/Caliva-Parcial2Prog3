package ar.edu.undec.plantas.controller.dtomodel;

public class PlantaDTO {
    private String nombreCientifico;
    private String nombreVulgar;
    private String categoria;
    private String epocaPlantado;
    private int alturaMaxima;

    public PlantaDTO(String nombreCientifico, String nombreVulgar, String categoria, String epocaPlantado, int alturaMaxima) {
        this.nombreCientifico = nombreCientifico;
        this.nombreVulgar = nombreVulgar;
        this.categoria = categoria;
        this.epocaPlantado = epocaPlantado;
        this.alturaMaxima = alturaMaxima;
    }
}
