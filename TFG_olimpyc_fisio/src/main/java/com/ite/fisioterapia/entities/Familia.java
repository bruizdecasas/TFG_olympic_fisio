package com.ite.fisioterapia.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


/**
 * The persistent class for the familias database table.
 * 
 */
@Entity
@Table(name="familias")
@NamedQuery(name="Familia.findAll", query="SELECT f FROM Familia f")
public class Familia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_familia")
	private int idFamilia;

	@Column(name="descripcion_familia")
	private String descripcionFamilia;

	@Column(name="nombre_familia")
	private String nombreFamilia;

	public Familia() {
	}

	public Familia(int idFamilia, String descripcionFamilia, String nombreFamilia) {
		super();
		this.idFamilia = idFamilia;
		this.descripcionFamilia = descripcionFamilia;
		this.nombreFamilia = nombreFamilia;
	}

	public int getIdFamilia() {
		return this.idFamilia;
	}

	public void setIdFamilia(int idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getDescripcionFamilia() {
		return this.descripcionFamilia;
	}

	public void setDescripcionFamilia(String descripcionFamilia) {
		this.descripcionFamilia = descripcionFamilia;
	}

	public String getNombreFamilia() {
		return this.nombreFamilia;
	}

	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idFamilia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Familia))
			return false;
		Familia other = (Familia) obj;
		return idFamilia == other.idFamilia;
	}

	@Override
	public String toString() {
		return "Familia [idFamilia=" + idFamilia + ", descripcionFamilia=" + descripcionFamilia + ", nombreFamilia="
				+ nombreFamilia + "]";
	}

}