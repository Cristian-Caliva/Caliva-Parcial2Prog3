package ar.edu.undec.computadoras.persistencia.entity;

import javax.persistence.*;

@Entity(name = "computadoras")
@SequenceGenerator(name = "computadoras_id_seq", initialValue = 1, sequenceName = "computadoras_id_seq", allocationSize = 1)
public class ComputadoraEntity {
    @Id
    @Column(name = "idmascota")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "computadoras_id_seq")
    private Integer idComputadora;
    @Column(name = "caracteristica")
    private String caracteristica;
    @Column(name = "procesador")
    private String procesador;
    @Column(name = "tamaniodisco")
    private int tamanioDisco;
    @Column(name = "tipodisco")
    private String tipoDisco;
    @Column(name = "ram")
    private int ram;
    @Column(name = "tipocomputadora")
    private String tipoComputadora;

    public ComputadoraEntity() {
    }

    public Integer getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(Integer idComputadora) {
        this.idComputadora = idComputadora;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public int getTamanioDisco() {
        return tamanioDisco;
    }

    public void setTamanioDisco(int tamanioDisco) {
        this.tamanioDisco = tamanioDisco;
    }

    public String getTipoDisco() {
        return tipoDisco;
    }

    public void setTipoDisco(String tipoDisco) {
        this.tipoDisco = tipoDisco;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getTipoComputadora() {
        return tipoComputadora;
    }

    public void setTipoComputadora(String tipoComputadora) {
        this.tipoComputadora = tipoComputadora;
    }
}
