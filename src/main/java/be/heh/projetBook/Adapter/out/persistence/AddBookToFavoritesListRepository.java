package be.heh.projetBook.Adapter.out.persistence;

import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.domain.model.Favorites;
import be.heh.projetBook.application.port.out.AddingTheBookToFavoritesList;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;

@Repository
public class AddBookToFavoritesListRepository implements AddingTheBookToFavoritesList {
    private final JdbcTemplate jdbc;
    private final BeanNameUrlHandlerMapping bean;

    public AddBookToFavoritesListRepository(JdbcTemplate jdbc, BeanNameUrlHandlerMapping bean) {
        this.jdbc = jdbc;
        this.bean = bean;
    }
@Override

    public void addFavoriteBook(BookInfo book) {

        try {
                String req = "INSERT INTO my_db.favoritesList VALUES (?,?,?,?,?,?)";
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
                    throw new RuntimeException("Erreur lors de l'ajout du livre à la base de données.", e);
                }


            System.out.println("Le livre a été ajouté à la base de données.");

        } catch (Exception e) {

        }
    }
   /* public boolean isBookInDatabase(double isbn) {
        try {
            String query = "SELECT COUNT(*) FROM FavoritesDB.favoritesTable WHERE isbn = ?";
            int count = jdbc.queryForObject(query, Integer.class, isbn);
            return count > 0;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la vérification du livre dans la base de données.", e);
        }
    }*/



}
