package be.heh.projetBook;

import be.heh.projetBook.adapter.out.persistence.CreateBookRepository;
import be.heh.projetBook.application.domain.service.CreateBookImplementation;
import be.heh.projetBook.application.port.in.CreateBookUseCase;
import be.heh.projetBook.application.port.out.AddNewBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class ProjectConfig {
    //@Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    CreateBookUseCase getCreateBookUseCase(){
        return new CreateBookImplementation(new CreateBookRepository(jdbcTemplate));
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:3000");
        config.addAllowedHeader("*");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");

        CorsConfigurationSource source = request -> config;

        return new CorsFilter(source);

    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
