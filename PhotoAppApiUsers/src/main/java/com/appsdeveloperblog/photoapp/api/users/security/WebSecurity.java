package com.appsdeveloperblog.photoapp.api.users.security;


import com.appsdeveloperblog.photoapp.api.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private Environment env;
    private UsersService usersService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public WebSecurity(Environment env, UsersService userService, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.env = env;
        this.usersService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/users/**")// only access via this path pattern
                .hasIpAddress(env.getProperty("gateway.ip")) //only access api through zuul gateway
                .and()
                .addFilter(getAuthenticationFilter()); // use filter defined below with 1) attemptAuthentication and 2) successfulAuthentication
        http.headers().frameOptions().disable(); // so we can see h2 console
        http.formLogin().loginPage("/users/login");
    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception{
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(usersService, env, authenticationManager());
        authenticationFilter.setFilterProcessesUrl(env.getProperty("login.url.path"));
        return authenticationFilter;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersService).passwordEncoder(bCryptPasswordEncoder);
    }
}
