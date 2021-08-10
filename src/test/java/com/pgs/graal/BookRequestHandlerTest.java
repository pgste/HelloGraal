package com.pgs.graal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BookRequestHandlerTest {

    private static BookRequestHandler handler;

    @BeforeAll
    public static void setupServer() {
        handler = new BookRequestHandler();
    }

    @AfterAll
    public static void stopServer() {
        if (handler != null) {
            handler.getApplicationContext().close();
        }
    }

    @Test
    void testHandler() {
        Book book = new Book();
        book.setName("Building Microservices");

        BookSaved saved = handler.execute(book);

        Assertions.assertNotNull(saved);
        Assertions.assertEquals(book.getName(), saved.getName());
        Assertions.assertNotNull(saved.getIsbn());
    }
}
