package be.heh.projetBook.adapter.out.persistence;

import be.heh.projetBook.application.port.out.SavingComments;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class AddCommentsRepository implements SavingComments {

    private final JdbcTemplate jdbc;

    public AddCommentsRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void savecomment(String comment, String isbn) {
        String req = "INSERT INTO commentlist VALUES (DEFAULT,?,?)";
        try {
            jdbc.update(req,
                    isbn,
                    comment);
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("*********" + req);
        }

    }
}
