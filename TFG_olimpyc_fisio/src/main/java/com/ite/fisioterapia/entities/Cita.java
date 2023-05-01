package com.ite.fisioterapia.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


/**
 * The persistent class for the citas database table.
 * 
 */
@Entity
@Table(name="citas")
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cita")
	private int idCita;

	private int disponible;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cita")
	private Date fechaCita;

	@Column(name="hora_cita")
	private String horaCita;

	private String observaciones;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="especialista")
	private Usuario usuario;

	public Cita() {
	}

	public Cita(int idCita, int disponible, Date fechaCita, String horaCita, String observaciones, Usuario usuario) {
		super();
		this.idCita = idCita;
		this.disponible = disponible;
		this.fechaCita = fechaCita;
		this.horaCita = horaCita;
		this.observaciones = observaciones;
		this.usuario = usuario;
	}

	public int getIdCita() {
		return this.idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public int getDisponible() {
		return this.disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public Date getFechaCita() {
		return this.fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getHoraCita() {
		return this.horaCita;
	}

	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCita);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cita))
			return false;
		Cita other = (Cita) obj;
		return idCita == other.idCita;
	}

	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", disponible=" + disponible + ", fechaCita=" + fechaCita + ", horaCita="
				+ horaCita + ", observaciones=" + observaciones + ", usuario=" + usuario + "]";
	}


}