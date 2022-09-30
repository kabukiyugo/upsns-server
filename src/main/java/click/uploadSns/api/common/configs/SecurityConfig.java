// package click.uploadSns.api.common.configs;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// import click.uploadSns.api.domain.services.LoginService;
// import lombok.NonNull;
// import lombok.RequiredArgsConstructor;

// @EnableWebSecurity
// @Configuration
// @RequiredArgsConstructor
// public class SecurityConfig {
// @NonNull
// private final LoginService _loginService;

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
// Exception {
// http.formLogin(login -> login
// .loginProcessingUrl("/login")
// .loginPage("/login")
// .usernameParameter("code")
// .passwordParameter("pass")
// .defaultSuccessUrl("/timeline")
// .failureUrl("/login?error")
// .permitAll()).logout(logout -> logout
// .logoutSuccessUrl("/login?logout"))
// .authorizeHttpRequests(auth -> auth
// .mvcMatchers("/").permitAll()
// .mvcMatchers("/general").hasRole("GENERAL")
// .mvcMatchers("/admin").hasRole("ADMIN")
// .anyRequest().authenticated());
// return http.build();
// }

// @Bean
// public PasswordEncoder passwordEncoder() {
// return new BCryptPasswordEncoder();
// }

// public void configure(AuthenticationManagerBuilder/* 認証用
// loadUserByUsernameを呼ぶ */ auth) throws Exception {
// auth.userDetailsService(this._loginService)
// .passwordEncoder(this.passwordEncoder());
// }
// }
