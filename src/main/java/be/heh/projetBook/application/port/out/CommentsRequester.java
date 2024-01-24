package be.heh.projetBook.application.port.out;

import java.util.List;

public interface CommentsRequester {

    public List<String> routeComments(String isbn);
}
