package ar.edu.undec.plantas.persistencia.entity;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "plantas_id_seq", initialValue = 1, sequenceName = "plantas_id_seq", allocationSize = 1)
public class PlantaEntity {
    @Id
    @Column(name = "idplanta")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plantas_id_seq")
    private Integer idPlanta;
    @Column(name = "nombrecientifico")
    private String nombreCientifico;
    @Column(name = "nombrevulgar")
    private String nombreVulgar;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "epocaplantado")
    private String epocaPlantado;
    @Column(name = "alturamaxima")
    private int alturaMaxima;

    public PlantaEntity() {
    }

    public Integer getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(Integer idPlanta) {
        this.idPlanta = idPlanta;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreVulgar() {
        return nombreVulgar;
    }

    public void setNombreVulgar(String nombreVulgar) {
        this.nombreVulgar = nombreVulgar;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEpocaPlantado() {
        return epocaPlantado;
    }

    public void setEpocaPlantado(String epocaPlantado) {
        this.epocaPlantado = epocaPlantado;
    }

    public int getAlturaMaxima() {
        return alturaMaxima;
    }

    public void setAlturaMaxima(int alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }
}
