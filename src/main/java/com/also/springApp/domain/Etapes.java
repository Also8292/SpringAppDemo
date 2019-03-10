package com.also.springApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "etapes")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Etapes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "nom", nullable = false)
    private String nom;

    @ManyToMany(mappedBy = "etapes")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Trajets> trajets = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Etapes nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Trajets> getTrajets() {
        return trajets;
    }

    public Etapes trajets(Set<Trajets> trajets) {
        this.trajets = trajets;
        return this;
    }

    public Etapes addTrajets(Trajets trajets) {
        this.trajets.add(trajets);
        trajets.getEtapes().add(this);
        return this;
    }

    public Etapes removeTrajet(Trajets trajets) {
        this.trajets.remove(trajets);
        trajets.getEtapes().remove(this);
        return this;
    }

    public void setTrajets(Set<Trajets> trajets) {
        this.trajets = trajets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etapes etapes = (Etapes) o;
        if(etapes.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), etapes.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Etapes{" +
                "id=" +getId() +
                ", nom='" + getNom() + "'" +
                "}";
    }
}
