package telran.java51.book.dao;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.java51.book.model.Book;
import telran.java51.book.model.Publisher;


public interface BookRepository extends JpaRepository<Book, String> {
	
	Stream<Book> findByPublisher(Publisher publisher);

}
