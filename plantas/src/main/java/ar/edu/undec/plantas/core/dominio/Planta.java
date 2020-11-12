package ar.edu.undec.plantas.core.dominio;

import ar.edu.undec.plantas.core.exception.PlantaIncompletaException;

public class Planta {
    private String nombreCientifico;
    private String nombreVulgar;
    private String categoria;
    private String epocaPlantado;
    private int alturaMaxima;

    public Planta(String nombreCientifico, String nombreVulgar, String categoria, String epocaPlantado, int alturaMaxima) {
        this.nombreCientifico = nombreCientifico;
        this.nombreVulgar = nombreVulgar;
        this.categoria = categoria;
        this.epocaPlantado = epocaPlantado;
        this.alturaMaxima = alturaMaxima;
    }

    public static Planta instancia(String nombreCientifico, String nombreVulgar, String categoria, String epocaPlantado, int alturaMaxima) throws PlantaIncompletaException {
        if(nombreCientifico.isEmpty() || nombreVulgar.isEmpty() || categoria.isEmpty() || epocaPlantado.isEmpty() || alturaMaxima < 0) {
            throw new PlantaIncompletaException();
        }
        return new Planta(nombreCientifico, nombreVulgar, categoria, epocaPlantado, alturaMaxima);

    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

}
