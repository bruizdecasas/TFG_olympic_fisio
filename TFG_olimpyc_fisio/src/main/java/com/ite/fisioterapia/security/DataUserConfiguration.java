package com.ite.fisioterapia.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class DataUserConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private LoginHandler loginHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth
			.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select email_usuario, Password , enabled from Usuarios where email_usuario=?")
			.authoritiesByUsernameQuery("select u.email_usuario, r.nombre_rol from Usuarios u " + " inner join Roles r on r.id_rol = u.id_rol " +  "where u.email_usuario = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			// Los directorios estáticos no requieren autenticacion
			.antMatchers("/bootstrap/**",  "/images/**", "/css/**", "js/**").permitAll()
			
			// Las vistas públicas no requieren autenticación
			.antMatchers("/").permitAll()
			.antMatchers("/index").permitAll() 
			.antMatchers("/productos/todos").permitAll()
			.antMatchers("/productos/detalle/**").permitAll()
			.antMatchers("/usuarios/registro/cliente").permitAll()
			.antMatchers("/usuarios/alta/cliente").permitAll()
			.antMatchers("/pedidos/addCarrito/**").permitAll()
			.antMatchers("/usuarios/registro/direccion").hasAnyAuthority("Cliente")
			.antMatchers("/usuarios/registro/tarjeta").hasAnyAuthority("Cliente")
			.antMatchers("/usuarios/registro/administrador").hasAnyAuthority("Administrador")
			
			.antMatchers("/usuarios/clientes**").hasAnyAuthority("Administrador")
			.antMatchers("/productos/eliminar/**").hasAnyAuthority("Administrador")
			.antMatchers("/productos/modificar/**").hasAnyAuthority("Administrador")
			.antMatchers("/logout").hasAnyAuthority("Administrador","Cliente")
			
			// Todas las demás URLs de la Aplicación requieren autenticación
			.anyRequest().authenticated()
			// El formulario de Login no requiere autenticacion
			.and().formLogin().permitAll().successHandler(loginHandler)
			// El formulario de logout no requiere autenticacion
	//		.and().logout().permitAll()
			;
			
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	

}

	

