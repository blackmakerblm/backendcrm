 package org.nima.pack.security;
import org.nima.pack.service.UtilisateurDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class Security extends WebSecurityConfigurerAdapter {
	@Autowired
	private  PasswordEncoder passwordEncoder;//J'ai enlevé le constructeur parce que je vois pas l'interet apres l'injection avec autowired
	@Autowired
	private UtilisateurDetailServiceImpl utilisateurDetailService;
	@Autowired
	private MyAuthentrypoint unauthorizedHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS).and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/auth/**").permitAll()
		.antMatchers("/deco").permitAll()
		.antMatchers("/categorie/**").hasRole(UserRole.Admin.name())
		.antMatchers("/magasin/**").hasRole(UserRole.Admin.name())
		.antMatchers("/pack/**").hasRole(UserRole.Admin.name())
		.antMatchers("/utilisateurs").hasRole(UserRole.Admin.name())
		.antMatchers("/client/**").hasRole(UserRole.Commercial.name())
		.antMatchers("/commande/**").hasRole(UserRole.Commercial.name())
		.antMatchers("/facture/**").hasRole(UserRole.Commercial.name())
		.antMatchers("/composant/**").hasRole(UserRole.Commercial.name())
		.antMatchers("/bondesortie/**").hasRole(UserRole.Commercial.name())
		.antMatchers(HttpMethod.GET,"/produit/**").hasAuthority(UserPermission.PRODUIT_READ.name())
		.antMatchers(HttpMethod.POST,"/produit/**").hasAuthority(UserPermission.PRODUIT_CREATE.name())
		.anyRequest().authenticated().and()
		.formLogin()
		.loginPage("http://localhost:5555")
		.loginProcessingUrl("/login").permitAll();	
	}

	//cette methode meme si je l'enleve ellle sert à rien je dois comprendre plustard
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(utilisateurDetailService).passwordEncoder(passwordEncoder);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
	
	
	/*
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails commerciale = User
				.builder()
				.username("yacine")
				.password(passwordEncoder.encode("mdp"))
				.authorities(UserRole.Commercial.getGrantedAuthorities())
				.build();
		
		UserDetails admin = User
				.builder()
				.username("aliou")
				.password(passwordEncoder.encode("mdp"))
				.authorities(UserRole.Admin.getGrantedAuthorities())
				.build();
		UserDetails magasinier = User
				.builder()
				.username("diallo")
				.password(passwordEncoder.encode("mdp"))
				.authorities(UserRole.Magasinier.getGrantedAuthorities())
				.build();
		
		return new InMemoryUserDetailsManager(commerciale,
				admin,
				magasinier
				); 
				
	}*/

}
