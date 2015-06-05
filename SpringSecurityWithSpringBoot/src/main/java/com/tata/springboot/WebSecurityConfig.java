package com.tata.springboot;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
*
* @author Tatarao voleti
* @date   May 24, 2015
*/

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configurer(HttpSecurity security) throws Exception {

		security.authorizeRequests().antMatchers("/css/**").permitAll()
				.anyRequest().fullyAuthenticated().and().formLogin();
	}

	@Configuration
	protected static class AuthenticationConfiguration extends
			GlobalAuthenticationConfigurerAdapter {

		public void init(AuthenticationManagerBuilder builder) throws Exception {

			builder.ldapAuthentication().userDnPatterns("uid={0},ou=people").groupSearchBase("ou=groups")
					.contextSource().ldif("classpath:test-server.ldif");
		}
	}
}