package be.heh.projetBook.adapter.out.persistence;
import be.heh.projetBook.adapter.apiResources.ApiDocs;
import be.heh.projetBook.adapter.apiResources.ApiResponse;
import be.heh.projetBook.adapter.apiResources.BookInfoRowMapper;
import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.port.out.ApiRequester;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchBookRepository implements ApiRequester {


    private final RestTemplate restTemplate;
    private final JdbcTemplate jdbcTemplate;

    public SearchBookRepository(RestTemplate restTemplate, JdbcTemplate jdbcTemplate) {
        this.restTemplate = restTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<BookInfo> RequestBookInfos(String title){
        String sql = "SELECT * FROM booklist WHERE title = ?";
        List<BookInfo> bookListInfo = jdbcTemplate.query(sql, new Object[]{title}, new BookInfoRowMapper());
        String bookName = title.replace(' ','+');
        String origin = "https://openlibrary.org/";
        String url = origin+"/search.json?q="+bookName;
        ApiResponse response = restTemplate.getForObject(url,ApiResponse.class);
        //JsonDeserialize response = restTemplate.getForObject(url, JsonDeserialize.class);
        
        List<ApiDocs> docs = response.getDocs();
        List<BookInfo> maliste = new ArrayList<>();
        if(!bookListInfo.isEmpty()){
            maliste.addAll(bookListInfo);
        }
        else{
            if (response != null && docs!= null && !docs.isEmpty()) {

                for (ApiDocs doc : docs) {
                    if (doc.getTitle().toUpperCase().contains(title.toUpperCase())) {
                        BookInfo book = new BookInfo("test", "test", "test", "test", "1234", 0);
                        String key = doc.getKey();
                        String urlDescription = origin + key + ".json";
                        JsonNode responseDescription = restTemplate.getForObject(urlDescription, JsonNode.class);
                        book.setIsbn(doc.getKey());
                        String authors = "";
                        if (doc.getAuthorName() != null) {
                            for (String author : doc.getAuthorName()) {
                                authors = author + ',';
                            }
                        } else {
                            authors = null;
                        }
                        String isbn = "";
                        if (doc.getIsbn() != null) {
                            for (String id : doc.getIsbn()) {
                                isbn = id + ',';
                            }
                        } else {
                            isbn = null;
                        }
                        book.setTitle(doc.getTitle());
                        book.setAuthor(authors);
                        book.setIsbn(isbn);
                        book.setCover(doc.getCoverI() != null ? "https://covers.openlibrary.org/b/id/" + doc.getCoverI() + "-L.jpg" : null);

                        if (responseDescription == null || responseDescription.get("description") == null) {
                            book.setSummary(null);
                        } else {
                            String res = responseDescription.get("description").toString();

                            if (res.startsWith("{")) {
                                String resume = responseDescription.get("description").get("value").asText();
                                book.setSummary(resume);
                            } else {
                                book.setSummary(res);
                            }
                        }
                        maliste.add(book);
                    }
                }
            }
        }
        return maliste;
    }
}
