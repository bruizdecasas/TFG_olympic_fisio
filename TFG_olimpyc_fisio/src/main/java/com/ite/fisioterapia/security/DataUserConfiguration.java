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
		// TODO Auto-generated method stub
		http
			.csrf().disable()
			.authorizeRequests()
			// Los directorios estáticos no requieren autenticacion
			.antMatchers("/bootstrap/**",  "/imagenes/**", "/css/**", "js/**").permitAll()
			.antMatchers("/rest/demo-bcrypt/**").permitAll()
			
			// Las vistas públicas no requieren autenticación
			.antMatchers("/", "/login", "/logout", "/search", "/user/verProducto/**","/comunes/listaProducto","/altausuario").permitAll()
			// Las autorizaciones sobre urls para ROLES
			.antMatchers("/jpa/producto/**").hasAnyAuthority("ROLE_USUARIO","ROLE_ADMIN")
			.antMatchers("/rest/producto/**").hasAnyAuthority("ROLE_USUARIO","ROLE_ADMIN")
			.antMatchers("/app/usuarios/**").hasAnyAuthority("ROLE_USUARIO","ROLE_ADMIN")
			.antMatchers("/app/perfiles/**").hasAnyAuthority("ROLE_ADMIN")
			.antMatchers("/app/tipos/**").hasAnyAuthority("ROLE_USUARIO")
			
			// Todas las demás URLs de la Aplicación requieren autenticación
			.anyRequest().authenticated()
			// El formulario de Login no requiere autenticacion
			.and().formLogin().permitAll()
			// El formulario de logout no requiere autenticacion
	//		.and().logout().permitAll()
			;
			
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	

}

	

