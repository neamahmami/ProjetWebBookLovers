package be.heh.projetBook.adapter.out.persistence;

import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.port.out.ShowList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class ShowFavoritesListRepository implements ShowList {

    private final JdbcTemplate jdbc;

    public ShowFavoritesListRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public ArrayList<BookInfo> ShowFavorites() {
        String sql = "SELECT * FROM favtable";
        try {
            log.info("Executing SQL query: {}", sql);
            // Utilisation de BeanPropertyRowMapper pour mapper automatiquement les résultats à un objet BookInfo
            List<BookInfo> favorites = jdbc.query(sql, new BeanPropertyRowMapper<>(BookInfo.class));
            return new ArrayList<>(favorites);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("*********" + sql);
            return new ArrayList<>(); // Ou lancez une exception appropriée selon le cas
        }
    }
}
