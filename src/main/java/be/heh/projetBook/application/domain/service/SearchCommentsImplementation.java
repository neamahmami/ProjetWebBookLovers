package be.heh.projetBook.application.domain.service;

import be.heh.projetBook.application.port.in.SearchCommentsUseCase;
import be.heh.projetBook.application.port.out.CommentsRequester;

import java.util.List;

public class SearchCommentsImplementation implements SearchCommentsUseCase {

    private final CommentsRequester commentsRequester;

    public SearchCommentsImplementation(CommentsRequester commentsRequester) {
        this.commentsRequester = commentsRequester;
    }

    @Override
    public List<String> fetchComments(String isbn) {
        return commentsRequester.routeComments(isbn);
    }
}
