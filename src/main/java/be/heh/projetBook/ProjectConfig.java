package be.heh.projetBook;

import be.heh.projetBook.adapter.out.persistence.CreateBookRepository;
import be.heh.projetBook.application.domain.service.CreateBookImplementation;
import be.heh.projetBook.application.port.in.CreateBookUseCase;
import be.heh.projetBook.application.port.out.AddNewBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

//@Configuration
public class ProjectConfig {
    //@Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    CreateBookUseCase getCreateBookUseCase(){
        return new CreateBookImplementation(new CreateBookRepository(jdbcTemplate));
    }

}
