package be.heh.projetBook.application.domain.service;

import be.heh.projetBook.application.port.in.AddCommentsUseCase;
import be.heh.projetBook.application.port.out.SavingComments;

public class AddCommentsImplementation implements AddCommentsUseCase {
    private final SavingComments savingComments;

    public AddCommentsImplementation(SavingComments savingComments) {
        this.savingComments = savingComments;
    }

    @Override
    public void leaveAComment(String comment, String Isbn) {
        savingComments.savecomment(comment,Isbn);
    }
}
