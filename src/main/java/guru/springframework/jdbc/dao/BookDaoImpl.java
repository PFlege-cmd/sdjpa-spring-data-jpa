package guru.springframework.jdbc.dao;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import guru.springframework.jdbc.domain.Book;
import guru.springframework.jdbc.repositories.BookRepository;

@Repository
public class BookDaoImpl implements BookDao {

    private final BookRepository bookRepository;

    BookDaoImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override public Book getById(Long id) {
        return bookRepository.getById(id);
    }

//    @Override public Optional<Book> findBookByTitle(String title) {
//        Optional<Book> bookByTitle = bookRepository.findBookByTitle(title);
//        bookByTitle.ifPresentOrElse(book -> {}, () -> {throw new EntityNotFoundException();});
//        return bookByTitle;
//    }

    @Override public Book findBookByTitleNullApi(String title) {

        return bookRepository.findBookByTitle(title);
    }

    @Override public Book saveNewBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    @Override public Book updateBook(Book book) {
        Book fetchedBook = bookRepository.getById(book.getId());
        fetchedBook.setTitle(book.getTitle());
        fetchedBook.setIsbn(book.getIsbn());
        fetchedBook.setPublisher(book.getPublisher());
        fetchedBook.setAuthorId(book.getAuthorId());
        return bookRepository.save(fetchedBook);
    }

    @Override public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
