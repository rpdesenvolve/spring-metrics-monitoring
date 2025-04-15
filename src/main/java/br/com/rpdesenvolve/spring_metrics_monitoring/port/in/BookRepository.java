package br.com.rpdesenvolve.spring_metrics_monitoring.port.in;

import br.com.rpdesenvolve.spring_metrics_monitoring.domain.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findByTitleIgnoringCase(String title);

    List<Book> findByAuthorIgnoringCase(String author);
}
