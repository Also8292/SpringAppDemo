package com.also.springApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trajets")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Trajets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "depart")
    private String depart;

    @Size(max = 50)
    @Column(name = "arrivee")
    private String arrivee;

    @Column(name = "nbre_places")
    private Integer nombrePlaces;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "dateFin")
    private LocalDate dateFin;

    @Column(name = "heure")
    private String heure;

    @ManyToOne
    @JsonIgnoreProperties("trajets")
    private Users conducteur;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "trajet_etape",
                joinColumns = @JoinColumn(name = "trajet_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "etape_id", referencedColumnName = "id"))
    private Set<Etapes> etapes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public Integer getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(Integer nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Users getConducteur() {
        return conducteur;
    }

    public void setConducteur(Users conducteur) {
        this.conducteur = conducteur;
    }

    public Set<Etapes> getEtapes() {
        return etapes;
    }

    public Trajets etapes(Set<Etapes> etapes) {
        this.etapes = etapes;
        return  this;
    }

    public Trajets addEtapes(Etapes etapes) {
        this.etapes.add(etapes);
        etapes.getTrajets().add(this);
        return this;
    }

    public Trajets removeEtapes(Etapes etapes) {
        this.etapes.remove(etapes);
        etapes.getTrajets().remove(this);
        return this;
    }

    public void setEtapes(Set<Etapes> etapes) {
        this.etapes = etapes;
    }
}
