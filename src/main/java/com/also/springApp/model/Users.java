package com.also.springApp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.also.springApp.model.enumeration.Sexe;
import com.also.springApp.model.enumeration.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author also
 *
 *User entity
 */

@Entity
@Table(name = "users")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email
	@NotNull
    @Size(min = 5, max = 254)
    @Column(length = 254, unique = true)
    private String email;
	
	@JsonIgnore
    @Size(min = 60, max = 512)
    @Column(name = "password", length = 128)
    private String password;
	
	@Size(max = 50)
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    private String lastName;
    
    @Column(name = "telephone")
    private String telephone;

    @Column(name = "address")
    private String adresse;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "type_user")
    private UserType typeUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexe")
    private Sexe sexe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public UserType getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(UserType typeUser) {
		this.typeUser = typeUser;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hashCode(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Users user = (Users) obj;
        return !(user.getId() == null || getId() == null) && Objects.equals(getId(), user.getId());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User{" + 
				"id=" + getId() +
				", firstName=" + getFirstName() + "'" +
				", lastName=" + getLastName() + "'" +
				", sexe=" + getSexe() + "'" +
				", typeUtilisateur" + getTypeUser() + "'" +
				", address=" + getAdresse() +
				", telephone=" + getTelephone() + "'" +
				", password=" + getPassword() + "'" +
				"}";
	}
    
    
    
    
    
}
