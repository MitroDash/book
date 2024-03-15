package telran.java51.book.dao;

import java.util.Optional;
import java.util.stream.Stream;

import telran.java51.book.model.Book;


public interface BookRepository {
	
	Stream<Book> findByAuthorsName(String author);
	
	Stream<Book> findByPublisherPublisherName(String publisher);

	void deleteByAuthorsName(String author);
	
	Book save(Book book);
	
	Optional<Book> findById(String isbn);

	boolean existsById(String isbn);

	void deleteById(String isbn);

}
