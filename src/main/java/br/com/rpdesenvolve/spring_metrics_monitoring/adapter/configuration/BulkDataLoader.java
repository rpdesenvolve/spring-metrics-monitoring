package br.com.rpdesenvolve.spring_metrics_monitoring.adapter.configuration;

import br.com.rpdesenvolve.spring_metrics_monitoring.domain.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration
@Slf4j
public class BulkDataLoader {

    @Bean
    public CommandLineRunner loadData(MongoOperations mongoOperations) {
        return args -> {
           mongoOperations.dropCollection(Book.class);
           log.info("Dropping collection book");
           mongoOperations.createCollection(Book.class);
           log.info("Creating collection book");
           loadBookInfo().forEach(mongoOperations::save);
           log.info("Loading book data");
        };
    }

   private List<Book> loadBookInfo() {
       return IOUtils.readLines(Objects.requireNonNull(getClass().getResourceAsStream("/data/book-list.txt")), "utf-8")
               .stream()
               .map(this::toMap)
               .collect(Collectors.toList());
   }

    private Book toMap(String line) {
        String[] book = line.split(";");
        return Book
                .builder()
                .title(book[0])
                .author(book[1])
                .build();
    }
}
