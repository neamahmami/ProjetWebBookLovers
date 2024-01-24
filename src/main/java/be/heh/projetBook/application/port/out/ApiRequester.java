package be.heh.projetBook.application.port.out;

import be.heh.projetBook.application.domain.model.BookInfo;

import java.util.List;

public interface ApiRequester {
    public List<BookInfo> RequestBookInfos(String title);
}
