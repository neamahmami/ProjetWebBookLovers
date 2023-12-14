package be.heh.projetBook.adapter.out.persistence;

import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.port.out.AddNewBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class CreateBookRepository implements AddNewBook {
    private final JdbcTemplate jdbc;

    public CreateBookRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public void addBook(BookInfo book){
        String req = "INSERT INTO my_db.booklist VALUES (?,?,?,?,?,?)";
try {
    jdbc.update(req,
            book.getIsbn(),
            book.getTitle(),
            book.getAuthor(),
            book.getSummary(),
            book.getCover(),
            book.getRate());
}
     catch (Exception e) {
         e.printStackTrace();
         log.error("*********" + req);
     }

    }
}
