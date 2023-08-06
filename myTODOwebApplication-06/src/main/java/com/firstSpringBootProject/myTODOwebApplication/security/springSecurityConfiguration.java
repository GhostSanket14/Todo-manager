package com.firstSpringBootProject.myTODOwebApplication.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import static org.springframework.security.config.Customizer.withDefaults; // We made this static import.
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class springSecurityConfiguration {
// LDAP or Database
// we use in memory configurer.
	
//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(UserDetails... users)
//	
	 @Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	    	
	    	Function<String, String> encoder = input -> passwordEncoder().encode(input);
			
	    	UserDetails user = createNewUser(encoder, "Ghost", "123"); // i did refractor -> inline here
	    	UserDetails user1 = createNewUser(encoder, "Sanket", "1234"); 
	    	return new InMemoryUserDetailsManager(user,user1);
	    }

	private UserDetails createNewUser(Function<String, String> encoder, String username, String password) {
		UserDetails user = User.builder().passwordEncoder(
				encoder
				)
		    .username(username)
		    .password(password)
		    .roles("USER","ADMIN")
		    .build();
		return user;
	}
	    
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    } 
	    
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // We added this throws just to get rid of the error.
	    	http.authorizeHttpRequests(
	    	auth -> auth.anyRequest().authenticated());  // We made a lambed func here. to check if http request are authorised.

	    	http.formLogin(withDefaults()); // Here we enabled the login form with defaults. If there are unauthorised requests.
	    	
	    	http.csrf().disable(); // here we did this to enable the h2 console.
	    	http.headers().frameOptions().disable();
	    	
			return http.build();
	    }
	
}