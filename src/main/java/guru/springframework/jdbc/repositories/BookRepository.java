package guru.springframework.jdbc.repositories;

import java.util.Optional;

import guru.springframework.jdbc.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    //Optional<Book> findBookByTitle(String title);

    Book findBookByTitle(String title);
}
