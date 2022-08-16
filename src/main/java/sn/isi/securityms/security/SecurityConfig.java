package sn.isi.securityms.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sn.isi.securityms.security.filters.JwtAuthenticationFilter;
import sn.isi.securityms.security.filters.JwtAuthorizationFilter;
import sn.isi.securityms.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.csrf().disable();//pour les faille csrf
        http.headers().frameOptions().disable();//pour h2
        http.authorizeRequests().anyRequest().permitAll();*/

        http.csrf().disable();//pour les faille csrf
        //Pour la securite front
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //Pour la consultation de h2
        //http.headers().frameOptions().disable();//pour h2

        //pour angular
        http.cors().disable();

        http.authorizeRequests()
                .antMatchers("/refreshToken/**", "/login/**")
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**");//pour angular
        //Methode 1 pour la gestion des autorisations
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/users/**").hasAnyAuthority("Administrateur");
        //http.authorizeRequests().antMatchers(HttpMethod.GET, "/users/**").hasAnyAuthority("USER");*/
        //Pour la securite backend
        //http.formLogin();

        http.authorizeRequests().anyRequest().authenticated();
        //Gestion des filters
        http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
