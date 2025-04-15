package br.com.rpdesenvolve.spring_metrics_monitoring.port.out;

import br.com.rpdesenvolve.spring_metrics_monitoring.domain.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book addBook(Book book);

    List<Book> getBooksByTitle(String title);

    List<Book> getBooksByAuthor(String author);

    void deleteBook(String id);
}
