package be.heh.projetbook.application.domain.service;

import be.heh.projetBook.application.domain.service.AddCommentsImplementation;
import be.heh.projetBook.application.port.out.SavingComments;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddCommentsImplementationTest {

    String comment = "myComment";
    String isbn = "123456";

    @Test
    public void shouldAddComment(){
        SavingComments savingComments = mock(SavingComments.class);
        AddCommentsImplementation addComments = new AddCommentsImplementation(savingComments);
        addComments.leaveAComment(comment,isbn);
        verify(savingComments).savecomment(comment,isbn);
    }
}
