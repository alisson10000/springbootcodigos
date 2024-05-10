package com.spring.aulaDez.secutity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.spring.aulaDez.service.ImplementacaoUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity  extends WebSecurityConfigurerAdapter{

	/* Mapeia URL , enderecos, autoriza ou bloqueia acesso a URL*/
	
	@Autowired
	private ImplementacaoUserDetailsService implementacaoUserDetailsService;
	
	
	/* Configura as solicitações de acesso por http */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/* Ativando a proteção contra usuarios que não estão validados por Token */
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
	    .and()
	    .authorizeRequests()
	        .antMatchers("/", "/index").permitAll() // Permite acesso à página inicial do sistema ex: 
	        .anyRequest().authenticated() // Todas as outras requisições precisam de autenticação
	    .and()
	    .logout()
	        .logoutSuccessUrl("/index") // Define a URL de sucesso de logout
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")); // Mapeia a URL de logout e invalida o usuário

		
		/* Filtra a requisições de login para autenticação*/
		
		/*Filtra demais requisiçõa para verificar as requisições do JWT */
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		/* Service que irá consultar o usuario no banco de dados*/
		auth.userDetailsService(implementacaoUserDetailsService)
		
		/* Padrão de configuração de senha do usuário */
		.passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
	
	
}
