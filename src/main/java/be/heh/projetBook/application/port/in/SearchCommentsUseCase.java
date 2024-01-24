package be.heh.projetBook.application.port.in;

import java.util.List;

public interface SearchCommentsUseCase {

    public List<String> fetchComments(String isbn);
}
