package pl.coderslab.charity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@SpringBootApplication
public class CharityApplication {

    public static void main(String[] args) {

        SpringApplication.run(CharityApplication.class, args);
    }


    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/login", "/register", "/css/**", "/js/**", "/images/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .successForwardUrl("/")
                        .failureUrl("/login/fail")
                        .permitAll()
                )
                .logout(logout -> logout
                    .logoutUrl("/logout") // URL do wylogowania
                    .logoutSuccessUrl("/") // URL po wylogowaniu
                    .invalidateHttpSession(true) // Unieważnij sesję
                    .deleteCookies("JSESSIONID") // Usuń ciasteczka sesji
                    .permitAll()
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedPage("/403"))
                .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
