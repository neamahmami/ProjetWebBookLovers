package be.heh.projetBook.application.port.in;

import be.heh.projetBook.application.domain.model.BookInfo;

import java.util.Collection;
import java.util.List;

public interface SearchBookUseCase {
    public List<BookInfo> GetBooksInformations (String title);
}
