package be.heh.projetBook.adapter.in.web;

import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.port.out.ApiRequester;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SearchBook {
     ApiRequester searchApi;

    public SearchBook(ApiRequester searchApi) {
        this.searchApi = searchApi;
    }

    @GetMapping("/book")
    public ResponseEntity<List<BookInfo>> returnBook(@RequestParam String title) {
        try {
            List<BookInfo> bookList = searchApi.RequestBookInfos(title);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(bookList);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
