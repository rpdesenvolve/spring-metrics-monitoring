package br.com.rpdesenvolve.spring_metrics_monitoring.domain.service;

import br.com.rpdesenvolve.spring_metrics_monitoring.domain.model.Book;
import br.com.rpdesenvolve.spring_metrics_monitoring.port.in.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements br.com.rpdesenvolve.spring_metrics_monitoring.port.out.BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitleIgnoringCase(title);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthorIgnoringCase(author);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }
}
