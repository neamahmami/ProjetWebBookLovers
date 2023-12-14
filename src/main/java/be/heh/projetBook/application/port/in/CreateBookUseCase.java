package be.heh.projetBook.application.port.in;

import be.heh.projetBook.application.domain.model.BookInfo;

public interface CreateBookUseCase {
    public void addTheBook(BookInfo book);
}
