package be.heh.projetBook.application.domain.service;

import be.heh.projetBook.application.domain.model.BookInfo;
import be.heh.projetBook.application.port.in.SearchBookUseCase;
import be.heh.projetBook.application.port.out.ApiRequester;

import java.util.List;

public class SearchBookImplementation implements SearchBookUseCase {

    private final ApiRequester newRequest;

    public SearchBookImplementation(ApiRequester newRequest){
        this.newRequest = newRequest;
    }


    @Override
    public List<BookInfo> GetBooksInformations(String title){
        //RequesterToTheBooksApi newRequest;
        return newRequest.RequestBookInfos(title);
    }

}
