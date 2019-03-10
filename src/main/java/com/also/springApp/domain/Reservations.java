package com.also.springApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reservations")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("reservations")
    private Trajets trajet;

    @ManyToOne
    @JsonIgnoreProperties("reservations")
    private Users passager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trajets getTrajet() {
        return trajet;
    }

    public Reservations trajet(Trajets trajet) {
        this.trajet = trajet;
        return this;
    }

    public void setTrajet(Trajets trajet) {
        this.trajet = trajet;
    }

    public Users getPassager() {
        return passager;
    }

    public Reservations passager(Users passager) {
        this.passager = passager;
        return this;
    }

    public void setPassager(Users passager) {
        this.passager = passager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservations reservations = (Reservations) o;
        if(reservations.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), reservations.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" +getId() +
                ", trajet='" + getTrajet() + "'" +
                ", passager='" + getPassager() + "'" +
                "}";
    }

}
