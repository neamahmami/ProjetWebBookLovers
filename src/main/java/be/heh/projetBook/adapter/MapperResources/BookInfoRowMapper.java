package be.heh.projetBook.adapter.MapperResources;

import be.heh.projetBook.application.domain.model.BookInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookInfoRowMapper implements RowMapper<BookInfo> {

    @Override
    public BookInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BookInfo(rs.getString("title"),rs.getString("author"),rs.getString("summary"),
                rs.getString("cover"),rs.getString("isbn"),rs.getDouble("rate"));
    }
}
