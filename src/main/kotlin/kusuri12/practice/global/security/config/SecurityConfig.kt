package kusuri12.practice.global.security.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun configure(httpSecurity: HttpSecurity): SecurityFilterChain {
        return httpSecurity
            .csrf(CsrfConfigurer<HttpSecurity>::disable)
            .formLogin(FormLoginConfigurer<HttpSecurity>::disable)
            .logout(LogoutConfigurer<HttpSecurity>::disable)
            .cors { }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }

            .authorizeHttpRequests {
                it.requestMatchers("/auth/**").permitAll()

                it.requestMatchers(HttpMethod.GET, "/board").permitAll()
                it.requestMatchers(HttpMethod.POST, "/board").authenticated()

                it.anyRequest().authenticated()
            }

            .build()
    }
}