
package com.egg.biblioteca;

import com.egg.biblioteca.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author javer
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SeguridadWeb {
    
    @Autowired
    public UsuarioServicio usuarioServicio;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{ //configurar la seguridad
        auth.userDetailsService(usuarioServicio)     //autenticar usuario al registrarse
                .passwordEncoder(new BCryptPasswordEncoder()); //codificar contraseñas
    }
    
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(request -> request.requestMatchers("/css/*","/js/*","/img/*","/login","/registrar","/" )
                .permitAll().anyRequest().authenticated());

        http.formLogin(form -> form.loginPage("/login").permitAll())
                        .logout(LogoutConfigurer::permitAll);

        return http.build();
     //   http
                /*.authorizeRequests()
                    .antMatchers("/css/*","/js/*","/img/*")
                    .permitAll()
    
                .and().formLogin()    //formulario login
                        .loginPage("/login")
                        .loginProcessingUrl("/logincheck")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/inicio")  //login exitoso, redireccionar a url de incio 
                        .permitAll()
                .and().logout()         //salida de login
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/") //exitoso, ir a url de index
                        .permitAll();*/
                
//                .and().csrf()
//                        .disable();
    }
    
    
}
