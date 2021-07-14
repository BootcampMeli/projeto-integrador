package com.mercadolibre.projetointegrador.config;

import com.mercadolibre.projetointegrador.security.JWTAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/sign-in").permitAll()
                .antMatchers(HttpMethod.GET, "/ping").permitAll()
                .antMatchers(HttpMethod.GET, "/v3/api-docs").permitAll()
                .antMatchers(HttpMethod.GET, "/fake").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/fresh-products/inboundorder").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/fresh-products/inboundorder").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/fresh-products/orders").hasAnyAuthority("ROLE_BUYER", "ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/fresh-products/orders").hasAnyAuthority("ROLE_BUYER", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/duedate").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/duedate/list").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                //products
                .antMatchers(HttpMethod.POST, "/api/v1/fresh-products/seller/{id}/create").hasAnyAuthority("ROLE_SELLER","ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/id/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/name/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/seller/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/section/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/warehouse/").permitAll()
                // buyers
                .antMatchers(HttpMethod.POST, "/api/v1/fresh-products/buyers/create").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/buyers/").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/buyers/id/").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/buyers/name/").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                // sellers
                .antMatchers(HttpMethod.POST, "/api/v1/fresh-products/sellers/create").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/sellers/").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/sellers/id/").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/sellers/name/").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                // employees
                .antMatchers(HttpMethod.POST, "/api/v1/fresh-products/employees/create").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/employees/").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/employees/id/").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/employees/name/").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                // supervisors
                .antMatchers(HttpMethod.POST, "/api/v1/fresh-products/supervisors/create").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/supervisors/").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/supervisors/id/").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/supervisors/name/").hasAnyAuthority("ROLE_SUPERVISOR", "ROLE_ADMIN")

                .anyRequest().authenticated();
    }
}
