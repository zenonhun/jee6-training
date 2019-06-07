package hu.excgroup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig
        extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("ADMIN")
                .and()
                .withUser("user").password("{noop}user").roles("USER");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/pages/**").hasAnyRole("USER", "ADMIN")

                .antMatchers("/resources/**").permitAll()
                .antMatchers("/**").permitAll()

                .antMatchers("/login*", "/applogin").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/applogin")
                .loginPage("/login.jsf")
                .defaultSuccessUrl("/pages/main.jsf", true)
                .failureUrl("/login.jsf?login_error=1")
                .and()
                .logout().logoutSuccessUrl("/login.jsf");
    }
}
