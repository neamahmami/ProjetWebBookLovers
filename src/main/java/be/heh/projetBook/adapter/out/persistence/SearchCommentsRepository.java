package be.heh.projetBook.adapter.out.persistence;

import be.heh.projetBook.adapter.MapperResources.CommentsRowMapper;
import be.heh.projetBook.application.port.out.CommentsRequester;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchCommentsRepository implements CommentsRequester {
    private final JdbcTemplate jdbc;

    public SearchCommentsRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<String> routeComments(String isbn) {
        String sql = "SELECT * FROM my_db.commentlist WHERE isbn = ?";
        List<String> commentsList = jdbc.query(sql, new Object[]{isbn}, new CommentsRowMapper());
        return commentsList;
    }
}
