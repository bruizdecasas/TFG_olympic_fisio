package com.ite.fisioterapia.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


/**
 * The persistent class for the reservas database table.
 * 
 */
@Entity
@Table(name="reservas")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reserva")
	private int idReserva;

	@Column(name="observaciones_resevas")
	private String observacionesResevas;

	//uni-directional many-to-one association to Cita
	@ManyToOne
	@JoinColumn(name="id_cita")
	private Cita cita;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Reserva() {
	}

	public Reserva(int idReserva, String observacionesResevas, Cita cita, Usuario usuario) {
		super();
		this.idReserva = idReserva;
		this.observacionesResevas = observacionesResevas;
		this.cita = cita;
		this.usuario = usuario;
	}

	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getObservacionesResevas() {
		return this.observacionesResevas;
	}

	public void setObservacionesResevas(String observacionesResevas) {
		this.observacionesResevas = observacionesResevas;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idReserva);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Reserva))
			return false;
		Reserva other = (Reserva) obj;
		return idReserva == other.idReserva;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", observacionesResevas=" + observacionesResevas + ", cita=" + cita
				+ ", usuario=" + usuario + "]";
	}

}