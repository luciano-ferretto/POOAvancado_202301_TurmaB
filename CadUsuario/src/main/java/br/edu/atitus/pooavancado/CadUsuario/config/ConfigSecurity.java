package br.edu.atitus.pooavancado.CadUsuario.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.edu.atitus.pooavancado.CadUsuario.components.AuthTokenFilter;

@Configuration
public class ConfigSecurity {
	
	private final AuthTokenFilter authTokenFilter;
	public ConfigSecurity(AuthTokenFilter authTokenFilter) {
		super();
		this.authTokenFilter = authTokenFilter;
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager getAuthManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			//.httpBasic()
			//.and()
			.csrf(csrf -> csrf.disable())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/auth/**").permitAll()
					.anyRequest().authenticated()
					)
			.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}

}
