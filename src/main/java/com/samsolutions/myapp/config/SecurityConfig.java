package com.samsolutions.myapp.config;


import com.samsolutions.myapp.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan("com.samsolutions.myapp")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}


	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(getUserDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		// включаем защиту от CSRF атак

               http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("//addUser").permitAll()
			.antMatchers("/doRegister").permitAll()
			.antMatchers("/register").permitAll()
			.antMatchers("/user_details").permitAll()
			.antMatchers("/userDetails").permitAll()
			.antMatchers("/activate_account/*").permitAll()
			.antMatchers("/after_activation_page").permitAll()
			.anyRequest().authenticated()
			.and()

		.formLogin()
				// указываем страницу с формой логина
				.loginPage("/login")
				// указываем action с формы логина
				.usernameParameter("j_username")
				.passwordParameter("j_password")
				.loginProcessingUrl("/j_spring_security_check")

				// указываем URL при неудачном логине
				.failureUrl("/login?error=true")
				// Указываем параметры логина и пароля с формы логина
				.defaultSuccessUrl("/", true)
				// даем доступ к форме логина всем
				.permitAll();

		http.logout()
				// разрешаем делать логаут всем
				.permitAll()
				// указываем URL логаута
				.logoutUrl("/logout")
				// указываем URL при удачном логауте
				.logoutSuccessUrl("/")
				// делаем не валидной текущую сессию
				.invalidateHttpSession(true);

	}


	@Bean
	public UserDetailsService getUserDetailsService(){
		return new UserDetailsServiceImpl();
	}
}


