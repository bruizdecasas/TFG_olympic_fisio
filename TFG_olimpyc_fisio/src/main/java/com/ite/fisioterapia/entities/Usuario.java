package com.ite.fisioterapia.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;

	@Column(name="apellidos_usuario")
	private String apellidosUsuario;

	@Column(name="email_usuario")
	private String emailUsuario;

	private int enabled;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	private String password;

	@Column(name="sociedad_medica")
	private String sociedadMedica;

	private String telefono;

	//uni-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Rol rol;

	public Usuario() {
	}

	public Usuario(int idUsuario, String apellidosUsuario, String emailUsuario, int enabled, Date fechaNacimiento,
			String nombreUsuario, String password, String sociedadMedica, String telefono, Rol rol) {
		super();
		this.idUsuario = idUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.emailUsuario = emailUsuario;
		this.enabled = enabled;
		this.fechaNacimiento = fechaNacimiento;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.sociedadMedica = sociedadMedica;
		this.telefono = telefono;
		this.rol = rol;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidosUsuario() {
		return this.apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSociedadMedica() {
		return this.sociedadMedica;
	}

	public void setSociedadMedica(String sociedadMedica) {
		this.sociedadMedica = sociedadMedica;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		return idUsuario == other.idUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", apellidosUsuario=" + apellidosUsuario + ", emailUsuario="
				+ emailUsuario + ", enabled=" + enabled + ", fechaNacimiento=" + fechaNacimiento + ", nombreUsuario="
				+ nombreUsuario + ", password=" + password + ", sociedadMedica=" + sociedadMedica + ", telefono="
				+ telefono + ", rol=" + rol + "]";
	}

	
}